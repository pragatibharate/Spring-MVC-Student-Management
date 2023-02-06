package com.jspiders.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc.pojo.StudentPojo;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) StudentPojo login, ModelMap map) {
		if(login != null) {
		return "Home";
		}
		map.addAttribute("msg", "ooppss..Invalid username or password..!!");
		return "Login";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/login")
	public String loginData(HttpServletRequest request, @RequestParam String username, @RequestParam String password,
			ModelMap map) {
		StudentPojo student = service.login(username, password);
		if (student != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", student);
			session.setMaxInactiveInterval(120);
			return "Home";
		}
		map.addAttribute("msg", "ooppss..Invalid username or password..!!");
		return "Login";
	}

	@GetMapping("/add")
	public String addStudent(@SessionAttribute(name = "login", required = false) StudentPojo login, ModelMap map) {
		if (login != null) {
			return "AddStudent";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}

	@PostMapping("/add")
	public String addStudentData(@SessionAttribute(name = "login", required = false) StudentPojo login,
			@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String city, @RequestParam String username, @RequestParam String password, ModelMap map) {
		if (login != null) {
			StudentPojo student = service.add(name, email, contact, city, username, password);
			if (student != null) {
				map.addAttribute("student", student);
				map.addAttribute("msg", "Student added successfully..!!");
			} else {
				map.addAttribute("msg", "Student not added..!!");
			}
			return "AddStudent";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}

	@GetMapping("/remove")
	public String remove(@SessionAttribute(name = "login", required = false) StudentPojo login, ModelMap map) {
		if (login != null) {
			List<StudentPojo> students = service.searchAll();
			map.addAttribute("students", students);
			return "RemoveStudent";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}

	@PostMapping("/remove")
	public String removeData(@SessionAttribute(name = "login", required = false) StudentPojo login,
			@RequestParam int id, ModelMap map) {
		if (login != null) {
			StudentPojo student = service.remove(id);
			if (student != null) {
				map.addAttribute("student", student);
				map.addAttribute("msg", "Data remove successfully..!!");
			} else {
				map.addAttribute("msg", "ooppss..Data not remove..!!");
			}
			return "RemoveStudent";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}

	@GetMapping("/search")
	public String search(@SessionAttribute(name = "login", required = false) StudentPojo login, ModelMap map) {
		if (login != null) {
			return "SearchStudent";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}

	@PostMapping("/search")
	public String searchData(@SessionAttribute(name = "login", required = false) StudentPojo login,
			@RequestParam int id, ModelMap map) {
		if (login != null) {
			StudentPojo student = service.search(id);
			if (student != null) {
				map.addAttribute("student", student);
			} else {
				map.addAttribute("msg", "ooppss..Data not found..!!");
			}

			return "SearchStudent";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}

	@GetMapping("/update")
	public String updateStudent(@SessionAttribute(name = "login", required = false) StudentPojo login, ModelMap map) {
		if (login != null) {
			List<StudentPojo> students = service.searchAll();
			map.addAttribute("students", students);
			return "UpdateStudent";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}

	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login", required = false) StudentPojo login,
			@RequestParam int id, ModelMap map) {
		if (login != null) {
			StudentPojo student = service.search(id);
			if (student != null) {
				map.addAttribute("student", student);
			} else {
				map.addAttribute("msg", "ooppss..Student data is not found..!!");
			}
			return "UpdateStudent";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}

	@PostMapping("/updateData")
	public String updateData(@SessionAttribute(name = "login", required = false) StudentPojo login,
			@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String city, @RequestParam String username, @RequestParam String password, ModelMap map) {
		if (login != null) {
			StudentPojo student = service.update(id, name, email, contact, city, username, password);
			if (student != null) {
				map.addAttribute("msg", "Student data updated successfully..!!");
				List<StudentPojo> students = service.searchAll();
				map.addAttribute("students", students);
				return "UpdateStudent";
			}
			map.addAttribute("msg", "ooppss..Student data not updated..!!");
			List<StudentPojo> students = service.searchAll();
			map.addAttribute("students", students);
			return "UpdateStudent";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "Logged out successfully..!!");
		return "Login";
	}
}
