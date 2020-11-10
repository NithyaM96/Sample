package com.result.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.result.model.StudentResult;
import com.result.service.ResultService;

@RequestMapping(path = "/admin")

@RestController
@CrossOrigin(origins = "*")

public class ResultController {
	@Autowired
	ResultService adminservice;

	@GetMapping("/")
	public String login() {
		return "authenticated...";
	}

	@PostMapping("/students")

	public StudentResult createStudent(@Validated @RequestBody StudentResult studresult) throws Exception {
		return adminservice.saveresult(studresult);
	}

	@GetMapping("/students")

	public List<StudentResult> getAllStudents() {
		return adminservice.getscore();
	}

	@PutMapping("/students/{regno}")
	public StudentResult updateStudent(@PathVariable(value = "regno") int reg, @RequestBody StudentResult studresult) {

		return adminservice.update(studresult);
	}

	@DeleteMapping("/students/{regno}")
	public Boolean deleteStudent(@PathVariable(value = "regno") int regno) {
		return adminservice.deleteresult(regno);
	}

	@GetMapping("/students/{regno}")
	public ResponseEntity<StudentResult> getStudentByRegNo(@PathVariable(value = "regno") int regno) {
		return adminservice.getresultbyregno(regno);
	}
}
