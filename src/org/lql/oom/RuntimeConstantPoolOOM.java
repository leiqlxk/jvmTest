package org.lql.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: RuntimeConstantPoolOOM <br>
 * ProjectName: jvmTest <br>
 * description: 运行时常量池 在jdk6或之前常量池都是分配在永久代中可以通过-XX:PermSize和-XX:MaxPermSize限制永久代的大小
 * -XX:PermSize=6M -XX:MaxPermSize=6M
 * 在jdk8及以上版本使用 -XX:MaxMetaspaceSize其实也并没有效果，在jdk7后原本放在永久代的字符串常量池被移到了java堆中，方法区
 * 中剩余部分才是在元空间中，受此参数的控制<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/12 21:44 <br>
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
