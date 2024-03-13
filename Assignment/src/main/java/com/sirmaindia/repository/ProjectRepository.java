package com.sirmaindia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sirmaindia.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	@Query(value="Select * from project_details as pd where pd.PROJECT_NAME=?", nativeQuery=true)
	Project findProjectByName(String projectName);
	
}
