package com.stackroute.bookmarkapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.stackroute.bookmarkapi.filter.BookmarkFilter;


@SpringBootApplication
public class BookmarkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkApiApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean getfilter() {
		FilterRegistrationBean fbean = new FilterRegistrationBean();
		fbean.setFilter(new BookmarkFilter());
		fbean.addUrlPatterns("/bookmark/*");
		return fbean;
	}

}
