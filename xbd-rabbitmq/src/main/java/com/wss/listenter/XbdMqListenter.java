package com.wss.listenter;

import com.rabbitmq.client.Channel;
import com.wss.model.EventMessage;
import com.wss.xiaobudong.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Slf4j
@RabbitListener(queuesToDeclare = { @Queue("xbd_rabbitmq.add.link.queue") })
public class XbdMqListenter {

    @RabbitHandler
    public void msgHandler(EventMessage eventMessage, Message message, Channel channel){
         log.info("监听到消息ShortLinkAddLinkMQListener message消息内容:{}",message);
        String messageType = eventMessage.getEventMessageType();
        HashMap addmsg = JsonUtil.json2Obj(eventMessage.getContent(), HashMap.class);
        log.info("消费消息为:{},投递时间是{}",addmsg.get("msgName"),addmsg.get("msgDate"));
    }
}
