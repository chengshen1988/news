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
import com.news.hr.system.bean.po.File;
import com.news.hr.system.bean.query.FileQuery;
import com.news.hr.system.bean.form.FileForm;
import com.news.hr.system.bean.vo.FileVo;
import com.news.hr.system.bean.convert.FileConvert;
import com.news.hr.system.mapper.FileMapper;
import com.news.hr.system.service.FileService;
/**
 * <p>
 * 文件 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    @Resource
    private FileMapper fileMapper;

    @Override
    public Integer save(FileForm record) {
        File file = FileConvert.convertToPoByForm(record);
        return fileMapper.insert(file);
    }

    @Override
    public Integer updateById(FileForm record) {
        File file = FileConvert.convertToPoByForm(record);
        return fileMapper.updateById(file);
    }

    @Override
    public Integer deleteById(String id) {
        return fileMapper.deleteById(id);
    }

    @Override
    public FileVo selectById(String id) {
        File file = fileMapper.selectById(id);
        FileVo fileVo = FileConvert.convertToVoByPo(file);
        return fileVo;
    }

    @Override
    public IPage<FileVo> selectPage(FileQuery fileQuery){
        QueryWrapper<File> queryWrapper=new QueryWrapper<File>();
        Page<File> page = new Page<>(fileQuery.getPage(), fileQuery.getLimit());
        getQueryWrapper(queryWrapper, fileQuery);
        IPage<File> pageFile = fileMapper.selectPage(page, queryWrapper);
        IPage<FileVo> pageResult = new Page<>();
        pageResult.setRecords(FileConvert.convertToVoByPo(pageFile.getRecords()));
        pageResult.setCurrent(pageFile.getCurrent());
        pageResult.setSize(pageFile.getSize());
        pageResult.setTotal(pageFile.getTotal());
        pageResult.setPages(pageFile.getPages());
        return pageResult;
    }

    @Override
    public List<FileVo> selectList(FileQuery fileQuery){
        QueryWrapper<File> queryWrapper=new QueryWrapper<File>();
        getQueryWrapper(queryWrapper, fileQuery);
        List<File> list = fileMapper.selectList(queryWrapper);
        return FileConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        File file = fileMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<File> queryWrapper=new QueryWrapper<File>();
        queryWrapper.lambda().in(File::getFileId, ids);
        List<File> files = fileMapper.selectList(queryWrapper);
        //BeanUtils.set(files, File::getFileId, File::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<File> getQueryWrapper(QueryWrapper<File> queryWrapper,FileQuery fileQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
