package com.cloud.pass.cluster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterService {
	@Autowired
	private ClusterRepository clusterRepository;
	
	public ClusterVO findById(String id){
		ClusterVO cluster = clusterRepository.findByClusterId(id);
		return cluster;
	}
	
	public List<ClusterVO> findByProjectId(String id){
		List<ClusterVO> cluster = clusterRepository.findByProjectId(id);
		return cluster;
	}
}
