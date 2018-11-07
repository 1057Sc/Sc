package threadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Sc on 2018/9/11.
 */
public class ThreadSocketServer implements Runnable{

    @Override
    public void run() {
        try {
            //1.创建一个服务端Socket 即ServerSocket 绑定指定端口
            ServerSocket serverSocket = new ServerSocket(8083);
            //2.调用accept()方法开始监听，等待客户端的链接
            Socket socket = serverSocket.accept();
            //3.获取输入流 读取客户端的消息
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while((info = bufferedReader.readLine())!=null){
                System.out.println("我是服务器:客户端的消息为"+info);
            }
            //关闭输入流
            socket.shutdownInput();
            //4.获取输出流,回复客户端的消息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("我是服务器，你好客户端");
            printWriter.flush();
            //5.关闭资源
            printWriter.close();
            outputStream.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }

    public void first(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(new ThreadSocketServer());
    }
}
