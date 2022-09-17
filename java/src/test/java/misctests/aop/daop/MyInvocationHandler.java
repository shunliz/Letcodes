package misctests.aop.daop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	private Object target;
	
	public MyInvocationHandler() {
		super();
	}
	
	MyInvocationHandler(Object target){
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("getName".equals(method.getName())){
			System.out.println("**********before"+method.getName()+"********");
			Object result = method.invoke(target, args);
			System.out.println("*********"+method.getName()+"************");
			return result;
		}else{
			Object result = method.invoke(target, args);
			return result;
		}
	}

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		InvocationHandler invocationHandler = new MyInvocationHandler(userService);
		UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), invocationHandler);
		System.out.println(userServiceProxy.getName(1));
		System.out.println(userServiceProxy.getAge(1));
	}
	
}
