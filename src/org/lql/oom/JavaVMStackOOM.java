package org.lql.oom;

/**
 * Title: JavaVMStackOOM <br>
 * ProjectName: jvmTest <br>
 * description: 栈内存溢出 -Xss2m <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/12 21:38 <br>
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });

            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
