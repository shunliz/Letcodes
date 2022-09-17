package misctests.socket.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	public static void main(String[] args) throws IOException {
		 ExecutorService executor = Executors.newFixedThreadPool(100);//�̳߳�

		 ServerSocket serverSocket = new ServerSocket(8088);
		 while(!Thread.currentThread().isInterrupted()){//���߳���ѭ���ȴ������ӵ���
			 Socket socket = serverSocket.accept();
			 executor.submit(new ConnectIOnHandler(socket));//Ϊ�µ����Ӵ����µ��߳�
		 }
	}

}
