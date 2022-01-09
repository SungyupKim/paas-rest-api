package com.cloud.pass.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.pass.grpc.client.Client.PodInfo;
import com.cloud.pass.service.PodInfoService;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
@RestController
public class PodController {
	private static final PodInfoService podInfoService = new PodInfoService();
	@ResponseBody
	@GetMapping(value="/cluster/{cluster}/namespace/{namespace}/pod", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getPodInfo(@PathVariable String cluster, @PathVariable String namespace) {
		String jsonString = "";
		try {
			//String output = JsonFormat.printer().print(podInfoService.getPods(cluster, namespace).getInfoList().get(0));
			JSONArray jsonArr = new JSONArray();
			for (PodInfo info : podInfoService.getPods(cluster, namespace).getInfoList()) {
				String output = JsonFormat.printer().print(info);
				JSONObject jsonObject = new JSONObject(output);
				jsonArr.put(jsonObject);
			}
			System.out.println(jsonArr);
			JSONObject jsonRoot = new JSONObject();
			jsonRoot.put("pods", jsonArr);
			System.out.println(jsonRoot);
			return new ResponseEntity<Object>(jsonRoot.toString(), HttpStatus.OK);
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.put("pods", podInfoService.getPods(cluster, namespace).getInfoList());
		/*
		 * List<Pod> l = new ArrayList<>(); Pod p1 = new Pod(namespace, namespace, 0, 0,
		 * namespace, 0, namespace); l.add(p1); response.put("pods", l);
		 */
		return new ResponseEntity<Object>(jsonString, HttpStatus.OK);
	}
}