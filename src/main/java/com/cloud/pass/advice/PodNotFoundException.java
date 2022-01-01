package com.cloud.pass.advice;

public class PodNotFoundException extends RuntimeException {
	public PodNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
