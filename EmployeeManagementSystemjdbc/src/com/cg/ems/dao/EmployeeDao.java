package com.cg.ems.dao;

import java.util.HashSet;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeDao {
public int addEmployee(Employee ee)throws EmployeeException;
public HashSet<Employee> fetchAllEmp();
public Employee getEmpById(int empId);
public HashSet<Employee> searchEmpByName(String name);
public int deleteEmp(int empId);
public Employee updateEmp(int empId,String newName,float newSal);

}
