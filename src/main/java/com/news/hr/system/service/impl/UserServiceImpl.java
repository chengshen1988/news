package com.news.hr.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.news.hr.framework.config.security.entity.UserSession;
import com.news.hr.framework.utils.BeanUtils;
import com.news.hr.system.bean.convert.UserConvert;
import com.news.hr.system.bean.form.UserForm;
import com.news.hr.system.bean.po.User;
import com.news.hr.system.bean.query.UserQuery;
import com.news.hr.system.bean.query.UserRoleQuery;
import com.news.hr.system.bean.vo.UserRoleVo;
import com.news.hr.system.bean.vo.UserVo;
import com.news.hr.system.mapper.UserMapper;
import com.news.hr.system.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoleService roleService;
    @Resource
    private OrgService orgService;
    @Resource
    private PostService postService;
    @Resource
    private PermissionService permissionService;


    @Override
    public Integer save(UserForm record) {
        User user = UserConvert.convertToPoByForm(record);
        return userMapper.insert(user);
    }

    @Override
    public Integer updateById(UserForm record) {
        User user = UserConvert.convertToPoByForm(record);
        return userMapper.updateById(user);
    }

    @Override
    public Integer deleteById(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public UserVo selectById(String id) {
        User user = userMapper.selectById(id);
        UserVo userVo = UserConvert.convertToVoByPo(user);
        return userVo;
    }

    @Override
    public IPage<UserVo> selectPage(UserQuery userQuery){
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        Page<User> page = new Page<>(userQuery.getPage(), userQuery.getLimit());
        getQueryWrapper(queryWrapper, userQuery);
        IPage<User> pageUser = userMapper.selectPage(page, queryWrapper);
        IPage<UserVo> pageResult = new Page<>();
        pageResult.setRecords(UserConvert.convertToVoByPo(pageUser.getRecords()));
        pageResult.setCurrent(pageUser.getCurrent());
        pageResult.setSize(pageUser.getSize());
        pageResult.setTotal(pageUser.getTotal());
        pageResult.setPages(pageUser.getPages());
        return pageResult;
    }

    @Override
    public List<UserVo> selectList(UserQuery userQuery){
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        getQueryWrapper(queryWrapper, userQuery);
        List<User> list = userMapper.selectList(queryWrapper);
        return UserConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        User user = userMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.lambda().in(User::getUserId, ids);
        List<User> users = userMapper.selectList(queryWrapper);
        //BeanUtils.set(users, User::getUserId, User::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<User> getQueryWrapper(QueryWrapper<User> queryWrapper,UserQuery userQuery){
        queryWrapper.lambda()
                .eq(StrUtil.isNotBlank(userQuery.getUserId()),User::getUserId,userQuery.getUserId())
                .eq(StrUtil.isNotBlank(userQuery.getUserCode()),User::getUserCode,userQuery.getUserCode())
                .eq(StrUtil.isNotBlank(userQuery.getUsername()),User::getUsername,userQuery.getUsername())
                .eq(StrUtil.isNotBlank(userQuery.getUserMobile()),User::getUserMobile,userQuery.getUserMobile())
                .eq(StrUtil.isNotBlank(userQuery.getUserMail()),User::getUserMail,userQuery.getUserMail())
                ;
        return queryWrapper;
    }

    /*******************通用方法结束**********************/


    /**
     * 获取用户
     * @author Chen Seen
     * @param userQuery :
     * @return com.news.hr.framework.config.security.entity.UserSession
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @date 2019/12/15 4:22
     */
    @Override
    public UserSession getUserSession(UserQuery userQuery)  {
              List<UserVo> userVos = selectList(userQuery);
              UserSession userSession = UserSession.builder().build();
        if (userVos.size()>0){
            UserVo userVo = userVos.get(0);
            try {
                BeanUtils.copyProperties(userSession,userVo);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            //获取角色信息
            final UserRoleQuery userRoleQuery = UserRoleQuery.builder()
                    .userId(userVo.getUserId())
                    .build();
            final List<UserRoleVo> userRoleVos = userRoleService.selectList(userRoleQuery);
            //获取资源信息



            return userSession;

        }


        return null;
    }
}
