package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.faith.model.Student;

public class StudentDao {

	// object creation for connection
	JdbcTemplate template;

	// setter method
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// SQL Queries
	private static final String INSERT = "insert into student(name,dob,email,phone,mark,status)values(?,?,?,?,?,1)";
	private static final String LIST = "select * from student";
	private static final String FIND_ID = " select * from student where studentId=?";
	private static final String FIND_NAME = " select * from student where name=?";
	private static final String UPDATE = "update student set name=?,dob=?,email=?,phone=?,mark=? where studentId=?";
	private static final String DELETE = "update student set status=0 where studentId=?";

	// Insert
	public void insertStudent(Student student) {
		template.update(INSERT, student.getName(), student.getDob(),
				student.getEmail(), student.getPhone(), student.getMark());
	}

	// List
	public List<Student> getAllStudentDetails() {

		return template.query(LIST, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {

				// object creation
				Student student = new Student();

				// getting values
				student.setStudentId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setDob(rs.getDate(3));
				student.setEmail(rs.getString(4));
				student.setPhone(rs.getString(5));
				student.setMark(rs.getDouble(6));
				student.setStatus(rs.getInt(7));
				
				return student;

			}
		});

	}

	// search by id
	public Student getStudentId(int studentId) {
		return template.queryForObject(FIND_ID, new Object[] { studentId },
				new BeanPropertyRowMapper<Student>(Student.class));

	}

	// search by name
	public Student getStudentName(String name) {
		return template.queryForObject(FIND_NAME, new Object[] { name },
				new BeanPropertyRowMapper<Student>(Student.class));
	}

	// update
	public void updateStudent(Student student) {
		template.update(UPDATE, student.getName(), student.getDob(),
				student.getEmail(), student.getPhone(), student.getMark(),
				student.getStudentId());
	}

	// Delete
	public void deleteStudent(int stud) {
		template.update(DELETE, stud);
	}
}
