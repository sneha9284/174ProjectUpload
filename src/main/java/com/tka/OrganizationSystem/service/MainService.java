package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;






	public String addCountry(Country c) {
		String msg= dao.addCountry(c);

		if(Objects.isNull(msg)) {
			msg="Country is not addedd...";
		}

		return msg;


	}

	public String updatecountry(int id, Country c) {
		String msg=dao.updatecountry(id,c);
		if(Objects.isNull(msg))
		{
			msg="Country is updated";
		}
		return msg;
	}

	 public String deletecountry(int id) {
	        String msg = dao.deletecountry(id);
	        if (Objects.isNull(msg)) {
	            msg = "not delelted";
	        }
	        return msg;
	    }

	
	 public List<Country> getallRecordCountry() {
			List<Country> list= dao.getCountryRecord();
			return list;
}

	public Country getPerticularCountry(int id) {
		Country cntry= dao.getPerticularCountry(id);
             return cntry;
	}

	public String addEmployee(Employee emp) {


		String msg=dao.addEmployee(emp);

		if(Objects.isNull(msg)) {
			msg="Record is not be addedd...";
		}
		return msg;		

	}




	public String updateemployee(Employee emp) {

        String msg=dao.updateemployee(emp);
        if(Objects.isNull(msg))
        {
      	  msg="not updated";
        }
		return msg;
		
	}


	public String deleteEmployee(int id) {
		String msg=dao.deleteEmployee(id);
		if(Objects.isNull(msg))
		{
			msg="not deleted";
		}
		return msg;
	}

	public List<Employee> getEmployeeRecord() {

		List<Employee> list= dao.getEmployeeRecord();
              if(Objects.isNull(list))
              {
            	list=null;
              }
              return list;
	}

	

	
	public Employee getperticulaerrecord2(int id) {

			 Employee emp= dao.getperticulerrecord2(id);
		        if(Objects.isNull(emp))
		        {
		      	  emp=null;
		        }
		   
	return emp;
		}

	public List<Employee> checkStatus(String status) {
		List<Employee> list=dao.getchechStatus(status);
		if(Objects.isNull(list))
		{
			list=null;
		}
		return list;
	}
	public List<Employee> checkSalary(double salary) {
		List<Employee> list=dao.getchechSalary(salary);
		if(Objects.isNull(list))
		{
			list=null;
		}
		return list;
	}
	
	public HashMap loginCheck(Employee emp) {
	    Employee ee = dao.loginCheck(emp);
	    HashMap map = new HashMap();
	    if (Objects.isNull(ee)) {
	        map.put("msg", "Invalid User");
	        map.put("user", ee); // Issue: Null user is being added here
	    } else {
	        map.put("msg", "Valid User");
	        map.put("user", ee); // Issue: Null user is being added here
	    }
	    return map;

	
}

	
}