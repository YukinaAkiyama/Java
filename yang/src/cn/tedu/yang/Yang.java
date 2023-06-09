package cn.tedu.yang;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;


public class Yang extends JFrame {
    /**
     * 窗口中内容面面板
     */
    private JPanel panel = new JPanel();
    /**
     * JLabel 是Swing中用于显示文字和图片的控件
     */
    private JLabel background;

    /**
     * 利用List集合保存全部的卡牌
     */
    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * 利用List表示下方从槽子
     */
    private ArrayList<Card> though = new ArrayList<>();

    /**
     * 利用数组存储全部的 名称
     */
    private String[] names = {"一万", "三万", "四万", "八万", "九万", "中",
            "一筒", "三筒", "四筒", "七筒", "八筒", "九筒",
            "幺鸡", "三条", "四条", "七条", "八条", "九条"};

    /**
     * 创建一个定时器，Java中提供单线程，定时计划
     */
    //private ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
    private Timer timer = new Timer();
    private static int count=0;
    public Yang() {
        try {
            // 获取音频输入流
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("bgm.wav"));
            // 获取音频剪辑
            Clip clip = AudioSystem.getClip();
            // 打开音频剪辑并将音频输入流加载到剪辑中
            clip.open(audioInputStream);
            if(count==0) {
                // 播放背景音乐
                clip.start();
                //循环播放背景音乐
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置窗口标题
        setTitle("麻了个将");
        //设置窗口大小
        setSize(500, 700);
        //设置窗口居中
        setLocationRelativeTo(null);
        //设置关闭窗口时候退出程序
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //将内容面板添加到 窗口中
        add(panel);
        //关闭panel的布局管理器
        panel.setLayout(null);
        //加载图片
        background = new JLabel(new ImageIcon("images/背景.jpg"));
        //关闭布局以后，需要自定义元素位置才能显示
        background.setLocation(0, 0);
        background.setSize(490, 670);
        //显示图片
        panel.add(background);
        init();
    }

    /**
     * 创建全部卡牌，创建的牌放到集合 cards 中
     *
     * @param times 是次数，需要是3的整数倍
     *              如 3 6 9 等
     */
    private void createCards(int times) {
        for (int i = 0; i < times; i++) {
            for (String name : names) {
                Card card = new Card(name);
                cards.add(card);
            }
        }
    }

    /**
     * 初始化游戏
     */
    private void init() {
        //利用 Card 简化代码
        createCards(6);
        System.out.println(cards.size());
        //System.out.println(cards);
        printCards();
        //shuffle 洗牌，打乱
        Collections.shuffle(cards);
        // System.out.println(cards);
        printCards();
        //摆放牌到屏幕上
        deal(63, 60, 0, 8, 6);
        deal(63 + 30, 60 + 33, 42, 6, 5);
        deal(63, 60 + 66, 42 + 30, 5, 6);
        //deal(33+30, 100+33, 42+30+28, 5, 6);
        checkCovered();
        //添加动作： 为每张牌添加鼠标点击事件。
        addAction();
    }

    /**
     * 为每个卡牌添加鼠标点击事件
     */
    private void addAction() {
        for (Card card : cards) {
            //Card 从 JButton 继承了 添加鼠标事件方法。
            //ActionListener 是一个只有一个方法的功能性接口，可以利用lamdba进行实现
            card.addActionListener(e -> {
                System.out.println("点击卡牌");
                //事件来源就是被点击的牌， 称为被选定的牌对象
                Card selected = (Card) e.getSource();
                System.out.println(selected);
                //使用方法处理点击事件: 卡牌进入槽子里
                cardToThough(selected);
            });
        }
    }

    private void cardToThough(Card selected) {
        if (though.size() == 7) {
            count++;
            Object ch[]={"重新开始","退出游戏"};
            //n判断返回值确定不同返回值发生的事件
            int n=JOptionPane.showOptionDialog(null,"game over","失败"
                    ,JOptionPane.YES_NO_OPTION
                    ,JOptionPane.QUESTION_MESSAGE,null,ch,ch[1]);
            if (n==0){
                new Yang().setVisible(true);
                dispose();
            }else{
                dispose();
                System.exit(0);
            }
        }
        //从原有集合中删除卡牌
        cards.remove(selected);
        //从 cards中删除的牌，去除鼠标事件
        selected.removeActionListeners();
        //移动显示位置到槽子中
        //查找插入位置
        int found = -1;
        for (int i = 0; i < though.size(); i++) {
            Card card = though.get(i);
            if (card.sameAs(selected)) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            //如果没有找到牌，就插入到最后
            though.add(selected);
        } else {
            //如果找到了牌， 就插入到找到的位置
            though.add(found, selected);
        }
        tryRemoveCards(found, selected);
        //重新排列牌的显示位置
        int x = 22;
        for (Card card : though) {
            card.setLocation(x, 577);
            x += 63;
        }
        panel.repaint();
        checkCovered();
    }

    private void tryRemoveCards(int found, Card selected) {
        //在最后时候追加时候，不需要删除牌
        if (found == -1) {
            return;
        }
        //当前位置开始，到最后要至少有3张牌
        if (found + 3 <= though.size()) {
            //检查当前牌和下下张牌是否一样
            Card nextNextCard = though.get(found + 2);
            if (selected.sameAs(nextNextCard)) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //连续删除3张牌
                        Card c1 = though.remove(found);
                        Card c2 = though.remove(found);
                        Card c3 = though.remove(found);
                        //从界面上删除 卡牌
                        panel.remove(c1);
                        panel.remove(c2);
                        panel.remove(c3);
                        int x = 22;
                        for (Card card : though) {
                            card.setLocation(x, 577);
                            x += 63;
                        }
                        panel.repaint();
                    }
                }, 200);
            }
        }
    }

    /**
     * 检查全都的牌相互遮挡关系
     */
    private void checkCovered() {
        //检查每个牌，是否被后续牌遮挡，如果遮挡就是 disable状态，否则是enable
        for (int i = 0; i < cards.size(); i++) {
            //找到当前牌
            Card card1 = cards.get(i);
            //检查后续牌是否遮盖了这张牌
            card1.setEnabled(true);
            for (int j = i + 1; j < cards.size(); j++) {
                Card card2 = cards.get(j);
                //检查后一张牌card2是否遮盖了牌card1
                if (card2.covered(card1)) {
                    card1.setEnabled(false);
                }
            }
        }
    }

    private void printCards() {
        int i = 1;
        for (Card card : cards) {
            System.out.print(card + " ");
            if (i++ % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * 摆放牌，摆放到没有牌就会自动结束
     *
     * @param x     左上角的坐标x  x:33
     * @param y     左上角的坐标y  y:100
     * @param start 开始位置：0  42  42+30
     * @param rows  摆放行数  6
     * @param cols  摆放列数  7
     */
    private void deal(int x, int y, int start, int rows, int cols) {
        //              循环到固定次数 并且还有可以使用的牌
        for (int i = 0; i < rows * cols && i + start < cards.size(); i++) {
            int x0 = x + i % cols * 59;
            int y0 = y + i / cols * 66;
            Card card = cards.get(i + start);
            card.setLocation(x0, y0);
            card.setEnabled(false);
            panel.add(card, 0);
        }
    }

    public static void main(String[] args) {
        Yang yang = new Yang();
        yang.setVisible(true);
    }
}
