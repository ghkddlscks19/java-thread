package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        log("runFlag = " + myTask.runFlag);
        thread.start();

        sleep(1000);
        myTask.runFlag = false;
        log("flag = " + myTask.runFlag + ", count = " + myTask.count + " in main") ;
    }

    static class MyTask implements Runnable {

//        boolean runFlag = true;
//        long count;
        volatile boolean runFlag = true;
        long count;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                count++;
                if(count % 100_000_000 == 0) {
                    log("flag = " + runFlag + ", count = " + count + " in while()") ;
                }
            }
            log("flag = " + runFlag + ", count = " + count + " 종료") ;

        }
    }
}
