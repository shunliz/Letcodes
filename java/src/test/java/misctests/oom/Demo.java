package misctests.oom;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * JVM参数设置：
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class Demo {
    public static void main(String[] args) {
        while(true) {
            getOpenCoder();
        }
    }

    /**
     * 动态生成一个OpenCoder的子类并调用study方法
     */
    private static void getOpenCoder() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OpenCoder.class);
        enhancer.setUseCache(false);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if(method.getName().equals("study")){
                    return methodProxy.invokeSuper(o,objects);
                }else{
                    return methodProxy.invokeSuper(o,objects);
                }
            }
        });

        OpenCoder openCoder = (OpenCoder) enhancer.create();
        openCoder.study();
    }
}

class OpenCoder{
    public void study(){
        System.out.println("study......");
    }
}