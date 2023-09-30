package com.mindSpace;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "demoService")
public class Demoservice {

	@Autowired
	private DemoRepo demoRepo;

	public String insertStudent(StudentDemo s) {
		StudentDemo student = demoRepo.save(s);
		return "Student inserted successfully " + student.toString();
	}

	public String getStudent(StudentDemo s) {
		Optional<StudentDemo> optional = demoRepo.findById(s.getId());
		if (optional.isPresent()) {
			StudentDemo sDemo = optional.get();
			return sDemo.toString();
		} else {
			return "No student found for id :" + s.getId();
		}

	}

	public String getStudent1(Integer id) {
		Optional<StudentDemo> optional = demoRepo.findById(id);
		if (optional.isPresent()) {
			StudentDemo studentDemo = optional.get();
			return studentDemo.toString();
		} else {
			return "No student found for id :" + id;
		}
	}

	public String updateStudent(StudentDemo sd) {
		Optional<StudentDemo> optional = demoRepo.findById(sd.getId());
		if (optional.isPresent()) {
			StudentDemo student = demoRepo.save(sd);
			return student.toString();
		} else {
			throw new RuntimeException("No student found hence we cant update student for id :" + sd.getId());
		}
	}

	public String deleteStuudentById(Integer id) {
		Optional<StudentDemo> o = demoRepo.findById(id);
		if (o.isPresent()) {
			demoRepo.deleteById(id);
			return "Student deleted successfully";
		} else {
			return "No student found for id: " + id;
		}
	}

	public String deleteStuudentEntity(Integer id) {
		Optional<StudentDemo> o = demoRepo.findById(id);
		StudentDemo demo = o
				.orElseThrow(() -> new RuntimeException("No student found hence we cant delete student for id :" + id));
		demoRepo.delete(demo);
		return "Student deleted successfully";
	}

	public List<StudentDemo> readAllStudent() {
		Iterable<StudentDemo> allStudents = demoRepo.findAll();
		List<StudentDemo> list = new ArrayList<StudentDemo>();
		for (StudentDemo d : allStudents) {
			list.add(d);
		}
		return list;
	}

}
