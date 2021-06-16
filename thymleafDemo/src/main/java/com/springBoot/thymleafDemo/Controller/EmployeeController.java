package com.springBoot.thymleafDemo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.thymleafDemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	
	private List<Employee> thEmployees;
	
	@PostConstruct
	private void loadData() {
		
		Employee emp1=new Employee(1, "krishna", "koramutla", "krishna@gmail.com");
		Employee emp2=new Employee(2, "ram", "koramutla", "ram@gmail.com");
		Employee emp3=new Employee(3, "harish", "koramutla", "harish@gmail.com");
		
		thEmployees=new ArrayList<>();
		
		thEmployees.add(emp1);
		thEmployees.add(emp2);
		thEmployees.add(emp3);	
		
		}
	



@GetMapping("/list")
public String listEmployees(Model model) {
	
	model.addAttribute("employees",thEmployees);
	
	
	return "list-employes";
}

}



