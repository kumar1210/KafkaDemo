/**
 * 
 */
package com.local.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author gaurav's
 * 
 *  <p> a listener/consumer class which will subscribe to the topic
 *  pas sed to the kafka listener annotation
 *  <p> to get the kafka listener initialized annotated the class with @component
 *  
 *  <p> there are two listener methods defined, always comment one and 
 *  run else without order either one of them would be consuming messages all the time.
 *  
 *
 */
@Component
public class KafkaReceiver {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaReceiver.class);
	
	
	/***
	 *  a listener method which will consume all the message produced 
	 *  to the topic is listening.
	 * @param message
	 */
	@KafkaListener(topics = "${kafka.topic.name}", groupId="${kafka.topic.name}")
	public void consume(String message) {
		
		LOG.info("Message received at receiver is '{}'", message);
	}
	
	/***
	 * another listener methods which will consume the message but with
	 * different input type, by which we can get all the details like topic, key,
	 * message, etc.
	 * @param consumerRecord
	 */
	@KafkaListener(topics = "${kafka.topic.name}", groupId="${kafka.topic.name}")
	public void receive(ConsumerRecord<?, ?> consumerRecord) {
		LOG.info("Message received at receiver is '{}'", consumerRecord.toString());
	}
}
