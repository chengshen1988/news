package com.news.hr.business.service.impl;

import java.util.List;
import javax.annotation.Resource;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.news.hr.framework.utils.BeanUtils;
import com.news.hr.business.bean.po.Level;
import com.news.hr.business.bean.query.LevelQuery;
import com.news.hr.business.bean.form.LevelForm;
import com.news.hr.business.bean.vo.LevelVo;
import com.news.hr.business.bean.convert.LevelConvert;
import com.news.hr.business.mapper.LevelMapper;
import com.news.hr.business.service.LevelService;
/**
 * <p>
 * 分类管理 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LevelServiceImpl extends ServiceImpl<LevelMapper, Level> implements LevelService {

    @Resource
    private LevelMapper levelMapper;

    @Override
    public Integer save(LevelForm record) {
        Level level = LevelConvert.convertToPoByForm(record);
        return levelMapper.insert(level);
    }

    @Override
    public Integer updateById(LevelForm record) {
        Level level = LevelConvert.convertToPoByForm(record);
        return levelMapper.updateById(level);
    }

    @Override
    public Integer deleteById(String id) {
        return levelMapper.deleteById(id);
    }

    @Override
    public LevelVo selectById(String id) {
        Level level = levelMapper.selectById(id);
        LevelVo levelVo = LevelConvert.convertToVoByPo(level);
        return levelVo;
    }

    @Override
    public IPage<LevelVo> selectPage(LevelQuery levelQuery){
        QueryWrapper<Level> queryWrapper=new QueryWrapper<Level>();
        Page<Level> page = new Page<>(levelQuery.getPage(), levelQuery.getLimit());
        getQueryWrapper(queryWrapper, levelQuery);
        IPage<Level> pageLevel = levelMapper.selectPage(page, queryWrapper);
        IPage<LevelVo> pageResult = new Page<>();
        pageResult.setRecords(LevelConvert.convertToVoByPo(pageLevel.getRecords()));
        pageResult.setCurrent(pageLevel.getCurrent());
        pageResult.setSize(pageLevel.getSize());
        pageResult.setTotal(pageLevel.getTotal());
        pageResult.setPages(pageLevel.getPages());
        return pageResult;
    }

    @Override
    public List<LevelVo> selectList(LevelQuery levelQuery){
        QueryWrapper<Level> queryWrapper=new QueryWrapper<Level>();
        getQueryWrapper(queryWrapper, levelQuery);
        List<Level> list = levelMapper.selectList(queryWrapper);
        return LevelConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Level level = levelMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Level> queryWrapper=new QueryWrapper<Level>();
        queryWrapper.lambda().in(Level::getLevelId, ids);
        List<Level> levels = levelMapper.selectList(queryWrapper);
        //BeanUtils.set(levels, Level::getLevelId, Level::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Level> getQueryWrapper(QueryWrapper<Level> queryWrapper,LevelQuery levelQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
