package com.cloud.pass.userinfo;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
	@ResponseBody
	@GetMapping(value = "/userInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUserInfo() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		KeycloakPrincipal principal = (KeycloakPrincipal) auth.getPrincipal();
		KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
		AccessToken accessToken = session.getToken();
		String username = accessToken.getPreferredUsername();
		String realmName = accessToken.getIssuer();
		String client = accessToken.getIssuedFor();
		Map<String, Object> obj = accessToken.getOtherClaims();
		List<String> groups = null;
		if (obj.containsKey("groups")) {
			groups = (List<String>) obj.get("groups");
		}
		UserInfo info = new UserInfo(username, groups, client);
		return new ResponseEntity<Object>(info, HttpStatus.OK);
	}
}
