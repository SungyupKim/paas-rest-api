package com.cloud.pass.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectVO, String>{
	public List<ProjectVO> findByName(String name);
	public List<ProjectVO> findAll();
}
