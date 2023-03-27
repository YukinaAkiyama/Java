package Calculator;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;



/**
 * @author 86176
 */
public class Listener extends Calculator{
    public FileManage fm = new FileManage();
    public java.text.DecimalFormat df =new java.text.DecimalFormat("#.0000");
    public Listener(){
    }

    @Override
    public void actionPerformed(ActionEvent e)       //按钮的单击事件处理方法
    {
        //获取事件源文字
        String buttonName = e.getActionCommand();
        switch (buttonName) {
            case ".", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" -> inputNumber(buttonName);  //在文本框输入number
            case "-", "+", "*", "/", "sqrt" -> inputCalculatingSigns(buttonName);  //在文本框输入运算符
            case "+/-" -> changePositiveNegative(buttonName);   //改变number的正负号
            case "C", "退格" -> clearText(buttonName);    //退格和清除
            case "=" -> calculate();   //计算
            case "保存" -> {      //文件保存
                String saveData = result2.getText();
                fm.saveFile(saveData);
            }
            case "查看" -> result2.setText(fm.showFile());    //文件查看
            case "清除" -> {      //文件清除
                result2.setText("");
                fm.clearFile();
            }
            default -> throw new IllegalStateException("Unexpected value: " + buttonName);
        }
    }


    public void inputNumber(String num) {
        // 输入第二遍数字时，格式化所有
        String num1 = (text1.getText());
        String calculatingSigns = (text2.getText());
        String num2 = (text3.getText());
        String result1Text = (result1.getText());
        if (!Objects.equals(num1, "") && !Objects.equals(calculatingSigns, "") && !Objects.equals(num2, "") && !Objects.equals(result1Text, "")) {
            text1.setText("");
            text2.setText("");
            text3.setText("");
            result1.setText("");
            calculatorButton = false;
            first = 0;
            second = 0;
        }
        if (!calculatorButton) {
            text1.setText(text1.getText() + num);

        } else {
            text3.setText(text3.getText() + num);
        }

    }

    public void inputCalculatingSigns(String sign) {
        text2.setText(sign);
        calculatorButton = true;
    }

    public void changePositiveNegative(String number){
        if ("+/-".equals(number)) {
            String a = "+";
            String b = "-";
            if (!calculatorButton) {    // 在没有按下符号键的情况
                if (first == 0) {
                    String f1 = (text1.getText());
                    text1.setText(a + f1);
                } else {
                    if (first % 2 == 0) {   // 偶数
                        String f2 = (text1.getText());
                        String f21 = f2.substring(1);
                        text1.setText(b + f21);
                    } else {
                        String f3 = (text1.getText());
                        String f31 = f3.substring(1);
                        text1.setText(a + f31);
                    }
                }
                first++;
            } else {
                if (second == 0) {
                    String f1 = (text3.getText());
                    text3.setText(a + f1);
                } else {
                    if (second % 2 == 0) {  // 偶数
                        String f2 = (text3.getText());
                        String f21 = f2.substring(1);
                        text3.setText(b + f21);
                    } else {
                        String f3 = (text3.getText());
                        String f31 = f3.substring(1);
                        text3.setText(a + f31);
                    }
                }
                second++;
            }
        }
    }

    public void clearText(String button) {
        if (Objects.equals(button, "退格")) {
            if (!calculatorButton) {
                String str = text1.getText();
                if( str.length() > 0 ) {
                    text1.setText( str.substring( 0,str.length() - 1 ) );
                }
            } else {
                String str = text3.getText();
                if( str.length() > 0 ) {
                    text3.setText( str.substring( 0,str.length() - 1 ) );
                }
            }
        }
        else if (Objects.equals(button, "C")) {
            text1.setText("");
            text2.setText("");
            text3.setText("");
            result1.setText("");
            calculatorButton = false;
            first = 0;
            second = 0;
        }
    }


    public void calculate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        double num1 ;
        double num2 ;

        String calculatingSigns = text2.getText();
        if(Objects.equals(text2.getText(), "")){
            text2.setText("=");
            calculatingSigns = "null";
        }

        switch (calculatingSigns) {
            case "+" -> {
                num1 = Double.parseDouble((text1.getText()));
                num2 = Double.parseDouble((text3.getText()));
                result = num1 + num2;
            }
            case "-" -> {
                num1 = Double.parseDouble((text1.getText()));
                num2 = Double.parseDouble((text3.getText()));
                result = num1 - num2;
            }
            case "*" -> {
                num1 = Double.parseDouble((text1.getText()));
                num2 = Double.parseDouble((text3.getText()));
                result = num1 * num2;
            }
            case "/" -> {
                num1 = Double.parseDouble((text1.getText()));
                num2 = Double.parseDouble((text3.getText()));
                result = num1 / num2;
            }
            case "sqrt" -> {
                num1 = Double.parseDouble((text1.getText()));
                result = Math.sqrt(num1);
            }
            case "null" ->{
                num1 = Double.parseDouble((text1.getText()));
                result = num1;
            }
            default -> throw new IllegalStateException("Unexpected value: " + calculatingSigns);
        }
        result1.setText( " =  "+ df.format(result) );
        result2.append(text1.getText() + " " + text2.getText() + " " + text3.getText() + " = " + df.format(result) + "\n" + formatter.format(calendar.getTime()) + "\r\n");
    }
}

