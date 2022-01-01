package com.cloud.pass.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.pass.model.Pod;

@RestController
public class PodController {

	private static final String template = "Hello, %s!";
	@ResponseBody
	@GetMapping(value="/cluster/{cluster}/namespace/{namespace}")
	public ResponseEntity<Map<String, Object>> getPodInfo(@PathVariable String cluster, @PathVariable String namespace) {
		Map<String, Object> response = new HashMap<>();
		List<Pod> l = new ArrayList<>();
		Pod p1 = new Pod(namespace, namespace, 0, 0, namespace, 0, namespace);
		l.add(p1);
		response.put("pods", l);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}