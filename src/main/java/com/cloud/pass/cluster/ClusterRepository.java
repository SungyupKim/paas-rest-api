package com.cloud.pass.cluster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClusterRepository extends JpaRepository<ClusterVO, String>{
	public ClusterVO findByName(String name);
}
