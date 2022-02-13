package com.cloud.pass.namespace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "namespace")
@Table(name="namespace")
public class NamespaceVO {
	@Id
	private String name;
	
	@Column
	private String namespaceId;
	
	@Column
	private String projectId;
}
