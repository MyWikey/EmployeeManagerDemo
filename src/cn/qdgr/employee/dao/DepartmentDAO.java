package cn.qdgr.employee.dao;

import java.util.List;

import cn.qdgr.employee.domain.Department;

/**
 * 部门管理DAO的接口
 * 
 * @author wikey
 * 
 */
public interface DepartmentDAO {
	int findCount();
	List<Department> findByPage(int currPage,int pageSize);
}
