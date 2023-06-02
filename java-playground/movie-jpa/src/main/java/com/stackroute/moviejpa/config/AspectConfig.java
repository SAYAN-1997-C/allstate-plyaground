package com.stackroute.moviejpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

	@Bean
	public SampleAspect getAspect()
	{
		return new SampleAspect();
	}
}
