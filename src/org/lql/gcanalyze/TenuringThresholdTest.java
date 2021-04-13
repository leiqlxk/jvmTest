package org.lql.gcanalyze;

/**
 * Title: TenuringThresholdTest <br>
 * ProjectName: jvmTest <br>
 * description: 经历多次gc后移动到老年代 <br>
 *-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1  -XX:+PrintTenuringDistribution -XX:+UseSerialGC
 *
 * survivor中相同年龄的所有对象大小的总和超过survivor空间的一半则年龄大于或等于该年龄的对象可以直接进入老年代
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution -XX:+UseSerialGC
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/13 16:41 <br>
 */
public class TenuringThresholdTest {
    private static final int _1MB = 1024 * 1024;

    // 经过一次gc存活的对象进入老年代
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
//        testTenuringThreshold();
        testTenuringThreshold2();
    }
}
