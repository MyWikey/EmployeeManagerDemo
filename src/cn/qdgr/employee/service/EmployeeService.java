package cn.qdgr.employee.service;

import cn.qdgr.employee.domain.Employee;
import cn.qdgr.employee.domain.PageBean;

/**
 * 员工管理的service接口
 * 
 * @author wikey
 * 
 */
public interface EmployeeService {

	Employee login(Employee employee);
	PageBean<Employee> findByPage(Integer currPage );
}
