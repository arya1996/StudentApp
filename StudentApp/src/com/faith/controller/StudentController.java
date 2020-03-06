package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.StudentDao;
import com.faith.model.Student;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentDao dao;

	// List
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List getStudentDetails() {
		List list;
		list = dao.getAllStudentDetails();
		return list;
	}

	// Insert
	@RequestMapping(value = "/insertstudent", method = RequestMethod.POST)
	public void insertDetails(@RequestBody Student stud) {
		dao.insertStudent(stud);

	}

	// Search by id
	@RequestMapping(value = "/studentid/{studentId}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("studentId") int stuId) {
		Student stud = dao.getStudentId(stuId);
		return stud;
	}

	// search by name
	@RequestMapping(value = "/studentname/{name}", method = RequestMethod.GET)
	public Student getstudentByName(@PathVariable("name") String stuName) {
		Student student = dao.getStudentName(stuName);
		return student;
	}

	// Update
	@RequestMapping(value = "/updatestudent", method = RequestMethod.PUT)
	public void updateDetails(@RequestBody Student stud) {
		dao.updateStudent(stud);

	}

	// Delete
	@RequestMapping(value = "/deletestudent/{studentId}", method = RequestMethod.PUT)
	public void deleteDetails(@PathVariable("studentId") int stud) {

		dao.deleteStudent(stud);
	}
}
