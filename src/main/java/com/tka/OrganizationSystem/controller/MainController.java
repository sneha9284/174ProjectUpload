package com.tka.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
import com.tka.OrganizationSystem.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {
	@Autowired
	MainService service;
	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {
		//System.out.println(c);

		String msg= service.addCountry(c);
		return msg;

	}
	@PutMapping("update/{id}")
	public String updateCountry(@PathVariable int id ,@RequestBody Country c)
	{
		String msg=service.updatecountry(id,c);
		return msg;
	}
	
	  @DeleteMapping("delete/{id}")
	    public String deleteCountry(@PathVariable int id) {
	        String msg = service.deletecountry(id);
	        return msg;
	    }
	  @GetMapping("getallcountry")
	  public List<Country> getCountry()
	  {
		List<Country> list=service.getallRecordCountry();
		  return list;
	  }
	  @GetMapping("getperticularrecordcountry/{id}")
	  public Country getPerticularCountry(@PathVariable int id)
	  {
		  Country cntry=service. getPerticularCountry(id); 


		return cntry;
	  }

	  
	 
	  @PostMapping("addemp")
		public String addEmployee(@RequestBody Employee emp) {
		  System.out.println(emp);

			String msg= service.addEmployee(emp);
			return msg;

		}
	  @PutMapping("updateemp")
	  public String updateEmployee(@RequestBody Employee emp)
	  {
		  String msg=service.updateemployee(emp);
		  return msg;
	  }
	  @DeleteMapping("delete1/{id}")
	  public String deleleteEmployee(@PathVariable int id)
	  {
		  String msg=service.deleteEmployee(id);
		  return msg;
	  }
	  @GetMapping("getallemp")
	  public List<Employee> getEmployee()
	  {
		List<Employee> list=service.getEmployeeRecord();
		  return list;
	  }
	  @GetMapping("getrecord1/{id}")
	  public Employee getPerticularEmployee2(@PathVariable int id)
	  {
		Employee emp=service.getperticulaerrecord2(id); 


		return emp;
	  }
	  @GetMapping("getempbystatus/{status}")
	  public List<Employee> chechStatus(@PathVariable String status)
	  {
		List<Employee> list = service.checkStatus(status);
		return list;
	  }
	  @GetMapping("getempbysalary/{salary}")
	  public List<Employee> chechSalary(@PathVariable double salary)
	  {
		List<Employee> list = service.checkSalary(salary);
		return list;
	  } 
	  
	  
	  @PostMapping("login")
	  public HashMap loginCheck(@RequestBody Employee emp) {
	      HashMap map = service.loginCheck(emp);
	      return map;
	  }
}