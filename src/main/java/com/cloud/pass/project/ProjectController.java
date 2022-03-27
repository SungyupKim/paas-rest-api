package com.cloud.pass.project;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.pass.userinfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@RestController
public class ProjectController {
	@Autowired
	ProjectService service;
	
	@ResponseBody
	@GetMapping(value = "/project/{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getProjectInfo(@PathVariable String projectId) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		ProjectInformation information = service.findProjectResourcesByProjectId(projectId);
		response.put("projectResources", information);
		return response;
	}
	
	@ResponseBody
	@GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getAllProjectInfo() {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("projects", service.findAllProjects());
		return response;
	}
}
