package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Message;
import com.news.hr.system.bean.form.MessageForm;
import com.news.hr.system.bean.vo.MessageVo;
import com.news.hr.system.bean.dto.MessageImport;
import com.news.hr.system.bean.dto.MessageExport;
/**
 * <p>
 * MessageConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class MessageConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Message convertToPoByForm(MessageForm source){
        Message target = new Message();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static MessageVo convertToVoByPo(Message source){
        MessageVo target = new MessageVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<MessageVo> convertToVoByPo(List<Message> sources){
        List<MessageVo> messages = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return messages;
        }
        for (Message source : sources) {
            MessageVo target = new MessageVo();
            BeanUtils.copyProperties(source, target);
            messages.add(target);
        }
        return messages;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Message> convertToPoByImport(List<MessageImport> sources){
        List<Message> messages = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return messages;
        }
        for (MessageImport source : sources) {
            Message target = new Message();
            BeanUtils.copyProperties(source, target);
            messages.add(target);
        }
        return messages;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<MessageExport> convertToExportByPo(List<Message> sources){
        List<MessageExport> messageExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return messageExports;
        }
        for (Message source : sources) {
            MessageExport target = new MessageExport();
            BeanUtils.copyProperties(source, target);
            messageExports.add(target);
        }
        return messageExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<MessageExport> convertToExportByVo(List<MessageVo> sources){
        List<MessageExport> messageExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return messageExports;
        }
        for (MessageVo source : sources) {
            MessageExport target = new MessageExport();
            BeanUtils.copyProperties(source, target);
            messageExports.add(target);
        }
        return messageExports;
    }

}