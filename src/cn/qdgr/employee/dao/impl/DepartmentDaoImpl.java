package cn.qdgr.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.qdgr.employee.dao.DepartmentDAO;
import cn.qdgr.employee.domain.Department;
/**
 * 部门管理DAO的接口实现类
 * @author wikey
 *
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDAO {
	/**
	 * 查询部门的所有数量
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
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
	public List<Department> findByPage(int currPage, int pageSize) {
			DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
			List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, currPage, pageSize);
			return list;
	}
	

}
