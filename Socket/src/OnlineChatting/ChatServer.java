package OnlineChatting;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
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
public class ChatServer implements ActionListener, Runnable {

    JTextField msgTextField;
    JTextArea showTextArea;
    JFrame mainFrame;
    JButton sentButton;
    JScrollPane scrollPane;
    JPanel panel;// 嵌板
    Container container;// 容器

    Thread thread = null;
    ServerSocket serverSocket;
    Socket connectToClientSocket;
    DataInputStream inFromClient;
    DataOutputStream outToClient;

    public ChatServer() {
        // 设置界面，包含容器
        mainFrame = new JFrame("聊天室——服务器端");
        container = mainFrame.getContentPane();
        // 聊天信息展示框
        showTextArea = new JTextArea();
        showTextArea.setEditable(false); // 不可编辑
        showTextArea.setLineWrap(true); // 自动换行
        scrollPane = new JScrollPane(showTextArea);
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
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(panel, BorderLayout.SOUTH);
        // 主界面，要定义在后面
        mainFrame.setSize(500, 400);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            // 创建服务器套接字
            serverSocket = new ServerSocket(8888,5);
            showTextArea.append("正在等待对话请求...\n" + getTime() + "\n");
            // 监听客户端的连接
            connectToClientSocket = serverSocket.accept();
            inFromClient = new DataInputStream(connectToClientSocket
                    .getInputStream());
            outToClient = new DataOutputStream(connectToClientSocket
                    .getOutputStream());
            // 启动线程在后台来接收对方的消息
            thread = new Thread(this);
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
            /*
              public final static int MIN_PRIORITY = 1; public final static int
              NORM_PRIORITY = 5; public final static int MAX_PRIORITY = 10;
              setPriority的参数在1 - 10 之间就可以, 否则会抛异常.
              setPriority不一定起作用的，在不同的操作系统不同的jvm上，效果也可能不同。
              现在很多jvm的线程的实现都使用的操作系统线程，设置优先级也是使用的操作系统优先级，
              java层面有10个优先级别，假设操作系统只有3个优先级别， 那么jvm可能将1-4级映射到操作系统的1级，
              5-7级映射到操作系统的2级， 剩下的映射到3级，这样的话，在java层面，将优先级设置为5,6,7，其实本质就是一样的了。
             */

        } catch (IOException e) {
            showTextArea.append("对不起，不能创建服务器\n" + getTime() + "");
            msgTextField.setEditable(false); // 不可编辑
            msgTextField.setEnabled(false); // 不可见
        }

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ChatServer();
    }

    /**
     * 响应按钮事件，发送消息给对方
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String string = msgTextField.getText();
        if (string.length() > 0) {
            try {
                outToClient.writeUTF(string);
                outToClient.flush();
                showTextArea.append("服务器端：  " + string + "\n" + getTime() + "\n");
                msgTextField.setText(null);
            } catch (IOException e1) {
                showTextArea.append("你的消息：  " + string + "未能发送出去\n" + getTime()
                        + "\n");
            }
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                showTextArea.append("AkiyamaYukina：  " + inFromClient.readUTF() + "\n"
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


