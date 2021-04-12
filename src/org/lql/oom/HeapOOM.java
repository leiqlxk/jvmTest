package org.lql.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: HeapOOM <br>
 * ProjectName: jvmTest <br>
 * description: 堆内存溢出测试类 -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/12 17:11 <br>
 */
public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
