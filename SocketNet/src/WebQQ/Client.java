package WebQQ;

import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
 
public class Client {
    public static void main(String[] args) throws IOException{
		@SuppressWarnings("resource")
		Socket socket = new Socket("localhost", 5432);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        final DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Frame myframe = new Frame("Socket聊天室 power by 假装坏 冰语 公子小白");
        Panel panelx = new Panel();
        final TextField input = new TextField(35);
        TextArea display = new TextArea(19, 35);
        panelx.add(display);
        panelx.add(input);
        myframe.add(panelx);
        new receiveThread(dis, display);    //创建启动接收消息的线程
        input.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dos.writeUTF(input.getText());    //发送数据
                    input.setText("");  //清空输入框内容
                } catch (IOException e2) {    }
            }
        });
         
        myframe.setSize(350, 400);
        myframe.setVisible(true);
    }
}
 
//接收消息线程循环读取网络消息，显示在文本域
class receiveThread extends Thread{
    DataInputStream dis;
    TextArea displayarea;
    public receiveThread(DataInputStream dis, TextArea m){
        this.dis = dis;
        displayarea = m;
        this.start();
    }
    public void run(){
        for(;;){
            try {
                String str = dis.readUTF();   //读来自服务器的消息
                displayarea.append(str + "\n");   //将消息添加到文本域显示
            } catch (IOException e) {}
        }
    }
}
