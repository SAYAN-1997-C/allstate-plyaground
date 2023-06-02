package com.stackroute.playlistapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.stackroute.playlistapi.filter.PlaylistFilter;

@EnableEurekaClient
@SpringBootApplication
public class PlaylistApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistApiApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean getfilter() {
		FilterRegistrationBean fbean = new FilterRegistrationBean();
		fbean.setFilter(new PlaylistFilter());
		fbean.addUrlPatterns("/playlist/*");
		return fbean;
	}

}
