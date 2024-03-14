package com.sirmaindia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sirmaindia.dto.ProjectDTO;
import com.sirmaindia.exception.DateMismatchException;
import com.sirmaindia.exception.ProjectAlreadyExistsException;
import com.sirmaindia.exception.ProjectIdNotFoundException;
import com.sirmaindia.exception.invalidIdException;
import com.sirmaindia.model.Project;
import com.sirmaindia.repository.ProjectRepository;

@SpringBootTest
class ProjectServiceImplTest {

	@Autowired
	private IProjectService serviceTest;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Test
	void testInsertProject() throws ProjectIdNotFoundException, invalidIdException, DateMismatchException, ProjectAlreadyExistsException {
		ProjectDTO project = new ProjectDTO();

		project.setProjectName("MyJunitProject");
		project.setDescription("This is my spring project using H2 db");
		
		LocalDate endDate = LocalDate.of(2024, 3, 25);
		project.setEndDate(endDate);
		serviceTest.insertProject(project);
		
		Project enteredProject = projectRepo.findProjectByName(project.getProjectName());
		assertEquals(project.getProjectName(), enteredProject.getProjectName());
	}

	

	@Test
	void testGetAllProject() {
		List<Project> list = serviceTest.getAllProject();
		assertNotNull(list);
	}

	

}
