package com.cloud.pass.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.pass.grpc.client.Client.GetNamespaceResponse;
import com.cloud.pass.service.NamespaceService;
import com.google.protobuf.InvalidProtocolBufferException;

@RestController
public class NameSpaceController {
	private static final NamespaceService nameSpaceService = new NamespaceService();
	@ResponseBody
	@GetMapping(value="/cluster/{cluster}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getNameSpaceInfo(@PathVariable String cluster) {
		String jsonString = "";
		//String output = JsonFormat.printer().print(nameSpaceInfoService.getNameSpaces(cluster).getInfoList();
		JSONObject jsonRoot = new JSONObject();
		GetNamespaceResponse resp = nameSpaceService.getNamespace(cluster);
		jsonRoot.put("namespaces", resp.getNamespaceList());
		System.out.println(jsonRoot);
		return new ResponseEntity<Object>(jsonRoot.toString(), HttpStatus.OK);
	}
}