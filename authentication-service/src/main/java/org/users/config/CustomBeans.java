package org.users.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeans {
	@Bean
	public List<Long> longListBean() {
		return new ArrayList<Long>();
	}

	@Bean
	public List<String> stringListBean() {
		return new ArrayList<String>();
	}
}
