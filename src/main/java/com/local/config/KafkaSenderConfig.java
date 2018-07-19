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
 * <p> a Kafka Prodcuer configuration class, which will initialize all the setup
 * required for a producer of kafka topic
 *
 */
@Configuration
public class KafkaSenderConfig {

	
	@Autowired
	private KafkaPropConfig properties;
	
	
	/****
	 * a method which will load all the properties in a map
	 * @return
	 */
	@Bean
	public Map<String, Object> producerConfigs() {
		
		Map<String, Object> props =  new HashMap<String, Object>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getServers());
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return props;
	}
	
	/***
	 * will initializea a producerfactory, using the property created in the previous method
	 * @return
	 */
	@Bean
	public ProducerFactory<String, String> producerFactory() {
		
		return new DefaultKafkaProducerFactory<String, String>(producerConfigs());
	}
	
	/***
	 * Kafkatemplate which will be use to send/produce any message to a topic
	 * a new template will be created by passing a producerfactory passed before.
	 * @return
	 */
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
	
		return new KafkaTemplate<String, String>(producerFactory());
	}
	
	/***
	 * a simple bean class of producer
	 * @return
	 */
	@Bean
	public KafkaSender getProducer() {
		
		return new KafkaSender();
	}

	/**
	 * @return the properties
	 */
	public KafkaPropConfig getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(KafkaPropConfig properties) {
		this.properties = properties;
	}
}
