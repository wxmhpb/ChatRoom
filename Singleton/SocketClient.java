package Singleton;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketClient {
    public static void main(String[] args) throws Exception{
        String serverName="127.0.0.1";
        Integer port=6666;
        try{
            //创建客户端Socket连接服务器
            Socket client=new Socket(serverName,port);
            System.out.println("连上服务器，服务器地址为："+client.getInetAddress());
            //获取输入输出流
            PrintStream clientOutput=new PrintStream(client.getOutputStream(),true,"UTF-8");
            Scanner clientInput=new Scanner(client.getInputStream());
            clientInput.useDelimiter("\n");
            //向服务器输出内容

            clientOutput.println("i am a client");
            if(clientInput.hasNext()){
                System.out.println("服务器发送消息为："+clientInput.next());
            }
            //关闭输入输出流，关闭客户端
            clientInput.close();
            clientOutput.close();
            client.close();
        }catch(IOException e){
         System.out.println("客户端通信出现异常"+e);
        }
    }
}
