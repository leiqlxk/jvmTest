package org.lql.toolTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: JConsoleTest <br>
 * ProjectName: jvmTest <br>
 * description: jconsole测试类
 * -Xms100m -Xmx100m -XX:+UseSerialGC<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/14 10:25 <br>
 */
public class JConsoleTest {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    //测试gc
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
//        fillHeap(1000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object object = new Object();
        createLockThread(object);
    }

    //线程死循环演示
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) ;
            }
        }, "testBusyThread");

        thread.start();
    }

    //线程锁等待演示
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    }catch (InterruptedException e) {

                    }
                }
            }
        }, "testLockThread");

        thread.start();
    }
}
