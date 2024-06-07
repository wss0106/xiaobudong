package com.wss.config;

import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@Data
public class RabbitMQConfig {


    /**
     * 交换机
     */
    private String xbdRabbitmqEventExchange="xbd_rabbitmq.event.exchange";

    /**
     * 创建交换机 Topic类型
     * 一般一个微服务一个交换机
     * @return
     */
    @Bean
    public Exchange xbdRabbitmqEventExchange(){

        return new TopicExchange(xbdRabbitmqEventExchange,true,false);
    }

    //新增短链相关配置====================================

    /**
     * 新增短链 队列
     */
    private String xbdRabbitmqAddLinkQueue="xbd_rabbitmq.add.link.queue";

    /**
     * 新增短链映射 队列
     */
    private String xbdRabbitmqAddMappingQueue="xbd_rabbitmq.add.mapping.queue";

    /**
     * 新增短链具体的routingKey,【发送消息使用】
     */
    private String xbdRabbitmqAddRoutingKey="xbd_rabbitmq.add.link.mapping.routing.key";

    /**
     * topic类型的binding key，用于绑定队列和交换机，是用于 link 消费者
     */
    private String xbdRabbitmqAddLinkBindingKey="xbd_rabbitmq.add.link.*.routing.key";

    /**
     * topic类型的binding key，用于绑定队列和交换机，是用于 mapping 消费者
     */
    private String xbdRabbitmqAddMappingBindingKey="xbd_rabbitmq.add.*.mapping.routing.key";


    /**
     * 新增短链api队列和交换机的绑定关系建立
     */
    @Bean
    public Binding xbdRabbitmqAddApiBinding(){
        return new Binding(xbdRabbitmqAddLinkQueue,Binding.DestinationType.QUEUE, xbdRabbitmqEventExchange,xbdRabbitmqAddLinkBindingKey,null);
    }


    /**
     * 新增短链mapping队列和交换机的绑定关系建立
     */
    @Bean
    public Binding xbdRabbitmqAddMappingBinding(){
        return new Binding(xbdRabbitmqAddMappingQueue,Binding.DestinationType.QUEUE, xbdRabbitmqEventExchange,xbdRabbitmqAddMappingBindingKey,null);
    }


    /**
     * 新增短链api 普通队列，用于被监听
     */
    @Bean
    public Queue xbdRabbitmqAddLinkQueue(){

        return new Queue(xbdRabbitmqAddLinkQueue,true,false,false);

    }

    /**
     * 新增短链mapping 普通队列，用于被监听
     */
    @Bean
    public Queue xbdRabbitmqAddMappingQueue(){

        return new Queue(xbdRabbitmqAddMappingQueue,true,false,false);

    }



}

