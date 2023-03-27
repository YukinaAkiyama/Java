package TermWrokYJD_ThirdPci;

public class Graphics implements PCI{
    @Override
    public void start() {
        System.out.println("显卡开始显示图像");
    }

    @Override
    public void stop() {
        System.out.println("显卡停止显示图像");
    }

    @Override
    public void print() {
        System.out.println("***模拟显卡工作***");
        System.out.println("符合PCI插槽标准");
    }
}
