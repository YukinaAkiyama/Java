package FileReceive;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * @author 86176
 */
public class FileServer {
    private ServerSocket fileServerSocket;  // 文件传输服务器套接字

    private final String path ="E:\\Pictures\\服务器";

    public FileServer() {
        try {
            //1-初始化
            int port = 5203;
            //普通消息传输服务器套接字
            ServerSocket msgServer = new ServerSocket(port);   // 创建消息传输服务器
            fileServerSocket = new ServerSocket(8888);  //创建文件传输服务器


            //2-每次接收一个客户端请求连接时都启用一个线程处理
            while(true) {
                Socket clientSocket
                        = msgServer.accept();
                new ServerThread(clientSocket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** -----------------------------------------------------------------------------------------------------
     *
     *   启用一个线程处理客户端的请求
     */
    private class ServerThread extends Thread{
        private BufferedReader serverIn;
        private PrintWriter serverOut;

        public ServerThread(Socket clientSocket) {
            try {
                //初始化
                try {
                    serverIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                serverOut = new PrintWriter(clientSocket.getOutputStream(),true);


            } catch (IOException ignored) {
            }
        }

        @Override
        public void run() {
            try {
                String uploadFileName;
                String uploadFileSize;
                String fromClientData;

                while((fromClientData = serverIn.readLine()) != null){
                    //把服务器文件列表返回
                    if(fromClientData.startsWith("@action=loadFileList")){
                        File dir = new File(path);
                        if (dir.isDirectory()){
                            String[] list = dir.list();
                            StringBuilder fileList = new StringBuilder("@action=GroupFileList[");
                            for (int i = 0; i < Objects.requireNonNull(list).length; i++) {
                                if (i == list.length-1){
                                    fileList.append(list[i]).append("]");
                                }else {
                                    fileList.append(list[i]).append(":");
                                }
                            }
                            serverOut.println(fileList);
                        }
                    }

                    //请求上传文件
                    if (fromClientData.startsWith("@action=Upload")){
                        uploadFileName = ParseDataUtil.getUploadFileName(fromClientData);
                        uploadFileSize = ParseDataUtil.getUploadFileSize(fromClientData);
                        File file = new File(path,uploadFileName);
                        //文件是否已存在
                        if (file.exists()){
                            //文件已经存在无需上传
                            serverOut.println("@action=Upload[null:null:NO]");
                        }else {
                            //通知客户端开可以上传文件
                            serverOut.println("@action=Upload["+uploadFileName+":"+uploadFileSize+":YES]");
                            //开启新线程上传文件
                            new HandleFileThread(1,uploadFileName,uploadFileSize).start();
                        }
                    }

                    //请求下载文件
                    if(fromClientData.startsWith("@action=Download")){
                        String fileName = ParseDataUtil.getDownFileName(fromClientData);
                        File file = new File(path,fileName);
                        if(!file.exists()){
                            serverOut.println("@action=Download[null:null:文件不存在]");
                        }else {
                            //通知客户端开可以下载文件
                            serverOut.println("@action=Download["+file.getName()+":"+file.length()+":OK]");
                            //开启新线程处理下载文件
                            new HandleFileThread(0,file.getName(),file.length()+"").start();

                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         *     文件传输线程
         */
        class HandleFileThread extends Thread{
            private final String filename;
            private final int mode;  //文件传输模式

            public HandleFileThread(int mode,String name,String size){
                filename = name;
                this.mode = mode;
            }

            @Override
            public void run() {
                try {
                    Socket socket = fileServerSocket.accept();
                    //上传文件模式
                    if(mode == 1){
                        //开始接收上传
                        BufferedInputStream fileIn = new BufferedInputStream(socket.getInputStream());
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(path,filename)));

                        int len;
                        byte[] arr = new byte[8192];

                        while ((len = fileIn.read(arr)) != -1){
                            bos.write(arr,0,len);
                            bos.flush();
                        }
                        serverOut.println("@action=Upload[null:null:上传完成]");
                        serverOut.println("\n");
                        bos.close();
                    }

                    //下载文件模式
                    if(mode == 0){
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(path,filename)));
                        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

                        System.out.println("服务器：开始下载");
                        int len;
                        byte[] arr =new byte[10240];
                        while((len = bis.read(arr)) != -1){
                            bos.write(arr,0,len);
                            bos.flush();
                        }

                        socket.shutdownOutput();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 启动程序
     */
    public static void main(String[] args) {
        new FileServer();
    }
}

