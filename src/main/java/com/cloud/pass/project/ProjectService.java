package com.cloud.pass.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.pass.cluster.ClusterService;
import com.cloud.pass.cluster.ClusterVO;
import com.cloud.pass.namespace.NamespaceService;
import com.cloud.pass.namespace.NamespaceVO;

@Service
public class ProjectService {
	@Autowired
	private ClusterService clusterService;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private NamespaceService namespaceService;
	
	public ProjectInformation findProjectResourcesByProjectId(String id){
		List<ClusterVO> clusterList = clusterService.findByProjectId(id);
		List<NamespaceVO> namespaces = namespaceService.getNamespaceByProjectId(id);
		ProjectInformation info = new ProjectInformation(clusterList, namespaces);
		return info;
	}
	
	public List<ProjectVO> findAllProjects(){
		return projectRepository.findAll();
	}
}
