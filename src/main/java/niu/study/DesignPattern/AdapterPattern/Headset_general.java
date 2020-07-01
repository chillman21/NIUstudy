package niu.study.DesignPattern.AdapterPattern;

/**
 * 普通耳机  不适配iPhone7
 */
public class Headset_general {
    public void outputMusic(){
        //表明谁在使用耳机
        System.out.println(this.getClass()+"使用标准耳机播放了音乐~");
    };
}
