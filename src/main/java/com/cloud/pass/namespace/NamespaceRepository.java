package com.cloud.pass.namespace;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamespaceRepository extends JpaRepository<NamespaceVO, String>{
	public List<NamespaceVO> findByProjectId(String id);
}
