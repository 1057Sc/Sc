package ThreadPool;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Sc on 2018/9/11.
 */
public class ThreadSocketClient implements Runnable {

    public static void main(String[] args) {
        ThreadSocketClient threadSocketClient = new ThreadSocketClient();
        threadSocketClient.run();
    }

    public static void ip() throws Exception{
        InetAddress address = InetAddress.getLocalHost();
        address.getHostAddress();//获取Ip地址
        address.getHostName();//获取计算机名
    }

    @Override
    public void run(){
        try{
            //1.创建客户端Socket,指定服务器的ip与端口
            Socket socket = new Socket("localhost",8083);
            //2.获取输入流 向服务器发送信息
            OutputStream outputStream = socket.getOutputStream();//字节输出流
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
