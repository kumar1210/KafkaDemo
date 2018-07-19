/**
 * 
 */
package com.local.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.local.consumer.KafkaReceiver;

/**
 * @author gaurav's
 *
 */
@Configuration
@EnableKafka
public class KafkaReceiverConfig {

	@Autowired
	private KafkaPropConfig properties;
	

	@Bean
	public Map<String, Object> consumerConfigs() {
		
		Map<String, Object> props =  new HashMap<String, Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getServers());
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		return props;
	}
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		
		return new DefaultKafkaConsumerFactory<String, String>(consumerConfigs());
	}
	
	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
	    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
	    factory.setConsumerFactory(consumerFactory());

	    return factory;
	}
	
	@Bean
	public KafkaReceiver getConsumer() {
		
		return new KafkaReceiver();
	}
}
