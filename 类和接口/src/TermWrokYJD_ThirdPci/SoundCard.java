package TermWrokYJD_ThirdPci;

public class SoundCard implements PCI{


    @Override
    public void start() {
        System.out.println("声卡开始发出声音");
    }

    @Override
    public void stop() {
        System.out.println("声卡停止发出声音");
    }

    @Override
    public void print() {
        System.out.println("***模拟声卡工作***");
        System.out.println("符合PCI插槽标准");
    }
}
