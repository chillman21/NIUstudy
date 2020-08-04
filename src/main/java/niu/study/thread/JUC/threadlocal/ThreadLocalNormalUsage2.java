package niu.study.thread.JUC.threadlocal;

import niu.study.thread.Stream.User;

/**
 * ThreadLocal用法2：每个线程内需要保存全局变量（例如在拦截器中获取用户信息），可以让不用方法直接使用，避免参数传递的麻烦。
 * @author NIU
 * @createTime 2020/7/31 14:36
 */
public class ThreadLocalNormalUsage2 {
    public static void main(String[] args) {
        new Service1().process();
    }
}

class Service1 {
    public void process() {
        User user = new User("柴鸥");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service2" + user);
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3" + user);
    }
}
class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}
