package WebQQ;

import java.awt.TextArea;
import java.io.DataInputStream;
import java.io.IOException;

public class ReadThread extends Thread{
    private DataInputStream dis;
    private TextArea displayarea;
    public ReadThread(DataInputStream dis, TextArea m){
        this.dis = dis;
        displayarea = m;
    }
    public void run(){
        while(!isInterrupted()){
            try {
                String str = dis.readUTF();
                displayarea.append(str + "\n");
                System.out.println("我在监控数据");
            } catch (IOException e) {}
        }
    }
}
