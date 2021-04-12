package org.lql.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Title: DirectMemoryOOM <br>
 * ProjectName: jvmTest <br>
 * description: 本机直接内存溢出 直接内存的容量大小可通过-XX:MaxDirectMemorySize参数来指定，默认与堆的最大值一致
 * -Xms20M -XX:MaxDirectMemorySize=10M<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/12 22:11 <br>
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
