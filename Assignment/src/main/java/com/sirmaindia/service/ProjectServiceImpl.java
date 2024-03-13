package com.sirmaindia.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirmaindia.dto.ProjectDTO;
import com.sirmaindia.exception.DateMismatchException;
import com.sirmaindia.exception.ProjectAlreadyExistsException;
import com.sirmaindia.exception.ProjectIdNotFoundException;
import com.sirmaindia.exception.invalidIdException;
import com.sirmaindia.model.Project;
import com.sirmaindia.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private ProjectRepository projectRepo;
	
	public boolean isValidDate(LocalDate startDate, LocalDate endDate) {
		return endDate.isAfter(startDate);
	}
	
	public boolean invalidId(long id) {
		return id < 1;
	}
	
	@Override
	public void insertProject(ProjectDTO projectdto) throws DateMismatchException, ProjectAlreadyExistsException {
		String projectName = projectdto.getProjectName();
		Project enteredProject = projectRepo.findProjectByName(projectName);
		if(enteredProject != null) {
			throw new ProjectAlreadyExistsException("Project name already exists");
		}
		Project project = new Project();
		project.setProjectName(projectdto.getProjectName());
		project.setDescription(projectdto.getDescription());
		project.setStartDate(LocalDate.now());
		
		LocalDate endDate = projectdto.getEndDate();
		if(!isValidDate(LocalDate.now(), endDate)) {
			throw new DateMismatchException("end date must be after the start date");
		}
		project.setEndDate(projectdto.getEndDate());
		projectRepo.save(project);
	}

	@Override
	public Project updateProject(ProjectDTO projectdto, long id) throws ProjectIdNotFoundException, DateMismatchException {
		Project project = projectRepo.findById(id).orElse(null);
		if(project==null) {
			throw new ProjectIdNotFoundException("Entered project id does not exists or negative");
		}
		project.setProjectName(projectdto.getProjectName());
		project.setDescription(projectdto.getDescription());
		LocalDate startDate = project.getStartDate();
		LocalDate endDate = projectdto.getEndDate();
		if(!isValidDate(startDate, endDate)) {
			throw new DateMismatchException("end date must be after the start date");
		}
		project.setEndDate(projectdto.getEndDate());
		return projectRepo.save(project);
	}

	@Override
	public Project getProjectById(long id) throws ProjectIdNotFoundException, invalidIdException {
		if(invalidId(id)) {
			throw new invalidIdException("id cannot be negative or null");
		}
		Project project = projectRepo.findById(id).orElse(null);
		if(project==null) {
			throw new ProjectIdNotFoundException("Entered project id does not exists");
		}
		return project;
	}

	@Override
	public List<Project> getAllProject() {
		return projectRepo.findAll();
	}

	@Override
	public void deleteProjectById(long id) throws ProjectIdNotFoundException {
		Project project = projectRepo.findById(id).orElse(null);
		if(project==null) {
			throw new ProjectIdNotFoundException("Entered project id does not exists or negative");
		}
		projectRepo.deleteById(id);
	}

	
}
