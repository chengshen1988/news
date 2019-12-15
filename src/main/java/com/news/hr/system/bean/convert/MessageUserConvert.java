package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.MessageUser;
import com.news.hr.system.bean.form.MessageUserForm;
import com.news.hr.system.bean.vo.MessageUserVo;
import com.news.hr.system.bean.dto.MessageUserImport;
import com.news.hr.system.bean.dto.MessageUserExport;
/**
 * <p>
 * MessageUserConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class MessageUserConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static MessageUser convertToPoByForm(MessageUserForm source){
        MessageUser target = new MessageUser();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static MessageUserVo convertToVoByPo(MessageUser source){
        MessageUserVo target = new MessageUserVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<MessageUserVo> convertToVoByPo(List<MessageUser> sources){
        List<MessageUserVo> messageUsers = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return messageUsers;
        }
        for (MessageUser source : sources) {
            MessageUserVo target = new MessageUserVo();
            BeanUtils.copyProperties(source, target);
            messageUsers.add(target);
        }
        return messageUsers;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<MessageUser> convertToPoByImport(List<MessageUserImport> sources){
        List<MessageUser> messageUsers = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return messageUsers;
        }
        for (MessageUserImport source : sources) {
            MessageUser target = new MessageUser();
            BeanUtils.copyProperties(source, target);
            messageUsers.add(target);
        }
        return messageUsers;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<MessageUserExport> convertToExportByPo(List<MessageUser> sources){
        List<MessageUserExport> messageUserExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return messageUserExports;
        }
        for (MessageUser source : sources) {
            MessageUserExport target = new MessageUserExport();
            BeanUtils.copyProperties(source, target);
            messageUserExports.add(target);
        }
        return messageUserExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<MessageUserExport> convertToExportByVo(List<MessageUserVo> sources){
        List<MessageUserExport> messageUserExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return messageUserExports;
        }
        for (MessageUserVo source : sources) {
            MessageUserExport target = new MessageUserExport();
            BeanUtils.copyProperties(source, target);
            messageUserExports.add(target);
        }
        return messageUserExports;
    }

}