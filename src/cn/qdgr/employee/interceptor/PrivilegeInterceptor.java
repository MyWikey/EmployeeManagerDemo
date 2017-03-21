package cn.qdgr.employee.interceptor;

import java.util.Map;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 后台权限拦截器，防止未登录的用户登录
 * @author wikey
 *
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {
	
	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
//		actionInvocation.invoke();执行下一个拦截器，如果是最后一个则执行Action
		ActionContext context = ActionContext.getContext();
		if(context.getSession().get("existEmployee") != null){
			String result = actionInvocation.invoke();
			System.out.println("拦截器中invocation.invoke()返回的值是方法名："+result);
			return result;
		}else{
			System.out.println("PrivilegeInterceptor拦截器拦截了您的操作，未登入或账号密码有误");
			return "login";
		}
	}

}
