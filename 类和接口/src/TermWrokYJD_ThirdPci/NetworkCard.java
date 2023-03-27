package TermWrokYJD_ThirdPci;

public class NetworkCard implements PCI{


    @Override
    public void start() {
        System.out.println("网卡开始传输数据");
    }

    @Override
    public void stop() {
        System.out.println("网卡停止传输数据");
    }

    @Override
    public void print() {
        System.out.println("***模拟网卡工作***");
        System.out.println("符合PCI插槽标准");
    }
}
