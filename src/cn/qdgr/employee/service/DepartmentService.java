package cn.qdgr.employee.service;

import cn.qdgr.employee.domain.Department;
import cn.qdgr.employee.domain.PageBean;

/**
 * 部门管理业务层的接口
 * @author wikey
 *
 */
public interface DepartmentService {
	
	PageBean<Department> findByPage(Integer currPage);
}
