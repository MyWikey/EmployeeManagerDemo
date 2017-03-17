package cn.qdgr.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.qdgr.employee.dao.EmployeeDAO;
import cn.qdgr.employee.domain.Department;
import cn.qdgr.employee.domain.Employee;

/**
 * 员工管理的DAO具体实现类
 * 
 * @author wikey
 * 
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDAO {

	@Override
	/**
	 * 根据用户名和密码查询用户的方法
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username= ? and password= ?";
		List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	/**
	 * 查询所有员工数
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * 分页查询部门
	 */
	@Override
	public List<Employee> findByPage(int currPage, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria, currPage, pageSize);
		return list;
	}
}
