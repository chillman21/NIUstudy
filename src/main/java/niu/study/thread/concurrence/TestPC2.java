package niu.study.thread.concurrence;
//测试：生产者消费者模型：信号灯法，标志位解决
public class TestPC2 {
    public static void main(String[] args) {
        Program program = new Program();
        new Actor(program).start();
        new Watcher(program).start();
    }
}
//生产者-->演员
class Actor extends Thread{
    Program program;
    public  Actor(Program program){
        this.program = program;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0) this.program.play("快乐大本营播放中");
            else this.program.play("广告");
        }
    }
}

//消费者-->观众
class Watcher extends Thread {
    Program program;
    public  Watcher(Program program){
        this.program = program;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            program.watch();
        }
    }
}

//产品-->节目
class Program{
    //演员表演，观众等待 T
    //观众观看，演员等待 F
    String voice;//表演的节目
    boolean flag = true;

    //表演
    public synchronized void play(String voice){
        if (!flag){//如果观众在观看
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.voice = voice;
        System.out.println("演员表演了："+voice);
        //通知观众观看
        this.notifyAll();//通知唤醒

        this.flag = !this.flag;
    }
    //观看
    public synchronized void watch(){
        if (flag){//如果演员在表演
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了："+voice);
        //通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }
}
