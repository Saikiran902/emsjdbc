package com.cg.ems.ui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class TestEmployeeClient {
      static Scanner sc = null;
      static EmployeeService empSer=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     sc= new Scanner(System.in);
     empSer=new EmployeeServiceImpl();
     int choice=0;
     while(true){
    	 System.out.println("what do you want to do?");
    	 System.out.println("1.add emp\t 2.fetch all emp\n");
    	 System.out.println("3.delete emp\t 4.search emp by id\n");
    	 System.out.println("5.search emp by name\t 6.update\n");
    	 System.out.println("7.exit\n");
    	 System.out.println("enterr your choice");
    	 choice = sc.nextInt();
    	 switch(choice){
    	 case 1:addemp();break;
    	 case 2:showEmpInfo();break;
    	 case 4:getEmpById();break;
    	 case 5:searchEmpByName();break;
    	 case 3:deleteEmp();break;
    	 case 6:updateEmp();break;
    	 default:System.exit(0);
    	 }
    	 
    
    	 
     }
	}
	private static void updateEmp() {
		// TODO Auto-generated method stub
		System.out.println("enter emp id");
		int d=sc.nextInt();
		System.out.println("enter name to update");
		String s = sc.next();
		System.out.println("enter salary to update");
		float f = sc.nextFloat();
		Employee emp = empSer.updateEmp(d, s, f);
		System.out.println(emp.getEmpId()+"\t\t"+emp.getEmpName()+"\t\t"+emp.getEmpSal());
	}
	private static void deleteEmp() {
		// TODO Auto-generated method stub
		System.out.println("enter emp id");
		int eid = sc.nextInt();
		empSer.deleteEmp(eid);
		System.out.println("updated successfully");
		
	}
	private static void searchEmpByName() {
		// TODO Auto-generated method stub
		System.out.println("enter emp name");
		String uname = sc.next();
		
		HashSet<Employee> empset1= empSer.searchEmpByName(uname);
		System.out.println(empset1);
	}
	private static void getEmpById() {
		// TODO Auto-generated method stub
		System.out.println("enter eid");
		int eid=sc.nextInt();
		empSer.getEmpById(eid);
	}
	private static void showEmpInfo() {
		// TODO Auto-generated method stub
		HashSet<Employee> empSet=empSer.fetchAllEmp();
	Iterator<Employee> it =empSet.iterator();
	System.out.println("---------------");
	System.out.println("empid\t empname\t empsalary");
	while(it.hasNext()){
		Employee ee=it.next();
		System.out.println(ee.getEmpId()+"\t\t"+ee.getEmpName()+"\t\t"+ee.getEmpSal()+"\t\t"+ee.getEmpDOJ());
	}
	
	}
	private static void addemp() {
		// TODO Auto-generated method stub
		System.out.println("enter emp id");
		String eid=sc.next();
		try{
			if(empSer.validateDigit(eid)){
				System.out.println("enter emp name");
				String nm=sc.next();
				if(empSer.validateName(nm)){
				System.out.println("enter salary");
				float sal=sc.nextFloat();
				System.out.println("enter doj(dd-MMM-yyyy");
				String empDOJStr =sc.next();
				Employee ee = new Employee(Integer.parseInt(eid),nm,sal);
				int empId=empSer.addEmployee(ee);
				System.out.println(empId+"added successfully");
				
			}
		}
	}
catch(EmployeeException e){
	e.printStackTrace();
}
	}
}
