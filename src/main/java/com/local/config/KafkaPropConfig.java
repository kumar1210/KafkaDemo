/**
 * 
 */
package com.local.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaurav's
 * 
 * <p> a simple configuration class, which will load all the values
 * defined in the properties file.
 *
 */
@Configuration
public class KafkaPropConfig {
	
	@Value("${kafka.bootstrap-servers}")
	private String servers;
	
	@Value("${kafka.topic.name}")
	private String producerTopic;

	/**
	 * @return the servers
	 */
	public String getServers() {
		return servers;
	}

	/**
	 * @param servers the servers to set
	 */
	public void setServers(String servers) {
		this.servers = servers;
	}

	/**
	 * @return the producerTopic
	 */
	public String getProducerTopic() {
		return producerTopic;
	}

	/**
	 * @param producerTopic the producerTopic to set
	 */
	public void setProducerTopic(String producerTopic) {
		this.producerTopic = producerTopic;
	}

}
