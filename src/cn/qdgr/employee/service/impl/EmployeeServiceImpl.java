package cn.qdgr.employee.service.impl;

import java.util.List;

import cn.qdgr.employee.dao.EmployeeDAO;
import cn.qdgr.employee.domain.Department;
import cn.qdgr.employee.domain.Employee;
import cn.qdgr.employee.domain.PageBean;
import cn.qdgr.employee.service.EmployeeService;

/**
 * 员工管理业务层service的实现类
 * 
 * @author wikey
 * 
 */
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	/**
	 * 业务层登录的方法
	 */
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDAO
				.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDAO.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDAO.findByPage(currPage, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

}
