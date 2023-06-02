package com.stackroute.registrationapi.exceptions;

import lombok.Builder;

@Builder
public class ErrorResponse {

	private String responseDesc;
	private String responseStatusDesc;
	
}
