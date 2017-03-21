package cn.qdgr.employee.action;

import cn.qdgr.employee.domain.Department;
import cn.qdgr.employee.domain.Employee;
import cn.qdgr.employee.domain.PageBean;
import cn.qdgr.employee.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工管理的action
 * 
 * @author wikey
 * 
 */
public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee> {
	// 模型驱动使用的对象
	private Employee employee = new Employee();

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}

	// 注入业务层的类
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * 登录执行的方法
	 */
	public String login() {
		System.out.println("login执行中");
		// 调用业务层的方法
		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			// 登录失败
			this.addActionError("用户名或者密码错误!");
			return INPUT;
		} else {
			// 登录成功
			ActionContext.getContext().getSession()
					.put("existEmployee", existEmployee);
			return SUCCESS;
		}

	}
	//设置当前页码
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 提供一个查询的方法
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		// 将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

}
