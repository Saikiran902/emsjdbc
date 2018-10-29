package com.cg.ems.dao;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	  Connection con = null;
	  Statement st = null;
	  PreparedStatement pst = null;
	  ResultSet rs =  null;

	@Override
	public int addEmployee(Employee ee) throws EmployeeException {
		// TODO Auto-generated method stub
		try{
			con=DBUtil.getCon();
			pst=con.prepareStatement(QueryMapper.INSERTQRY3);
			pst.setInt(1, ee.getEmpId());
			pst.setString(2, ee.getEmpName());
			pst.setFloat(3,ee.getEmpSal());
			int data = pst.executeUpdate();
			if(data==1){
				return ee.getEmpId();
			}
			else
			{
				return 0;
			}
		}
		catch(Exception e){
			throw new EmployeeException(e.getMessage());
		}
		finally{
			
		}
	}

	@Override
	public HashSet<Employee> fetchAllEmp() {
		// TODO Auto-generated method stub
		HashSet<Employee> empSet = new HashSet<Employee>();
		try {
			con = DBUtil.getCon();
			st = con.createStatement();
			rs = st.executeQuery(QueryMapper.SELECTQRY1);
			while(rs.next()){
				int eid = rs.getInt("emp_id");
				String enm = rs.getString("emp_name");
				float sl = rs.getFloat("emp_sal");
				empSet.add(new Employee(eid,enm,sl));
			}
		} 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empSet;
	}

	@Override
	public Employee getEmpById(int empId) {
		// TODO Auto-generated method stub
	   /* HashSet<Employee> empSet = CollectionUtil.getAllEmp();
		Iterator<Employee> it = empSet.iterator();
		while(it.hasNext()){
			Employee e =it.next();
			if(e.getEmpId()==empId){
				System.out.println(e.getEmpId()+"\t\t"+e.getEmpName()+"\t\t"+e.getEmpSal());
			}
		}*/
		return null;
	}

	@Override
	public HashSet<Employee> searchEmpByName(String name) {
		// TODO Auto-generated method stub
	/*	HashSet<Employee> empSet= CollectionUtil.getAllEmp();
		Iterator<Employee> it = empSet.iterator();
		HashSet<Employee> empset1 = new HashSet<Employee>();
		while(it.hasNext()){
			Employee e =it.next();
			if(name.equals(e.getEmpName())){
				empset1.add(e);
				return empset1;
			}
		}*/
		return null;
	}

	@Override
	public int deleteEmp(int empId) {
		// TODO Auto-generated method stub
	try{
		con  =DBUtil.getCon();
		pst = con.prepareStatement(QueryMapper.DELETEQRY1);
		pst.setInt(1,empId);
		int data = pst.executeUpdate();
		if(data>0){
			System.out.println("record deleted");
		}
		else
		{
			System.out.println("record not found");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
		return 0;
	}

	@Override
	public Employee updateEmp(int empId, String newName, float newSal) {
		// TODO Auto-generated method stub
		try{
		con=DBUtil.getCon();
		pst = con.prepareStatement(QueryMapper.UPDATEQRY1);
		pst.setString(1, newName);
		pst.setFloat(2, newSal);
		pst.setInt(3, empId);
		int data = pst.executeUpdate();
		if(data>0){
			System.out.println("updated successfully");
		}
		else{
			System.out.println("record not found");
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
