package com.news.hr.system.service.impl;

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
import com.news.hr.system.bean.po.Post;
import com.news.hr.system.bean.query.PostQuery;
import com.news.hr.system.bean.form.PostForm;
import com.news.hr.system.bean.vo.PostVo;
import com.news.hr.system.bean.convert.PostConvert;
import com.news.hr.system.mapper.PostMapper;
import com.news.hr.system.service.PostService;
/**
 * <p>
 * 岗位 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Resource
    private PostMapper postMapper;

    @Override
    public Integer save(PostForm record) {
        Post post = PostConvert.convertToPoByForm(record);
        return postMapper.insert(post);
    }

    @Override
    public Integer updateById(PostForm record) {
        Post post = PostConvert.convertToPoByForm(record);
        return postMapper.updateById(post);
    }

    @Override
    public Integer deleteById(String id) {
        return postMapper.deleteById(id);
    }

    @Override
    public PostVo selectById(String id) {
        Post post = postMapper.selectById(id);
        PostVo postVo = PostConvert.convertToVoByPo(post);
        return postVo;
    }

    @Override
    public IPage<PostVo> selectPage(PostQuery postQuery){
        QueryWrapper<Post> queryWrapper=new QueryWrapper<Post>();
        Page<Post> page = new Page<>(postQuery.getPage(), postQuery.getLimit());
        getQueryWrapper(queryWrapper, postQuery);
        IPage<Post> pagePost = postMapper.selectPage(page, queryWrapper);
        IPage<PostVo> pageResult = new Page<>();
        pageResult.setRecords(PostConvert.convertToVoByPo(pagePost.getRecords()));
        pageResult.setCurrent(pagePost.getCurrent());
        pageResult.setSize(pagePost.getSize());
        pageResult.setTotal(pagePost.getTotal());
        pageResult.setPages(pagePost.getPages());
        return pageResult;
    }

    @Override
    public List<PostVo> selectList(PostQuery postQuery){
        QueryWrapper<Post> queryWrapper=new QueryWrapper<Post>();
        getQueryWrapper(queryWrapper, postQuery);
        List<Post> list = postMapper.selectList(queryWrapper);
        return PostConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Post post = postMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Post> queryWrapper=new QueryWrapper<Post>();
        queryWrapper.lambda().in(Post::getPostId, ids);
        List<Post> posts = postMapper.selectList(queryWrapper);
        //BeanUtils.set(posts, Post::getPostId, Post::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Post> getQueryWrapper(QueryWrapper<Post> queryWrapper,PostQuery postQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
