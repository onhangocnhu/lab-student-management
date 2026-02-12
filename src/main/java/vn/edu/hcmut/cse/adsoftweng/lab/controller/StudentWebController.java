package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentWebController {
	@Autowired
	private StudentService service;

	@GetMapping
	public String getAllStudents(@RequestParam(required = false) String keyword, Model model) {
		List<Student> students;

		if (keyword != null && !keyword.isEmpty()) {
			students = service.searchByName(keyword);
		} else {
			students = service.getAll();
		}
		
		model.addAttribute("dsSinhVien", students);
		return "students";
	}

	@GetMapping("/new")
	public String showCreateForm(Model model) {
		model.addAttribute("student", new Student());
		return "student-form";
	}

	@GetMapping("/{id}")
	public String getStudentDetail(@PathVariable String id, Model model) {
		Student student = service.getById(id);
		model.addAttribute("student", student);
		return "student-detail";
	}

	@GetMapping("/{id}/edit")
	public String showEditForm(@PathVariable String id, Model model) {
		Student student = service.getById(id);
		model.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(Student student, Model model) {
		if (service.getById(student.getId()) != null) {
			model.addAttribute("student", student);
			model.addAttribute("error", "ID sinh viên đã tồn tại!");
			return "student-form";
		}
		
		service.save(student);
		return "redirect:/students";
	}

	@PostMapping("/update")
	public String updateStudent(Student student) {
		service.save(student);
		return "redirect:/students";
	}

	@GetMapping("/{id}/delete")
	public String deleteStudent(@PathVariable String id) {
		service.deleteById(id);
		return "redirect:/students";
	}
}