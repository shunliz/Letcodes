package misctests.socket.socket;

import java.io.IOException;
import java.net.Socket;

public class ConnectIOnHandler implements Runnable {

    private Socket socket;
    public ConnectIOnHandler(Socket socket){
       this.socket = socket;
    }
    public void run(){
      while(!Thread.currentThread().isInterrupted()&&!socket.isClosed()){//��ѭ�������д�¼�
          int someThing = 0;
		try {
			someThing = socket.getInputStream().read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��ȡ����
          if(someThing != 0){
             //......//��������
             try {
				socket.getOutputStream().write(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//....//д����
          }

      }
    }

}
