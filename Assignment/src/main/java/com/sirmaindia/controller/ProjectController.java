package com.sirmaindia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirmaindia.dto.ProjectDTO;
import com.sirmaindia.exception.DateMismatchException;
import com.sirmaindia.exception.ProjectAlreadyExistsException;
import com.sirmaindia.exception.ProjectIdNotFoundException;
import com.sirmaindia.exception.invalidIdException;
import com.sirmaindia.model.Project;
import com.sirmaindia.service.IProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	private IProjectService projectService;
	
	@PostMapping("/addProject")
	public ResponseEntity<String> insertProject(@RequestBody @Valid ProjectDTO project) throws DateMismatchException, ProjectAlreadyExistsException{
		 
		projectService.insertProject(project);
		return new ResponseEntity<>("added successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{id}")
	public Project getById(@PathVariable long id) throws ProjectIdNotFoundException, invalidIdException {
		return projectService.getProjectById(id);
	}
	
	@GetMapping("/getAll")
	public List<Project> getAll(){
		return projectService.getAllProject();
	}
	
	@PutMapping("/updateProject/{id}")
	public ResponseEntity<String> updateProject(@RequestBody @Valid ProjectDTO project, @PathVariable long id) throws ProjectIdNotFoundException, DateMismatchException {
		projectService.updateProject(project, id);
		return new ResponseEntity<>("updated successfully", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id) throws ProjectIdNotFoundException {
		projectService.deleteProjectById(id);
		return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
	}
	
}
