/**
 * 
 */
package com.local.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author gaurav's
 * 
 * <p> main class to launch the spring application annotation 
 * @SpringBootApplication makes it bootable application,
 * 		<p>	- enable the default auto configuration,  @EnableAutoConfiguration
 * 		<p>	- scan its own package  , @ComponentScan
 * 		<p>	- and configure the class, @Configuration
 * 
 * @ComponentScan to scan all the other packages needed for application
 *
 */
@SpringBootApplication
@ComponentScan("com.local.*")
public class SpringKafkaLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication.run(SpringKafkaLauncher.class, args);
	}

}
