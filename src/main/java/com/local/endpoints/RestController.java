/**
 * 
 */
package com.local.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.local.config.KafkaSenderConfig;

/**
 * @author gaurav's
 * 
 * <p>one of the end point of the controller and an end point defined.
 *
 */
@Controller
public class RestController {
	
	private static Logger LOG = LoggerFactory.getLogger(RestController.class);
	private static int count =0;

	@Autowired
	private KafkaSenderConfig senderHelper;
	
	/****
	 *  one controller which will post the message to kafka topic and 
	 *  behaves as a producer as well. and an open rest endpoint to user as well.
	 * @return
	 */
	@RequestMapping(value = "/produce")
	@ResponseBody
	public String produceMessage() {
		count++;
		String message = "Hello User "+count;
		LOG.info("Message produced '{}' to Topic '{}'", message, senderHelper.getProperties().getProducerTopic());
		senderHelper.getProducer().produce(senderHelper.getProperties().getProducerTopic(), message);
		return message;
	}
}
