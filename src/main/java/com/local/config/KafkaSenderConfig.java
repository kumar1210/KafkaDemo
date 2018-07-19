/**
 * 
 */
package com.local.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.local.producer.KafkaSender;


/**
 * @author gaurav's
 *
 */
@Configuration
public class KafkaSenderConfig {

	
	@Autowired
	private KafkaPropConfig properties;
	
	
	@Bean
	public Map<String, Object> producerConfigs() {
		
		Map<String, Object> props =  new HashMap<String, Object>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getServers());
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return props;
	}
	
	@Bean
	public ProducerFactory<String, String> producerFactory() {
		
		return new DefaultKafkaProducerFactory<String, String>(producerConfigs());
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
	
		return new KafkaTemplate<String, String>(producerFactory());
	}
	
	@Bean
	public KafkaSender getProducer() {
		
		return new KafkaSender();
	}
}
