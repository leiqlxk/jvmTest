package org.lql.gcanalyze;

/**
 * Title: AllocationTest <br>
 * ProjectName: jvmTest <br>
 * description: 分配内存测试类 <br>
 *-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/13 15:55 <br>
 */
public class AllocationTest {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        //出现一次gc
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
