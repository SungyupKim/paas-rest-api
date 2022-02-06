package com.cloud.pass.userinfo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserInfoController {
	@ResponseBody
	@GetMapping(value = "/userInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUserInfo() {
		JSONArray jsonArr = new JSONArray();

//		for (ServiceInfo info : serviceInfoService.getServiceInfo(cluster, namespace).getServicesList()) {
//			String output = JsonFormat.printer().print(info);
//			JSONObject jsonObject = new JSONObject(output);
//			jsonArr.put(jsonObject);
//		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		KeycloakPrincipal principal = (KeycloakPrincipal) auth.getPrincipal();

		KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
		AccessToken accessToken = session.getToken();
		String username = accessToken.getPreferredUsername();
		String emailID = accessToken.getEmail();
		String lastname = accessToken.getFamilyName();
		String firstname = accessToken.getGivenName();
		String realmName = accessToken.getIssuer();
		AccessToken.Access realmAccess = accessToken.getRealmAccess();
		JSONObject jsonRoot = new JSONObject();

		jsonRoot.put("pods", jsonArr);
		System.out.println(jsonRoot);
		return new ResponseEntity<Object>(username, HttpStatus.OK);
	}
}
