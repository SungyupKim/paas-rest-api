package com.cloud.pass.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterService {
	@Autowired
	private ClusterRepository clusterRepository;
	
	public ClusterVO findByName(String name){
		ClusterVO cluster = clusterRepository.findByName(name);
		return cluster;
	}
}
