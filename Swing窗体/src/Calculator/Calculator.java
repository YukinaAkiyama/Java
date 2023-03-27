package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author 86176
 */
public class Calculator extends Frame implements ActionListener {
    public boolean calculatorButton = false;   // 判断是否已经按下操作符
    public double result;
    public double first = 0;
    public double second = 0;
    public final JFrame jf = new JFrame();                              //JFrame
    public final JPanel leftPanel = new JPanel(new BorderLayout());     //左侧大面板
    public final JPanel viewPanel1 = new JPanel();                      //左侧显示器面板
    public final JTextField text1 = new JTextField();                   //左显一
    public final JTextField text2 = new JTextField();                   //左显二
    public final JTextField text3 = new JTextField();                   //左显三

    public final JPanel leftButton = new JPanel();                      //左侧按钮面板

    public final JPanel rightPanel= new JPanel(new BorderLayout());     //右侧大面板
    public final JPanel viewPanel2 = new JPanel();                      //右侧显示器面板
    public final JTextField result1 = new JTextField();                 //右显一
    public final JTextArea result2 = new JTextArea();                   //右显二

    public final JPanel rightButton = new JPanel();                     //右侧按钮面板
    public final JSplitPane hSplitPane = new JSplitPane();              //水平方向的分割面板

    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton button6;
    public JButton button7;                 //左侧按钮
    public JButton button8;
    public JButton button9;
    public JButton button0;
    public JButton buttonPositiveNegative;
    public JButton buttonPlus;
    public JButton buttonMinus;
    public JButton buttonMultiply;
    public JButton buttonDivide;            //左侧按钮
    public JButton buttonPoint;
    public JButton buttonEqual;
    public JButton buttonCancel;
    public JButton backSpace;
    public JButton buttonSqrt;

    public JButton buttonSave;
    public JButton buttonView;              //右侧按钮
    public JButton buttonClear;

    Calculator(){
        jf.setTitle("计算器");
        jf.setSize(630, 330);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setRightPanel();     //调用创建左边面板方法
        setLeftPanel();      //调用创建右边面板方法
        setDivider();        //调用创建分割面板方法
        placeholderTag();    //占位标签
        createListener();    //监听器
        this.addWindowListener( new WinClose() );      //注册窗口监听器
    }

    public void setRightPanel(){
        //左侧显示器
        text1.setPreferredSize(new Dimension (150,40));   //左显一
        text1.setHorizontalAlignment(JTextField.CENTER);
        text2.setPreferredSize(new Dimension (40,40));   //左显二
        text2.setHorizontalAlignment(JTextField.CENTER);
        text3.setPreferredSize(new Dimension (150,40));   //左显三
        text3.setHorizontalAlignment(JTextField.CENTER);
        viewPanel1.add(text1);
        viewPanel1.add(text2);
        viewPanel1.add(text3);

        //左侧按钮
        jf.getContentPane().add(leftButton);
        GridLayout gridLayout = new GridLayout(4, 5);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        leftButton.setLayout(gridLayout);
        String[][] names = {
                {"1","2","3","/","C"},
                {"4","5","6","*","退格"},
                {"7","8","9","-","sqrt"},
                {"0","+/-",".","+","="}
        };

        button1 = new JButton(names[0][0]);
        button1.setPreferredSize(new Dimension(0, 50));
        leftButton.add(button1);
        button2 = new JButton(names[0][1]);
        button2.setPreferredSize(new Dimension(0, 50));
        leftButton.add(button2);
        button3 = new JButton(names[0][2]);
        button3.setPreferredSize(new Dimension(0, 50));
        leftButton.add(button3);
        buttonDivide = new JButton(names[0][3]);
        buttonDivide.setPreferredSize(new Dimension(0, 50));
        leftButton.add(buttonDivide);
        buttonCancel = new JButton(names[0][4]);
        buttonCancel.setPreferredSize(new Dimension(0, 50));
        leftButton.add(buttonCancel);

        button4 = new JButton(names[1][0]);
        button4.setPreferredSize(new Dimension(0, 50));
        leftButton.add(button4);
        button5 = new JButton(names[1][1]);
        button5.setPreferredSize(new Dimension(0, 50));
        leftButton.add(button5);
        button6 = new JButton(names[1][2]);
        button6.setPreferredSize(new Dimension(0, 50));
        leftButton.add(button6);
        buttonMultiply = new JButton(names[1][3]);
        buttonMultiply.setPreferredSize(new Dimension(0, 50));
        leftButton.add(buttonMultiply);
        backSpace = new JButton(names[1][4]);
        backSpace.setPreferredSize(new Dimension(0, 50));
        leftButton.add(backSpace);

        button7 = new JButton(names[2][0]);
        button7.setPreferredSize(new Dimension(0, 50));
        leftButton.add(button7);
        button8 = new JButton(names[2][1]);
        button8.setPreferredSize(new Dimension(0, 50));
        leftButton.add(button8);
        button9 = new JButton(names[2][2]);
        button9.setPreferredSize(new Dimension(0, 50));
        leftButton.add(button9);
        buttonMinus = new JButton(names[2][3]);
        buttonMinus.setPreferredSize(new Dimension(0, 50));
        leftButton.add(buttonMinus);
        buttonSqrt = new JButton(names[2][4]);
        buttonSqrt.setPreferredSize(new Dimension(0, 50));
        leftButton.add(buttonSqrt);

        button0 = new JButton(names[3][0]);
        button0.setPreferredSize(new Dimension(0, 50));
        leftButton.add(button0);
        buttonPositiveNegative = new JButton(names[3][1]);
        buttonPositiveNegative.setPreferredSize(new Dimension(0, 50));
        leftButton.add(buttonPositiveNegative);
        buttonPoint = new JButton(names[3][2]);
        buttonPoint.setPreferredSize(new Dimension(0, 50));
        leftButton.add(buttonPoint);
        buttonPlus = new JButton(names[3][3]);
        buttonPlus.setPreferredSize(new Dimension(0, 50));
        leftButton.add(buttonPlus);
        buttonEqual = new JButton(names[3][4]);
        buttonEqual.setPreferredSize(new Dimension(0, 50));
        leftButton.add(buttonEqual);

        //左侧大面板
        leftPanel.add(viewPanel1,BorderLayout.NORTH);
        leftPanel.add(leftButton,BorderLayout.SOUTH);

    }

    public void setLeftPanel(){
        //右侧显示器
        result1.setPreferredSize(new Dimension (200,40));
        result2.setPreferredSize(new Dimension (200,200));
        result2.setLineWrap(true);
        viewPanel2.add(result1,BorderLayout.NORTH);
        viewPanel2.add(result2,BorderLayout.SOUTH);

        //右侧按键
        GridLayout gridLayout2 = new GridLayout();
        gridLayout2.setHgap(10);
        gridLayout2.setVgap(10);
        rightButton.setLayout(gridLayout2);
        buttonSave = new JButton("保存");
        buttonSave.setPreferredSize(new Dimension(0, 50));
        rightButton.add(buttonSave);
        buttonView = new JButton("查看");
        buttonView.setPreferredSize(new Dimension(0, 50));
        rightButton.add(buttonView);
        buttonClear = new JButton("清除");
        buttonClear.setPreferredSize(new Dimension(0, 50));
        rightButton.add(buttonClear);

        //右侧大面板
        rightPanel.add(viewPanel2,BorderLayout.NORTH);
        rightPanel.add(rightButton,BorderLayout.SOUTH);
    }

    public void setDivider(){
        //左右分割面板
        hSplitPane.setLeftComponent(leftPanel);// 在面板左侧添加左侧大面板
        hSplitPane.setRightComponent(rightPanel);// 在面板右侧添加右侧大面板
        hSplitPane.setDividerLocation(380);
        hSplitPane.setDividerSize(5);//分割条大小
        jf.getContentPane().add(hSplitPane);
        jf.setVisible(true);
    }

    public void createListener(){    //注册监听器
        //数字
        button1.addActionListener( this );
        button2.addActionListener( this );
        button3.addActionListener( this );
        button4.addActionListener( this );
        button5.addActionListener( this );
        button6.addActionListener( this );
        button7.addActionListener( this );
        button8.addActionListener( this );
        button9.addActionListener( this );
        button0.addActionListener( this );
        buttonPoint.addActionListener( this );
        //运算符
        buttonPlus.addActionListener( this );
        buttonMinus.addActionListener( this );
        buttonMultiply.addActionListener( this );
        buttonDivide.addActionListener( this );
        buttonSqrt.addActionListener( this );
        buttonEqual.addActionListener( this );
        buttonPositiveNegative.addActionListener( this );
        //清除退格
        backSpace.addActionListener(this);
        buttonCancel.addActionListener( this );
        //功能键
        buttonView.addActionListener(this);
        buttonSave.addActionListener(this);
        buttonClear.addActionListener(this);
    }


    public void placeholderTag(){
        JLabel leftLabel = new JLabel();   //占位标签左
        leftLabel.setPreferredSize(new Dimension(5,0));
        jf.getContentPane().add(leftLabel,BorderLayout.WEST);
        JLabel rightLabel = new JLabel();   //占位标签右
        rightLabel.setPreferredSize(new Dimension(5,0));
        jf.getContentPane().add(rightLabel,BorderLayout.EAST);
    }


    @Override
    public void actionPerformed(ActionEvent e) {}
}

