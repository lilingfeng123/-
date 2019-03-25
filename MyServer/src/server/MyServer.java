package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
public class MyServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss=null;
		Socket s=null;
		try {
			ss=new ServerSocket(8888);
			while(true) {
				s=ss.accept();
				new Thread(new MyRun(s)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
