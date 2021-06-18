package com.springbootEmp.main.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.springbootEmp.main.entity.Employe;
import com.springbootEmp.main.service.EmployeService;

@Controller

public class EmployeController {

	private EmployeService employeService;

	@Autowired
	public EmployeController(EmployeService employeService) {

		this.employeService = employeService;
	}

	@GetMapping("/list")
	public String employeList(Model model) {
		List<Employe> employes = employeService.findAll();

		model.addAttribute("themploye", employes);

		return "list-employes";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd( Model model) {

		Employe thEmploye = new Employe();
		model.addAttribute("employee", thEmploye);
		return "employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employe thEmploye) {

		employeService.save(thEmploye);
		return "redirect:/list";

	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

		Employe thEmploye = employeService.findById(id);
		model.addAttribute("employee", thEmploye);

		return "employee-form";

	}

	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {

		employeService.deleteById(id);
		return "redirect:/list";

	}

}
