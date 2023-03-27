package zhang;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
/**
 * @author 86176
 */
public class Calculator extends JFrame implements ActionListener{
    private final String[][] KEYS1= {{"1","2","3","÷","C"},{"4","5","6","*","退格"},{"7","8","9","-","sqr"},{"0","+/-",".","+","="}};
    private final String[] KEYS2={"保存","查看","清除"};
    private final JButton[][] b1=new JButton[4][5];
    private final JButton[] b2=new JButton[3];
    private JTextField t1=new JTextField();
    private JTextField t2=new JTextField();
    private JTextField t3=new JTextField();
    private JTextField t4=new JTextField();
    private List t5=new List(8);
    private String s1="";
    private String s2="";
    int key=1;
    DecimalFormat df=new DecimalFormat("0.0");
    public Calculator() {
        super("御用计算器");
        setBounds(550,300,450,250);
        setLayout(new BorderLayout());
        setResizable(false);
        final JPanel P1=new JPanel(new BorderLayout());
        final JPanel P2=new JPanel(new BorderLayout());
        final JPanel P1_1=new JPanel();
        final JPanel P2_1=new JPanel(new BorderLayout());
        final JPanel P2_1_1=new JPanel();
        final JPanel P2_1_2=new JPanel(new BorderLayout());
        this.add(P1,BorderLayout.WEST);
        this.add(P2,BorderLayout.EAST);
        P1.add(P1_1,BorderLayout.NORTH);
        P2.add(P2_1,BorderLayout.NORTH);
        P2_1.add(P2_1_1,BorderLayout.CENTER);
        P2_1.add(P2_1_2,BorderLayout.SOUTH);

        final JPanel BP1=new JPanel();
        final JPanel BP2=new JPanel();
        final GridLayout gl1=new GridLayout(4,5);
        final GridLayout gl2=new GridLayout(1,3);
        gl1.setHgap(10);
        gl1.setVgap(10);
        gl2.setHgap(5);
        BP1.setLayout(gl1);
        BP2.setLayout(gl2);
        P1.add(BP1,BorderLayout.CENTER);
        P2.add(BP2,BorderLayout.CENTER);

        t1.setBorder(BorderFactory.createLineBorder(Color.black,2));
        t2.setBorder(BorderFactory.createLineBorder(Color.black,2));
        t3.setBorder(BorderFactory.createLineBorder(Color.black,2));
        t4.setBorder(BorderFactory.createLineBorder(Color.black,2));
        t5.setBackground(new Color(255,251,240));
        t1.setFont(new Font("楷体", Font.PLAIN, 15));
        t2.setFont(new Font("楷体", Font.PLAIN, 20));
        t3.setFont(new Font("楷体", Font.PLAIN, 15));
        t4.setFont(new Font("楷体", Font.PLAIN, 15));
        t5.setFont(new Font("楷体", Font.PLAIN, 15));
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t1.setPreferredSize(new Dimension (95,30));
        t2.setPreferredSize(new Dimension (35,30));
        t3.setPreferredSize(new Dimension (95,30));
        t4.setPreferredSize(new Dimension (125,30));
        t5.setPreferredSize(new Dimension (125,150));
        P1_1.add(t1);
        P1_1.add(t2);
        P1_1.add(t3);
        P2_1_1.add(t4,BorderLayout.CENTER);
        P2_1_2.add(t5,BorderLayout.CENTER);

        for(int row=0;row<4;row++) {
            for(int col=0;col<5;col++) {
                b1[row][col]=new JButton(KEYS1[row][col]);
                BP1.add(b1[row][col]);
                b1[row][col].addActionListener(this);
                b1[row][col].setBackground(new Color(130,130,130));
                b1[row][col].setBorder(null);
                b1[row][col].setFont(new Font("楷体", Font.PLAIN, 18));
                b1[row][col].setForeground(Color.white);

            }
        }
        for(int row=0;row<3;row++) {
            b2[row]=new JButton(KEYS2[row]);
            BP2.add(b2[row]);
            b2[row].setBackground(new Color(119,136,153));
            b2[row].setBorder(null);
            b2[row].setFont(new Font("楷体", Font.PLAIN, 15));
            b2[row].setForeground(Color.white);
        }

        b1[0][3].setBackground(new Color(232,232,232));
        b1[1][3].setBackground(new Color(232,232,232));
        b1[2][3].setBackground(new Color(232,232,232));
        b1[3][3].setBackground(new Color(232,232,232));
        b1[0][3].setForeground(Color.black);
        b1[1][3].setForeground(Color.black);
        b1[2][3].setForeground(Color.black);
        b1[3][3].setForeground(Color.black);
        b1[0][4].setBackground(new Color(255,165,0));
        b1[1][4].setBackground(new Color(255,165,0));
        b1[2][4].setBackground(new Color(255,165,0));
        b1[3][4].setBackground(new Color(255,165,0));
        for(int row=0;row<3;row++){
            b2[row].addActionListener(this);
        }
        final JLabel leftLabel=new JLabel();
        leftLabel.setPreferredSize(new Dimension(5,0));
        P1.add(leftLabel,BorderLayout.WEST);
        final JLabel rightLabel1=new JLabel();//?????????λ???1
        rightLabel1.setPreferredSize(new Dimension(15,0));//??????????
        P2.add(rightLabel1,BorderLayout.EAST);
        final JLabel rightLabel2=new JLabel();//?????????λ???2
        rightLabel2.setPreferredSize(new Dimension(10,0));//??????????
        P2_1_1.add(rightLabel2,BorderLayout.EAST);
        final JLabel topLabel=new JLabel();//?????????λ???
        rightLabel2.setPreferredSize(new Dimension(10,0));//??????????
        P2_1_1.add(topLabel,BorderLayout.NORTH);
        final JLabel rightLabel3=new JLabel();//?????????λ???3
        rightLabel3.setPreferredSize(new Dimension(15,0));//??????????
        P2_1_2.add(rightLabel3,BorderLayout.EAST);
        setVisible(true);
    }
    //???
    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        switch (label)
        {
            case "+":
            case "-":
            case "*":
            case "÷":
                t2.setText(label);
                key=0;
                break;
            case "=":
                s1=t1.getText();
                s2=t3.getText();
                if(t2.getText().equals("+"))
                {
                    t4.setText("="+ Operation1(s1,s2));
                    t5.add(t1.getText()+t2.getText()+t3.getText()+t4.getText());
                    this.s1="";
                    this.s2="";
                }
                if(t2.getText().equals("-"))
                {
                    t4.setText("="+Operation2(s1,s2));
                    t5.add(t1.getText()+t2.getText()+t3.getText()+t4.getText());
                    this.s1="";
                    this.s2="";
                }
                if(t2.getText().equals("*"))
                {
                    t4.setText("="+Operation3(s1,s2));
                    t5.add(t1.getText()+t2.getText()+t3.getText()+t4.getText());
                    this.s1="";
                    this.s2="";
                }
                if(t2.getText().equals("÷"))
                {
                    t4.setText("="+Operation4(s1,s2));
                    t5.add(t1.getText()+t2.getText()+t3.getText()+t4.getText());
                    this.s1="";
                    this.s2="";
                }
                break;
            case "C":
                this.s1="";
                this.s2="";
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                key=1;
                break;
            case "退格":
                Operation9();
                break;
            case "sqr":
                String n=Operation5(t1.getText());
                t4.setText("="+n);
                t2.setText("sqr");
                break;
            case "+/-":
                String m=Operation6(t1.getText());
                t4.setText("="+m);
                t2.setText("+/-");
                break;
            case "保存":
                try {
                    Operation7("D://JavaExample.txt",t5);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case "查看":
                try {
                    Operation8("D://JavaExample.txt");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case "清除":
                t5.removeAll();
                JOptionPane.showMessageDialog(null,"清除成功！",
                        "nice",JOptionPane.INFORMATION_MESSAGE);//????
                break;
            default:
                if(key==1) {
                    t1.setText(t1.getText()+label);
                } else {
                    t3.setText(t3.getText()+label);
                }
                break;
        }
    }
    //????????
    private String Operation1(String str1,String str2)//???
    {
        String result="";
        double a=Double.parseDouble(str1);
        double b=Double.parseDouble(str2);
        double c=0;
        c=a+b;
        result=String.valueOf(c);//double?????????result
        return result;
    }
    private String Operation2(String str1,String str2)//????
    {
        String result="";
        double a=Double.parseDouble(str1);
        double b=Double.parseDouble(str2);
        double c=0;
        c=a-b;
        result=String.valueOf(c);//double?????????result
        return result;
    }
    private String Operation3(String str1,String str2)//???
    {
        String result="";
        double a=Double.parseDouble(str1);
        double b=Double.parseDouble(str2);
        double c=0;
        c=a*b;
        result=String.valueOf(c);//double?????????result
        return result;
    }
    private String Operation4(String str1,String str2)//????
    {
        String result="";
        double a=Double.parseDouble(str1);
        double b=Double.parseDouble(str2);
        double c=0;
        c=a/b;
        result=String.valueOf(df.format(c));//double?????????result
        return result;
    }
    //????????
    public String Operation5(String str)//????
    {
        String result="";
        double a=Double.parseDouble(str),b=0;
        b=Math.sqrt(a);
        result=String.valueOf(df.format(b));//double?????????result
        t5.add(a+"开平方为"+df.format(b));
        return result;
    }
    public String Operation6(String str)//???
    {
        String result="";
        double a=Double.parseDouble(str),b=0;
        b=a*(-1);
        result=String.valueOf(b);//double?????????result
        t5.add(a+"取反为"+df.format(b));
        return result;
    }
    //?????
    public void Operation7(String path, List list)throws Exception//????
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        String[] strings = list.getItems();
        for (String l:strings){
            bw.write(l + "\n");
        }
        bw.close();
        JOptionPane.showMessageDialog(null,"You have successfully saved!","nice",JOptionPane.INFORMATION_MESSAGE);//????
    }
    public void Operation8(String path)throws Exception//??
    {
        BufferedReader br=new BufferedReader(new FileReader(path));
        String s;
        StringBuffer sb = new StringBuffer();
        while((s=br.readLine()) != null){
            sb.append(s+"\n");
        }
        br.close();
        JOptionPane.showMessageDialog(null,sb,"nice",JOptionPane.INFORMATION_MESSAGE);//????
    }
    @SuppressWarnings("unused")
    public void Operation9()//???
    {
        t4.setText("");//?????????????
        String s1 ="";
        String s2 ="";
        String s3 ="";
        char []xx1 = t1.getText().toCharArray();
        char []yy1 = t2.getText().toCharArray();
        char []zz1 = t3.getText().toCharArray();
        if(!t3.getText().equals(""))
        {
            int sum=zz1.length;
            for(int i=0;i<sum-1;i++)
            {
                s1=s1+String.valueOf(zz1[i]);
            }
            t3.setText(s1);
        }
        else if(!t2.getText().equals(""))
        {
            int sum=yy1.length;
            for(int i=0;i<sum-1;i++)
            {
                s2=s2+String.valueOf(yy1[i]);
            }
            t2.setText(s2);
        }
        else if(!t1.getText().equals(""))
        {
            int sum=xx1.length;
            for(int i=0;i<sum-1;i++)
            {
                s3=s3+String.valueOf(xx1[i]);
            }
            t1.setText(s3);
        }
    }
    //?????
    public static void main(String[] args) {
        Calculator a=new Calculator();
    }
}
