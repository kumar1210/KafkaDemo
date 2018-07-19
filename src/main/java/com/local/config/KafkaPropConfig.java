/**
 * 
 */
package com.local.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author gaurav's
 *
 */
public class KafkaPropConfig {
	
	@Value("${kafka.bootstrap-servers}")
	private String servers;

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

}
