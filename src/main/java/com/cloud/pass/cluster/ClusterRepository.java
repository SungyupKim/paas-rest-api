package com.cloud.pass.cluster;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClusterRepository extends JpaRepository<ClusterVO, String>{
	public List<ClusterVO> findByName(String name);
	public ClusterVO findByClusterId(String id);
	public List<ClusterVO> findByProjectId(String id);
}
