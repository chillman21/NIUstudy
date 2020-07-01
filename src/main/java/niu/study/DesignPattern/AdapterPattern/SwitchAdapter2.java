package niu.study.DesignPattern.AdapterPattern;

/**
 * 转换头 对象适配器版
 */
public class SwitchAdapter2 implements iPhone7 {
    private Headset_general headset = new Headset_general();
    @Override
    public void music() {
        headset.outputMusic();
    }
}
