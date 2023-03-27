package OnlineChatting;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * @author 86176
 */
public class ChatClient implements ActionListener, Runnable {

    JTextField msgTextField;
    JTextArea showTextArea;
    JFrame jFrame;
    JButton sentButton;
    JScrollPane jScrollPane;
    JPanel panel;// 嵌板
    Container container;// 容器

    Thread thread = null;
    Socket connectToClientSocket;
    DataInputStream inFromClient;
    DataOutputStream outToClient;

    public ChatClient() {
        // 设置界面，包含容器
        jFrame = new JFrame("聊天室——客户端");
        container = jFrame.getContentPane();
        // 聊天信息展示框
        showTextArea = new JTextArea();
        showTextArea.setEditable(false); // 不可编辑
        showTextArea.setLineWrap(true); // 自动换行
        jScrollPane = new JScrollPane(showTextArea);
        // 聊天信息输入框
        msgTextField = new JTextField();
        msgTextField.setColumns(30); // 输入框长度
        msgTextField.addActionListener(this);/**/// ?
        // 发送按键
        sentButton = new JButton("发送");
        sentButton.addActionListener(this);/**/
        // 嵌板有聊天信息输入框和发送按键
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(msgTextField);
        panel.add(sentButton);
        // 容器包含聊天信息展示框和嵌板
        container.add(jScrollPane, BorderLayout.CENTER);
        container.add(panel, BorderLayout.SOUTH);
        // 主界面，要定义在后面
        jFrame.setSize(500, 400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            // 创建套接字连接到服务器
            connectToClientSocket = new Socket("localhost", 8888);
            inFromClient = new DataInputStream(connectToClientSocket
                    .getInputStream());
            outToClient = new DataOutputStream(connectToClientSocket
                    .getOutputStream());
            showTextArea.append("连接成功，请说话...\n" + getTime() + "\n");

            // 创建线程在后台来接收对方的消息
            thread = new Thread(this);
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();

        } catch (IOException e) {
            showTextArea.append("对不起，没能连接到服务器\n" + getTime() + "\n");
            msgTextField.setEditable(false); // 不可编辑
            msgTextField.setEnabled(false); // 不可见
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ChatClient();
    }
    /**
     *    响应按钮事件，发送消息给对方
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String string = msgTextField.getText();
        if (string.length() > 0) {
            try {
                outToClient.writeUTF(string);
                outToClient.flush();
                showTextArea.append("AkiyamaYukina：  " + string + "\n" + getTime() + "\n");
                msgTextField.setText(null);
            } catch (IOException e1) {
                showTextArea.append("你的消息  “" + string + "”未能发送出去\n" + getTime()
                        + "\n");
            }
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                showTextArea.append("服务器端：  " + inFromClient.readUTF() + "\n"
                        + getTime() + "\n");
                Thread.sleep(1000);
            }
        } catch (IOException ignored) {
        } catch (InterruptedException e) {
            thread.start();
        }
    }

    /**
     * Java代码中获得当前时间
     *
     * @return 当前时期时间
     */
    private String getTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}



