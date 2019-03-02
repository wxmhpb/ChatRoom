package Singleton;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketService {
    public static void main(String[] args)throws Exception {
        //建立基站，端口号为6666
        ServerSocket serverSocket=new ServerSocket(6666);
        try{
            System.out.println("等待客户端连接");
            //等待客户端连接，有客户端连接则返回客户端的Socket对象，否则一直阻塞在此处
            Socket client=serverSocket.accept();
            System.out.println("有客户端连接，端口号为："+client.getPort());
            //获取客户端的输入输出流
            Scanner clientInput=new Scanner(client.getInputStream());
            clientInput.useDelimiter("\n");
            PrintStream clientOutput=new PrintStream(client.getOutputStream(),true,"UTF-8");
            //读取客户端输入
            if(clientInput.hasNext()){
                System.out.println(client.getInetAddress()+"说："+clientInput.next());
            }
            //向客户端输出
            clientOutput.println("hello i am server");
            //关闭输入输出流，关闭基站
            clientInput.close();
            clientOutput.close();
            serverSocket.close();
        }catch(IOException e){
            System.out.println("服务器端出现异常"+e);
        }
    }
}
