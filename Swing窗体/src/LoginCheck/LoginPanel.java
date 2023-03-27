package LoginCheck;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * @author 86176
 */
public class LoginPanel extends JFrame{
    private final JButton loginButton = new JButton("登录");
    private final JButton restartButton = new JButton("清除");
    private final JTextField userText = new JTextField(20);
    private final JPasswordField passwordText = new JPasswordField(20);

    public LoginPanel(){
        JFrame frame = new JFrame("Login Example");
        frame.setBounds(600,300,350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();    
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel userLabel = new JLabel("用户名:");

        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        loginButton.setBounds(90, 80, 80, 25);
        panel.add(loginButton);
        
        restartButton.setBounds(200, 80, 80, 25);
        panel.add(restartButton);
        listener();	
    }
    
    public void listener(){
    	loginButton.addActionListener(
                e -> {
                    String username = userText.getText();
                    String password = String.valueOf(passwordText.getPassword());
                    if (null == username
                        || username.trim().length() == 0
                        || password.trim().length() == 0) {
                        JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
                    }else if("mrs".equals(username)&& "microsoft".equals(password)){		//核验用户名密码
                        JOptionPane.showMessageDialog(null, "登陆成功");
                    }else{
                        JOptionPane.showMessageDialog(null, "登陆失败，用户名或密码错误");
                    }
                });
    	restartButton.addActionListener(
                e -> {
                    userText.setText("");
                    passwordText.setText("");
                });
    }
}
