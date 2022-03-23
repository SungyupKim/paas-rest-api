package com.cloud.pass.namespace;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.pass.grpc.client.Client.GetNamespaceResponse;

@RestController
public class NameSpaceController {
	@Autowired
	private NamespaceService nameSpaceService;
	@ResponseBody
	@GetMapping(value="/cluster/{cluster}/namespace", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getNameSpaceInfo(@PathVariable String cluster) {
		String jsonString = "";
		JSONObject jsonRoot = new JSONObject();
		GetNamespaceResponse resp = nameSpaceService.getNamespace(cluster);
		if (resp == null) {
			return new ResponseEntity<Object>("NOT FOUND", HttpStatus.NOT_FOUND);
		}
		
		jsonRoot.put("namespaces", resp.getNamespaceList());
		System.out.println(jsonRoot);
		return new ResponseEntity<Object>(jsonRoot.toString(), HttpStatus.OK);
	}
}