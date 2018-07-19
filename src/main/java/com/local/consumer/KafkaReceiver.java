/**
 * 
 */
package com.local.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author gaurav's
 *
 */
public class KafkaReceiver {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaReceiver.class);
	
	@KafkaListener(topics = "${kafka.topic.name}")
	public void consume(String message) {
		
		LOG.info("Message received is '{}'", message);
	}
}
