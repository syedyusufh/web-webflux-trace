package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sample.model.dto.Request;
import com.sample.model.dto.Response;

import reactor.core.publisher.Mono;

@Service
public class ApplicationService {

	@Autowired
	private WebClient webClient;

	public Mono<Response> greet(final Request request) {

		// @formatter:off
		return webClient.get()
						.uri("https://echo.free.beeceptor.com/sample-request?author=beeceptor")
						.retrieve()
						.bodyToMono(Response.class);
		// @formatter:on
	}

}
