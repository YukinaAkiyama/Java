package yang;

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
     * ���������������
     */
    private JPanel panel = new JPanel();
    /**
     * JLabel ��Swing��������ʾ���ֺ�ͼƬ�Ŀؼ�
     */
    private JLabel background;

    /**
     * ����List���ϱ���ȫ���Ŀ���
     */
    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * ����List��ʾ�·��Ӳ���
     */
    private ArrayList<Card> though = new ArrayList<>();

    /**
     * ��������洢ȫ���� ����
     */
    private String[] names = {"һ��", "����", "����", "����", "����", "��",
            "һͲ", "��Ͳ", "��Ͳ", "��Ͳ", "��Ͳ", "��Ͳ",
            "�ۼ�", "����", "����", "����", "����", "����"};

    /**
     * ����һ����ʱ����Java���ṩ���̣߳���ʱ�ƻ�
     */
    //private ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
    private Timer timer = new Timer();
    private static int count=0;
    public Yang() {
        try {
            // ��ȡ��Ƶ������
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("bgm.wav"));
            // ��ȡ��Ƶ����
            Clip clip = AudioSystem.getClip();
            // ����Ƶ����������Ƶ���������ص�������
            clip.open(audioInputStream);
            if(count==0) {
                // ���ű�������
                clip.start();
                //ѭ�����ű�������
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //���ô��ڱ���
        setTitle("���˸���");
        //���ô��ڴ�С
        setSize(500, 700);
        //���ô��ھ���
        setLocationRelativeTo(null);
        //���ùرմ���ʱ���˳�����
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //�����������ӵ� ������
        add(panel);
        //�ر�panel�Ĳ��ֹ�����
        panel.setLayout(null);
        //����ͼƬ
        background = new JLabel(new ImageIcon("images/����.jpg"));
        //�رղ����Ժ���Ҫ�Զ���Ԫ��λ�ò�����ʾ
        background.setLocation(0, 0);
        background.setSize(490, 670);
        //��ʾͼƬ
        panel.add(background);
        init();
    }

    /**
     * ����ȫ�����ƣ��������Ʒŵ����� cards ��
     *
     * @param times �Ǵ�������Ҫ��3��������
     *              �� 3 6 9 ��
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
     * ��ʼ����Ϸ
     */
    private void init() {
        //���� Card �򻯴���
        createCards(6);
        System.out.println(cards.size());
        //System.out.println(cards);
        printCards();
        //shuffle ϴ�ƣ�����
        Collections.shuffle(cards);
        // System.out.println(cards);
        printCards();
        //�ڷ��Ƶ���Ļ��
        deal(63, 60, 0, 8, 6);
        deal(63 + 30, 60 + 33, 42, 6, 5);
        deal(63, 60 + 66, 42 + 30, 5, 6);
        //deal(33+30, 100+33, 42+30+28, 5, 6);
        checkCovered();
        //��Ӷ����� Ϊÿ�������������¼���
        addAction();
    }

    /**
     * Ϊÿ���������������¼�
     */
    private void addAction() {
        for (Card card : cards) {
            //Card �� JButton �̳��� �������¼�������
            //ActionListener ��һ��ֻ��һ�������Ĺ����Խӿڣ���������lamdba����ʵ��
            card.addActionListener(e -> {
                System.out.println("�������");
                //�¼���Դ���Ǳ�������ƣ� ��Ϊ��ѡ�����ƶ���
                Card selected = (Card) e.getSource();
                System.out.println(selected);
                //ʹ�÷����������¼�: ���ƽ��������
                cardToThough(selected);
            });
        }
    }

    private void cardToThough(Card selected) {
        if (though.size() == 7) {
            count++;
            Object ch[]={"���¿�ʼ","�˳���Ϸ"};
            //n�жϷ���ֵȷ����ͬ����ֵ�������¼�
            int n=JOptionPane.showOptionDialog(null,"game over","ʧ��"
                    ,JOptionPane.YES_NO_OPTION
                    ,JOptionPane.QUESTION_MESSAGE,null,ch,ch[1]);
            if (n==0){
                new Yang().setVisible(true);
                dispose();
            }else dispose();
        }
        //��ԭ�м�����ɾ������
        cards.remove(selected);
        //�� cards��ɾ�����ƣ�ȥ������¼�
        selected.removeActionListeners();
        //�ƶ���ʾλ�õ�������
        //���Ҳ���λ��
        int found = -1;
        for (int i = 0; i < though.size(); i++) {
            Card card = though.get(i);
            if (card.sameAs(selected)) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            //���û���ҵ��ƣ��Ͳ��뵽���
            though.add(selected);
        } else {
            //����ҵ����ƣ� �Ͳ��뵽�ҵ���λ��
            though.add(found, selected);
        }
        tryRemoveCards(found, selected);
        //���������Ƶ���ʾλ��
        int x = 22;
        for (Card card : though) {
            card.setLocation(x, 577);
            x += 63;
        }
        panel.repaint();
        checkCovered();
    }

    private void tryRemoveCards(int found, Card selected) {
        //�����ʱ��׷��ʱ�򣬲���Ҫɾ����
        if (found == -1) {
            return;
        }
        //��ǰλ�ÿ�ʼ�������Ҫ������3����
        if (found + 3 <= though.size()) {
            //��鵱ǰ�ƺ����������Ƿ�һ��
            Card nextNextCard = though.get(found + 2);
            if (selected.sameAs(nextNextCard)) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //����ɾ��3����
                        Card c1 = though.remove(found);
                        Card c2 = though.remove(found);
                        Card c3 = though.remove(found);
                        //�ӽ�����ɾ�� ����
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
     * ���ȫ�������໥�ڵ���ϵ
     */
    private void checkCovered() {
        //���ÿ���ƣ��Ƿ񱻺������ڵ�������ڵ����� disable״̬��������enable
        for (int i = 0; i < cards.size(); i++) {
            //�ҵ���ǰ��
            Card card1 = cards.get(i);
            //���������Ƿ��ڸ���������
            card1.setEnabled(true);
            for (int j = i + 1; j < cards.size(); j++) {
                Card card2 = cards.get(j);
                //����һ����card2�Ƿ��ڸ�����card1
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
     * �ڷ��ƣ��ڷŵ�û���ƾͻ��Զ�����
     *
     * @param x     ���Ͻǵ�����x  x:33
     * @param y     ���Ͻǵ�����y  y:100
     * @param start ��ʼλ�ã�0  42  42+30
     * @param rows  �ڷ�����  6
     * @param cols  �ڷ�����  7
     */
    private void deal(int x, int y, int start, int rows, int cols) {
        //              ѭ�����̶����� ���һ��п���ʹ�õ���
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
