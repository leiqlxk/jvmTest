package org.lql.gcanalyze;

/**
 * Title: PertenureSizeTest <br>
 * ProjectName: jvmTest <br>
 * description: 大对象分配测试 <br>
 *  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/13 16:26 <br>
 */
public class PretenureSizeTest {

    private static final int _1MB = 1024 * 1024;

    public static void testPertenureSizeThreshold() {
        byte[] allocation;

        //直接进入老年代
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testPertenureSizeThreshold();
    }
}
