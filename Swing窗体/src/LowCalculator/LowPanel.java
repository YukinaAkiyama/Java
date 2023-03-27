package LowCalculator;

import javax.swing.*;

/**
 * @author 86176
 */
public class LowPanel {
    public final JButton resultButton = new JButton("计算面积");
    public final JTextField lengthText1 = new JTextField(20);
    public final JTextField lengthText2 = new JTextField(20);
    public final JTextField lengthText3 = new JTextField(20);
    public final JTextArea result = new JTextArea();
    public final JButton restartButton = new JButton("清空");


    public LowPanel(){
        JFrame jFrame = new JFrame("海伦公式计算器");
        jFrame.setBounds(600,300,555, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        jFrame.add(panel);
        placeComponents(panel);
        jFrame.setVisible(true);
    }
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel lengthLabel1 = new JLabel("边长 A:");
        lengthLabel1.setBounds(10,20,50,25);
        panel.add(lengthLabel1);

        lengthText1.setBounds(70,20,60,25);
        panel.add(lengthText1);

        JLabel lengthLabel2 = new JLabel("边长 B:");
        lengthLabel2.setBounds(150,20,50,25);
        panel.add(lengthLabel2);

        lengthText2.setBounds(210,20,60,25);
        panel.add(lengthText2);

        JLabel lengthLabel3 = new JLabel("边长 C:");
        lengthLabel3.setBounds(290,20,50,25);
        panel.add(lengthLabel3);

        lengthText3.setBounds(350,20,60,25);
        panel.add(lengthText3);

        resultButton.setBounds(430, 20, 100, 25);
        panel.add(resultButton);

        result.setBounds(10,60,520,100);
        result.setLineWrap(true);
        panel.add(result);

        restartButton.setBounds(250,180,60,25);
        panel.add(restartButton);

    }
}
