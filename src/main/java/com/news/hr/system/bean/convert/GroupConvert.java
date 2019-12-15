package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Group;
import com.news.hr.system.bean.form.GroupForm;
import com.news.hr.system.bean.vo.GroupVo;
import com.news.hr.system.bean.dto.GroupImport;
import com.news.hr.system.bean.dto.GroupExport;
/**
 * <p>
 * GroupConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class GroupConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Group convertToPoByForm(GroupForm source){
        Group target = new Group();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static GroupVo convertToVoByPo(Group source){
        GroupVo target = new GroupVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<GroupVo> convertToVoByPo(List<Group> sources){
        List<GroupVo> groups = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return groups;
        }
        for (Group source : sources) {
            GroupVo target = new GroupVo();
            BeanUtils.copyProperties(source, target);
            groups.add(target);
        }
        return groups;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Group> convertToPoByImport(List<GroupImport> sources){
        List<Group> groups = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return groups;
        }
        for (GroupImport source : sources) {
            Group target = new Group();
            BeanUtils.copyProperties(source, target);
            groups.add(target);
        }
        return groups;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<GroupExport> convertToExportByPo(List<Group> sources){
        List<GroupExport> groupExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return groupExports;
        }
        for (Group source : sources) {
            GroupExport target = new GroupExport();
            BeanUtils.copyProperties(source, target);
            groupExports.add(target);
        }
        return groupExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<GroupExport> convertToExportByVo(List<GroupVo> sources){
        List<GroupExport> groupExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return groupExports;
        }
        for (GroupVo source : sources) {
            GroupExport target = new GroupExport();
            BeanUtils.copyProperties(source, target);
            groupExports.add(target);
        }
        return groupExports;
    }

}