package com.sirmaindia.service;

import java.util.List;

import com.sirmaindia.dto.ProjectDTO;
import com.sirmaindia.exception.DateMismatchException;
import com.sirmaindia.exception.ProjectAlreadyExistsException;
import com.sirmaindia.exception.ProjectIdNotFoundException;
import com.sirmaindia.exception.invalidIdException;
import com.sirmaindia.model.Project;

public interface IProjectService {

	public void insertProject(ProjectDTO project) throws DateMismatchException, ProjectAlreadyExistsException;
	
	public Project updateProject(ProjectDTO project, long id) throws ProjectIdNotFoundException, DateMismatchException;
	
	public Project getProjectById(long id) throws ProjectIdNotFoundException, invalidIdException;
	
	public List<Project> getAllProject();
	
	public void deleteProjectById(long id) throws ProjectIdNotFoundException;
}
