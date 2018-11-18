package com.wxw.sdweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*@SpringBootApplication
public class SdwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdwebApplication.class, args);
	}
}
*/
@SpringBootApplication
public class SdwebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SdwebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SdwebApplication.class, args);
	}
}
