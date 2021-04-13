package org.lql.gcanalyze;

/**
 * Title: FinalizeEscapeGC <br>
 * ProjectName: jvmTest <br>
 * description: 从finalize中自我拯救
 * 这种拯救的机会只有一次，因为一个对象的finalize方法最多只会被系统自动调用一次<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/13 9:54 <br>
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void  isAlive() {
        System.out.println("yes, i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method excuted!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        //第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
        //F-QUEUE调度优先级低，睡眠0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no, i am dead");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no, i am dead");
        }

    }
}
