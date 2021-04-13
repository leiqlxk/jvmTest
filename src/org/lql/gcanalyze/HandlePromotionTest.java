package org.lql.gcanalyze;

/**
 * Title: HandlePromotionTest <br>
 * ProjectName: jvmTest <br>
 * description: 分配担保测试(JDK 6 Update 24之后无效)
 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure=false -XX:+UseSerialGC <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/13 17:05 <br>
 */
public class HandlePromotionTest {
    private static final int _1MB = 1024 * 1024;

    public static void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }

    public static void main(String[] args) {
        testHandlePromotion();
    }
}
