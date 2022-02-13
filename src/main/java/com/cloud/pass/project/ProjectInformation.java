package com.cloud.pass.project;

import java.util.List;

import com.cloud.pass.cluster.ClusterVO;
import com.cloud.pass.namespace.NamespaceVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectInformation {
	List<ClusterVO> clusters;
	List<NamespaceVO> namespaces; 
}
