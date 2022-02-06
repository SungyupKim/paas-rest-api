package com.cloud.pass.config;

import java.io.InputStream;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.spi.HttpFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {
	@Bean
	public KeycloakConfigResolver keycloakConfigResolver() {
		return new KeycloakConfigResolver() {
			private KeycloakDeployment keycloakDeployment;

			@Override
			public KeycloakDeployment resolve(HttpFacade.Request facade) {
				if (keycloakDeployment != null) {
					return keycloakDeployment;
				}

				String path = "/keycloak.json";
				InputStream configInputStream = getClass().getResourceAsStream(path);

				if (configInputStream == null) {
					throw new RuntimeException("Could not load Keycloak deployment info: " + path);
				} else {
					keycloakDeployment = KeycloakDeploymentBuilder.build(configInputStream);
				}

				return keycloakDeployment;
			}
		};
	}
}