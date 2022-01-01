package com.cloud.pass.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.pass.model.Pod;

@RestController
public class PodController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping(value="/cluster/{cluster}/namespace/{namespace}")
	public List<Pod> getPodInfo(@PathVariable String cluster, @PathVariable String namespace) {
		
	}
}