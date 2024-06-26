package com.wss.controller;

import com.wss.config.RabbitMQConfig;
import com.wss.model.EventMessage;
import com.wss.xiaobudong.utils.IDUtil;
import com.wss.xiaobudong.utils.JsonData;
import com.wss.xiaobudong.utils.JsonUtil;

import groovy.util.logging.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/mqmsg/v1")
public class XbdMqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQConfig rabbitMQConfig;
    @GetMapping("/add")
    public JsonData addXbdMqMsg(HttpServletRequest request){
        String token=request.getHeader("link_token");
        if("".equals(token)||token==null){
            return JsonData.buildError("请求失败!");
        }
        HashMap msgMap=new HashMap<String,String>();
        msgMap.put("msgName","消息名称");
        msgMap.put("msgDate", System.currentTimeMillis());

        EventMessage eventMessage = EventMessage.builder().accountNo(666L)
                .content(JsonUtil.obj2Json(msgMap))
                .messageId(IDUtil.geneSnowFlakeID().toString())
                .eventMessageType("ADDMSG")
                .build();
        rabbitTemplate.convertAndSend(rabbitMQConfig.getXbdRabbitmqEventExchange(), rabbitMQConfig.getXbdRabbitmqAddRoutingKey(), eventMessage);

        return JsonData.buildSuccess();
    }

}
