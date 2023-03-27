package FileReceive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.Socket;
import java.text.DecimalFormat;

/**
 * @author 86176
 */
public class GroupFileView extends JFrame {
    private final DecimalFormat df = new DecimalFormat("0.00");
    private final int width = 400;
    private final int height = 600;

    private JButton uploadButton;
    private JLabel flushLabel;
    private JPanel staffPanel;      //在JSpanel上的panel

    private Socket clientSocket;
    private PrintStream clientOut;
    private BufferedReader clientIn;
    private final String ip = "127.0.0.1";

    private File currentUploadFile;
    private String downloadSavePath;
    private int Y = 0;


    public GroupFileView() {
        //1-初始化/
        initVariable();
        //2-连接服务器
        connectServer();
        //3-注册监听
        registerListener();
        //4-初始化窗口设置
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setTitle("群文件");
        this.setLocationRelativeTo(null);//窗口居中显示
        this.setResizable(false);
        this.setVisible(true);
    }


    private void initVariable() {
        JScrollPane jScrollPane = new JScrollPane();
        this.getContentPane().add(jScrollPane);

        staffPanel = new JPanel();
        staffPanel.setLayout(null);
        staffPanel.setOpaque(false);
        staffPanel.setPreferredSize(new Dimension(width, height));

        jScrollPane.setViewportView(staffPanel);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//设置水平滚动条隐藏
        jScrollPane.getViewport().setOpaque(false);  //设置透明
        jScrollPane.setOpaque(false);  //设置透明

        renderTop();
    }


    /**
     * 向服务器重新读取群文件列表
     */
    private void loadGroupFile() {
        clientOut.println("@action=loadFileList");
    }


    /**
     * 渲染顶部面板
     */
    private void renderTop() {
        staffPanel.removeAll();
        Y = 0;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 3, 12));
        JLabel groupLabel = new JLabel("\t\t\t\t\t群文件列表 ");
        this.uploadButton = new JButton("上传文件 ");
        flushLabel = new JLabel(new ImageIcon("E:\\Pictures\\客户端\\刷新图标.png"));
        panel.add(groupLabel);
        panel.add(uploadButton);
        panel.add(flushLabel);

        panel.setBounds(1, Y, width, 30);
        this.staffPanel.add(panel);
        Y += 30;
    }

    /**
     * 渲染文件列表
     */
    public void addToFileList(String filename) {
        String fileIconPath = "E:\\Pictures\\客户端\\文件夹图标.png";
        JLabel fileIcon = new JLabel(new ImageIcon(fileIconPath));
        JButton downloadBtn = new JButton("下载");
        JLabel fileNameLab = new JLabel(filename);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 0, 0));
        panel.add(fileIcon);
        panel.add(fileNameLab);
        panel.add(downloadBtn);

        panel.setBounds(2, Y, width, 30);
        this.staffPanel.add(panel);
        Y += 30;

        panel.addMouseListener(new MouseAdapter() {
            //鼠标移入时
            @Override
            public void mouseEntered(MouseEvent e) { // 鼠标移动到这里的事件
                panel.setBackground(Color.orange);
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 让鼠标移动到
            }

            @Override
            public void mouseExited(MouseEvent e) { // 鼠标离开的事件
                panel.setBackground(Color.white);
            }

        });

        //文件下载
        downloadBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //1-选择下载保存的位置
                JFileChooser f = new JFileChooser(); // 查找文件
                f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                f.showOpenDialog(null);
                File file = f.getSelectedFile();

                if (file != null) {
                    downloadSavePath = file.getPath();
                    //向服务器请求下载
                    clientOut.println("@action=Download[" + filename + ":null:null]");
                }
            }
        });
    }

    /**
     * 注册监听
     */
    private void registerListener() {
        //上传文件    消息格式: @action=Upload["fileName":"fileSize":result]
        this.uploadButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser f = new JFileChooser(); // 查找文件
                f.showOpenDialog(null);
                currentUploadFile = f.getSelectedFile();
                if (currentUploadFile != null) {
                    clientOut.println("@action=Upload[" + currentUploadFile.getName() + ":" + currentUploadFile.length() + ":null]");
                }

            }
        });

        //刷新文件列表按钮
        flushLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadGroupFile();
            }

            //鼠标移入时
            @Override
            public void mouseEntered(MouseEvent e) { // 鼠标移动到这里的事件
                flushLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 让鼠标移动到
            }
        });
    }

    /**
     * 连接服务器
     */
    private void connectServer() {
        //连接服务器
        try {
            //初始化
            try {
                int port = 5203;
                clientSocket = new Socket(ip, port);
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientOut = new PrintStream(clientSocket.getOutputStream(), true);
            clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //读取文件列表
            clientOut.println("@action=loadFileList");

            //开启线程监听服务器消息
            new ClientThread().start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 监听服务器消息
     */
    class ClientThread extends Thread {
        @Override
        public void run() {
            try {
                String fromServerData;
                int flag = 0;

                while ((fromServerData = clientIn.readLine()) != null) {
                    //读取群文件列表
                    if (flag++ == 0) {
                        if (fromServerData.startsWith("@action=GroupFileList")) {
                            String[] fileList = ParseDataUtil.getFileList(fromServerData);
                            for (String filename : fileList) {
                                addToFileList(filename);
                            }
                        }
                        continue;
                    }
                    if (fromServerData.startsWith("@action=GroupFileList")) {
                        //重新渲染顶部面板
                        renderTop();

                        //注册监听
                        registerListener();

                        //渲染文件面板
                        String[] fileList = ParseDataUtil.getFileList(fromServerData);
                        for (String filename : fileList) {
                            addToFileList(filename);
                        }
                    }

                    //文件上传
                    if (fromServerData.startsWith("@action=Upload")) {
                        String res = ParseDataUtil.getUploadResult(fromServerData);
                        switch (res) {
                            case "NO":
                                JOptionPane.showMessageDialog(null, "文件已存在!");
                                break;
                            case "YES":
                                //开始上传
                                if (currentUploadFile != null) {
                                    //开启新线程传输文件
                                    new HandelFileThread(1).start();
                                }

                                break;
                            case "上传完成":
                                JOptionPane.showMessageDialog(null, res);
                                loadGroupFile();
                                break;
                            default:
                        }
                    }

                    //文件下载
                    if (fromServerData.startsWith("@action=Download")) {
                        String res = ParseDataUtil.getDownResult(fromServerData);
                        if ("文件不存在".equals(res)) {
                            JOptionPane.showMessageDialog(null, "该文件不存在404");
                        } else {
                            String downFileName = ParseDataUtil.getDownFileName(fromServerData);
                            String downFileSize = ParseDataUtil.getDownFileSize(fromServerData);
                            //开启新线程传输文件
                            new HandelFileThread(0, downFileName, downFileSize).start();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * ----------------------------------------------------------------------------------
         * 文件传输线程
         */
        class HandelFileThread extends Thread {
            private final int mode;  //文件传输模式  1-上传  2-下载
            private String filename;
            private Long fileSize;

            public HandelFileThread(int mode) {
                this.mode = mode;
            }

            public HandelFileThread(int mode, String filename, String fileSize) {
                this.mode = mode;
                this.filename = filename;
                this.fileSize = Long.parseLong(fileSize);
            }

            @Override
            public void run() {
                try {
                    //上传文件模式
                    if (this.mode == 1) {
                        Socket socket = new Socket(ip, 8888);
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(currentUploadFile));
                        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

                        int len;
                        int i = 0;
                        double sum = 0;
                        byte[] arr = new byte[10240];
                        String schedule;

                        System.out.println("开始上传--文件大小为：" + currentUploadFile.length());

                        while ((len = bis.read(arr)) != -1) {
                            bos.write(arr, 0, len);
                            bos.flush();
                            sum += len;
                            if (i++ % 100 == 0) {
                                schedule = "上传进度: " + df.format(100 * sum / currentUploadFile.length())+"%";
                                System.out.println(schedule);
                            }
                        }
                        //上传完成
                        socket.shutdownOutput();
                        System.out.println("上传进度: 100.00%");
                        //重新渲染顶部面板
                        renderTop();
                        //渲染文件面板

                        addToFileList(filename);

                    }

                    //下载文件模式
                    if (this.mode == 0) {
                        Socket socket = new Socket(ip, 8888);
                        BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
                        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadSavePath + "/" + filename));

                        int len;
                        byte[] arr = new byte[8192];
                        double sumDown = 0;
                        int i = 0;

                        System.out.println("客户端开始下载 ");
                        while ((len = inputStream.read(arr)) != -1) {
                            sumDown += len;
                            if (i++ % 100 == 0) {
                                System.out.println("下载进度为：" +df.format(100 * sumDown / fileSize)+ "%");
                            }

                            outputStream.write(arr, 0, len);
                            outputStream.flush();
                        }
                        System.out.println("下载进度为: 100.00%");
                        outputStream.close();
                        inputStream.close();
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new GroupFileView();
    }
}
