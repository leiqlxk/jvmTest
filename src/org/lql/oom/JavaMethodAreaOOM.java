package org.lql.oom;

import java.lang.reflect.Method;

/**
 * Title: JavaMethodAreaOOM <br>
 * ProjectName: jvmTest <br>
 * description: 方法区内存溢出 jdk7及之前 -XX:PerSize=10M -XX:MaxPermSize
 * jdk8及之后 -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/12 22:01 <br>
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            //使用cglib动态创建类
           /* Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();*/
        }
    }

    static class OOMObject{

    }
}
