package com.sirmaindia.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="project_details")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;
	
	private String projectName;
	
	private String description;
	
	private LocalDate startDate;
	
	private LocalDate endDate;

	public Project() {
		super();
	}

	public Project(long projectId, String projectName, String description, LocalDate startDate, LocalDate endDate) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
}
