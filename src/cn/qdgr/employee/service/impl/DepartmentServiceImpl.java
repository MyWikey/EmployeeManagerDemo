package cn.qdgr.employee.service.impl;

import java.util.List;

import cn.qdgr.employee.dao.DepartmentDAO;
import cn.qdgr.employee.domain.Department;
import cn.qdgr.employee.domain.PageBean;
import cn.qdgr.employee.service.DepartmentService;

/**
 * 部门管理业务层的实现类
 * 
 * @author wikey
 * 
 */
public class DepartmentServiceImpl implements DepartmentService {
	// 注入部门管理的DAO
	private DepartmentDAO departmentDao;

	public void setDepartmentDao(DepartmentDAO departmentDao) {
		this.departmentDao = departmentDao;
	}
	//分页查询部分的方法
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

}
