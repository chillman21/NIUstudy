package niu.study.DesignPattern.AdapterPattern;

/**
 * 转换头
 */
public class SwitchAdapter extends Headset_general implements iPhone7 {
    @Override
    public void music() {
        super.outputMusic();
    }
}
