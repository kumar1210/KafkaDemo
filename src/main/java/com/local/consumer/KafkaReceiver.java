/**
 * 
 */
package com.local.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author gaurav's
 *
 */
public class KafkaReceiver {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaReceiver.class);
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	public CountDownLatch getLatch() {
	    return latch;
	}
	
	@KafkaListener(topics = "${kafka.topic.name}")
	public void consume(String message) {
		
		LOG.info("Message received is '{}'", message);
		latch.countDown();
	}
}
