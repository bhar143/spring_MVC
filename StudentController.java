package com.greatlearning.springDEMO.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.springDEMO.entity.Students;
import com.greatlearning.springDEMO.service.Services;


@Controller
@RequestMapping("/students")
public class StudentController {
	
		
		@Autowired
		private Services studentService;
		
		@RequestMapping("/list")
		public String listStudents(Model model) {
			List<Students> students= studentService.findAll();
			model.addAttribute("students",students);
			return "studentslist";
		}
		
		@RequestMapping("/showFormForAdd")
		public String showForAdd(Model theModel) {
		      	
			// create model attribute to find from data
			Students Student = new Students();
			
			theModel.addAttribute("student",Student);
		
			return "newform";
		}
		
		@RequestMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("id") int theId,Model theModel) {
			
			// get the College from the service
			 Students std = studentService.findById(theId);
			
			// set College as a model attribute to pre-populate the form
			theModel.addAttribute("Student", std);
			
			//send over to our form
			return "newform";
		}
		
		@PostMapping("/save")
		public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
				@RequestParam("department") String department,@RequestParam("country") String country) {
			System.out.println(id);
			Students std;
			if(id!=0) {
			std = studentService.findById(id);
			std.setName(name);
			std.setDepartment(department);
			std.setCountry(country);
		} else
			std = new Students( name, department,country);
		//save the Book
		studentService.save(std);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/students/list";
		
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int theId) {
		
		// delete the Student
		studentService.deletedById(theId);
		
		//redirect to /Students/List
		return "redirect:/students/list";
		
	}

	
}
