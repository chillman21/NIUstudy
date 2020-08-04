package niu.study.thread.uncaughtexception;

import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 描述：     自己的MyUncaughtExceptionHanlder
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String name;
    private PrintStream out;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, "线程异常，终止啦" + t.getName());
        out.println(name + "捕获了异常" + t.getName() + "异常" + e);
    }
}
