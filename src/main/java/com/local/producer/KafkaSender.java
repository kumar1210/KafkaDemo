/**
 * 
 */
package com.local.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author gaurav's
 * 
 *  <p> a sender/producer class which will post messages to the topic passed
 * it will use the kafka template, created in the KafkaSenderConfig, to 
 * post messages to kafka.
 *
 */
public class KafkaSender {
	
	private static final Logger LOG = LoggerFactory.getLogger(KafkaSender.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	public void produce(String topic, String message) {
		
		LOG.info("This Message ='{}' will be posted to Topic = '{}' ", message, topic);
		kafkaTemplate.send(topic, message);
	}

}
