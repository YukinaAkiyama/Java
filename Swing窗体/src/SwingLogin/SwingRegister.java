package SwingLogin;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginRegister extends JFrame{

    LoginRegister() {
    }
    public void init() {
        JFrame frame = new JFrame("注册界面");
        frame.setLayout(null);

        JLabel nameStr = new JLabel("账号:");
        nameStr.setBounds(150, 100, 100, 25);
        frame.add(nameStr);

        JTextField userID = new JTextField();
        JLabel tips = new JLabel();
        userID.setBounds(200, 100, 150, 25);
        tips.setText("最长14个英文或7个汉字");
        frame.add(userID);
        frame.add(tips);

        JLabel phoneNumberStr = new JLabel("手机号:");
        phoneNumberStr.setBounds(150, 150, 100, 25);
        frame.add(phoneNumberStr);

        JTextField phoneNumber = new JTextField();
        phoneNumber.setBounds(200, 150, 300, 25);
        frame.add(phoneNumber);

        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setBounds(150, 200, 100, 25);
        frame.add(passwordStr);

        JPasswordField password = new JPasswordField();
        password.setBounds(200, 200, 300, 25);
        frame.add(password);

        JButton buttonRegister = new JButton("注册");
        buttonRegister.setBounds(250, 250, 70, 25);
        frame.add(buttonRegister);

        frame.setBounds(50, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String []args) {
        LoginRegister loginRegister = new LoginRegister();
        loginRegister.init();
    }
}


