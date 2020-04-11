package com.sdstc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	/**
	 * Fanout模式通道定义（交付ECS业务）
	 */
	public static final String FANOUT_QUEUE_DELIVERYECS1 = "fanout.queue.deliveryecs1";// 交付ECS路由
	public static final String FANOUT_EXCHANGE_DELIVERYECS = "fanout.exchange.deliveryecs";// 交换机
	
	/**
	 * Fanout模式通道定义（交付K8S业务）
	 */
	public static final String FANOUT_QUEUE_DELIVERYK8S1 = "fanout.queue.deliveryk8s1";// 交付LC路由
	public static final String FANOUT_QUEUE_DELIVERYK8S2 = "fanout.queue.deliveryk8s2";// 交付LG路由
	public static final String FANOUT_EXCHANGE_DELIVERYK8S = "fanout.exchange.deliveryk8s";// 交换机
	
	/**
     * Fanout模式处理（交付ECS业务）
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     * 
     */
	@Bean
    public Queue fanoutQueueDeliveryECS1() {
        return new Queue(FANOUT_QUEUE_DELIVERYECS1);
    }
	
	@Bean
    public FanoutExchange fanoutExchangeDeliveryECS() {
        return new FanoutExchange(FANOUT_EXCHANGE_DELIVERYECS);
    }
	
	@Bean
    public Binding fanoutBindingDeliveryECS1() {
        return BindingBuilder.bind(fanoutQueueDeliveryECS1()).to(fanoutExchangeDeliveryECS());
    }
    
    /**
     * Fanout模式处理（交付K8S业务）
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     * 
     */
	@Bean
    public Queue fanoutQueueDeliveryK8S1() {
        return new Queue(FANOUT_QUEUE_DELIVERYK8S1);
    }
	
	@Bean
    public Queue fanoutQueueDeliveryK8S2() {
        return new Queue(FANOUT_QUEUE_DELIVERYK8S2);
    }
	
	@Bean
    public FanoutExchange fanoutExchangeDeliveryK8S() {
        return new FanoutExchange(FANOUT_EXCHANGE_DELIVERYK8S);
    }
	
	@Bean
    public Binding fanoutBindingDeliveryK8S1() {
        return BindingBuilder.bind(fanoutQueueDeliveryK8S1()).to(fanoutExchangeDeliveryK8S());
    }
 
    @Bean
    public Binding fanoutBindingDeliveryK8S2() {
        return BindingBuilder.bind(fanoutQueueDeliveryK8S2()).to(fanoutExchangeDeliveryK8S());
    }

}
