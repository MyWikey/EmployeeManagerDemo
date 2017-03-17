package cn.qdgr.employee.dao;

import java.util.List;

import cn.qdgr.employee.domain.Employee;

/**
 * 员工管理的DAO接口
 * 
 * @author wikey
 * 
 */
public interface EmployeeDAO {
	Employee findByUsernameAndPassword(Employee employee);
	int findCount();
	List<Employee> findByPage(int currPage,int pageSize);
}
