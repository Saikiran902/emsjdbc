package com.cg.ems.dao;

public interface QueryMapper {
  public static final String SELECTQRY1 = "SELECT * FROM employee_160708";
  public static final String SELECTQRY2 = "SELECT * FROM employee_160708 WHERE emp_id=?";
  public static final String INSERTQRY1= "INSERT INTO employee_160708 VALUES(123456,'Anil',43000,'16-Dec-1997')";
  public static final String INSERTQRY2 = "INSERT INTO employee_160708(emp_id,emp_name,emp_sal)"+"VALUES(234567,'Amit',9000)";
  public static final String INSERTQRY3 =  "INSERT INTO employee_160708(emp_id,emp_name,emp_sal)" + "VALUES(?,?,?)";
  public static final String DELETEQRY1 = "DELETE FROM employee_160708 WHERE emp_id=?";
  public static final String UPDATEQRY1 = "UPDATE employee_160708 SET emp_name=?,emp_sal=? WHERE emp_id=?";
}
