package com.sirmaindia.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProjectDTO {
	
	@NotBlank(message = "Project name cannot be blank")
    @Size(min = 3, max = 50, message = "Project name must be between 3 and 50 characters")
	private String projectName;
	
	@NotBlank(message = "Description cannot be blank")
    @Size(min = 10, max = 200, message = "Project name must be between 3 and 50 characters")
	private String description;
	
	private LocalDate endDate;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
}
