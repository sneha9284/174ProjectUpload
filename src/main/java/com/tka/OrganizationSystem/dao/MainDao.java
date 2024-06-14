package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {		
		 session= factory.openSession();
		tx=session.beginTransaction();		
		session.persist(c);
		tx.commit();
		msg="Country is addedd...";
		}catch (Exception e) {

			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();			
		}finally {

			if(session!=null) {
				session.close();
			}			
		}

		return msg;		
	}

	public String updatecountry(int id, Country c) {

		Session session=null;
		Transaction tx=null;
		String msg=null;
        try
        {
		session=factory.openSession();
		tx=session.beginTransaction();
		Country c1=session.get(Country.class, id);
		c1.setCname(c.getCname());
		session.merge(c);
		tx.commit();
		msg="Updated sucessfully....";
		
	}catch(Exception e)
        {
		if(tx!=null)
		{
			tx.rollback();
		}
		e.printStackTrace();
        }finally
        {
        	session.close();
        }
	

	
return msg;
}


	 public String deletecountry(int id) {
	        Session session = null;
	        Transaction tx = null;
	        String msg = null;
	        
	        try {
	            session = factory.openSession();
	            tx = session.beginTransaction();
	            Country coun = session.get(Country.class, id);
	            session.remove(coun);
	            tx.commit();
	            msg = "Deleted sucessfully....";
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }
	        return msg;
	    }

	 public List<Country> getCountryRecord() {
		
		String hquery="from Country";
		Session session = null;
        Transaction tx = null;
        List<Country> list = null;
        try
        {
		 session=factory.openSession();
        tx=session.beginTransaction();
        Query<Country> query= session.createQuery(hquery,Country.class);
         list=query.list();
        tx.commit();



	}catch(Exception e)
        {
		if(tx!=null)
		{
			tx.rollback();
		}
		e.printStackTrace();
        }finally
        {
        	session.close();
        }
        return list;
}

	


	 public Country getPerticularCountry(int id) {
			
		  Session session=null;
	         Transaction tx=null;
	         Country cntry=null;
	         try
	         {
	        	 session=factory.openSession();
	         	tx=session.beginTransaction();
	         	cntry=session.get(Country.class,id);

               tx.commit();

	}catch(Exception e)
	         {
	 if(tx!=null)
	 {
		 tx.rollback();
	 }
	e.printStackTrace();
}finally
 {
	if(session!=null)
	{
		session.close();
	}

}
			return cntry;
}


	public String addEmployee(Employee emp) {
		Session session=null;
		Transaction tx=null;
		String msg=null;		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();			
			session.persist(emp);
			tx.commit();			
			msg="Employee Addedd Successully..";			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateemployee(Employee emp) {

         Session session=null;
         Transaction tx=null;
         String msg=null;
         try
         {
        	session=factory.openSession();
        	tx=session.beginTransaction();
        	Employee employee=session.get(Employee.class, emp.getId());
        	employee.setName(emp.getName());
        	employee.setCountry(emp.getCountry());
        	employee.setCreatedby(emp.getCreatedby());
        	employee.setCreatedtm(emp.getCreatedtm());
        	employee.setUpdatedby(emp.getUpdatedby());
        	employee.setUpdateddtm(emp.getUpdateddtm());
        	employee.setDepartment(emp.getDepartment());
        	employee.setStatus(emp.getStatus());
        	employee.setPhoneno(emp.getPhoneno());
        	employee.setEmailid(emp.getEmailid());
        	employee.setSalary(emp.getSalary());
        	session.merge(employee);
        	tx.commit();
        	msg="Employee Updated Sucessfully";
         }catch(Exception e)
         {
        	 if(tx!=null)
        	 {
        		 tx.rollback();
        	 }
		e.printStackTrace();
	}finally
         {
		if(session!=null)
		{
			session.close();
		}
         }
return msg;
}

	public String deleteEmployee(int id) {
		  Session session=null;
	         Transaction tx=null;
	         String msg=null;
	         try
	         {
	        	 session=factory.openSession();
	         	tx=session.beginTransaction();
	            Employee emp = session.get(Employee.class, id);
	            session.remove(emp);
	            tx.commit();
	            msg = "Deleted sucessfully....";
	         }catch(Exception e)
	         {
	        	 if(tx!=null)
	        	 {
	        		 tx.rollback();
	        	 }
			e.printStackTrace();
		}finally
	         {
			if(session!=null)
			{
				session.close();
			}
	         }
	return msg;
	}

	public List<Employee> getEmployeeRecord() {
		 Session session=null;
         Transaction tx=null;
         List<Employee> list=null;
         String msg=null;
         String hqlQuery="from Employee";
         try
         {
        	 session=factory.openSession();
         	tx=session.beginTransaction();
               Query<Employee> query=session.createQuery(hqlQuery,Employee.class); 
               list=query.list();
            tx.commit();
	     }catch(Exception e)
         {
   	 if(tx!=null)
   	 {
   		 tx.rollback();
   	 }
	e.printStackTrace();
}finally
    {
	if(session!=null)
	{
		session.close();
	}
    }
return list;
}

	public Employee getperticulerrecord2(int id) {
		  Session session=null;
	         Transaction tx=null;
	         Employee emp=null;
	         try
	         {
	        	 session=factory.openSession();
	         	tx=session.beginTransaction();
 emp=session.get(Employee.class,id);

tx.commit();

	}catch(Exception e)
	         {
   	 if(tx!=null)
   	 {
   		 tx.rollback();
   	 }
	e.printStackTrace();
}finally
    {
	if(session!=null)
	{
		session.close();
	}
  
}
			return emp;
}
	public List<Employee> getchechStatus(String status) {
		 Session session=null;
         Transaction tx=null;
         Employee employee=null;
         String hqlQuery = "from Employee where status=:mystatus";
         List<Employee> list=null;
         try
         {
        	 session=factory.openSession();
         	tx=session.beginTransaction();
               Query<Employee> query=session.createQuery(hqlQuery,Employee.class); 
               query.setParameter("mystatus", status);
               list=query.list();
            tx.commit();
	     }catch(Exception e)
         {
   	 if(tx!=null)
   	 {
   		 tx.rollback();
   	 }
	e.printStackTrace();
}finally
    {
	if(session!=null)
	{
		session.close();
	}
    }
return list;
}


	public List<Employee> getchechSalary(double salary) {
		Session session=null;
        Transaction tx=null;
        Employee employee=null;
        String hqlQuery = "from Employee where salary=:mysalary";
        List<Employee> list=null;
        try
        {
       	 session=factory.openSession();
        	tx=session.beginTransaction();
              Query<Employee> query=session.createQuery(hqlQuery,Employee.class); 
              query.setParameter("mysalary", salary);
              list=query.list();
           tx.commit();
	     }catch(Exception e)
        {
  	 if(tx!=null)
  	 {
  		 tx.rollback();
  	 }
	e.printStackTrace();
}finally
   {
	if(session!=null)
	{
		session.close();
	}
   }
return list;

	}

	public Employee loginCheck(Employee emp) {
		 Session session=null;
         Transaction tx=null;
         Employee employee=null;
         String hqlQuery = "from Employee where emailid=:myemailid and phoneno=:myphone";

         try
         {
        	session=factory.openSession();
         	tx=session.beginTransaction();
         	Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
         	query.setParameter("myemailid",emp.getEmailid());
         	query.setParameter("myphone", emp.getPhoneno());
         	employee=query.uniqueResult();
         	tx.commit();
	}catch(Exception e)
         {
   	 if(tx!=null)
   	 {
   		 tx.rollback();
   	 }
	e.printStackTrace();
}finally
    {
	if(session!=null)
	{
		session.close();
	}
    }
return employee;
}

	
}
