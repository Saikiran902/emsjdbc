package com.cg.ems.service;

import java.time.LocalDate;
import java.util.HashSet;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeService {
	public int addEmployee(Employee ee)throws EmployeeException;
	public HashSet<Employee> fetchAllEmp();
	public Employee getEmpById(int empId);
	public HashSet<Employee> searchEmpByName(String name);
	public int deleteEmp(int empId);
	public Employee updateEmp(int empId,String newName,float newSal);
  public boolean validateDigit(String num) throws EmployeeException;
  public boolean validateName(String name)throws EmployeeException;
  public LocalDate convertFromStrToLocalDate(String dtStr);
  
}
