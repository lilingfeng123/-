package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.Socket;

public class MyRun implements Runnable{
	Socket s=new Socket();
	public MyRun(Socket s) {
		this.s=s;
	}
	public void run() {
		try {
			myrun();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void myrun() throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String path=br.readLine();
		String[] cm=path.split("/");
		String classname=cm[1];
		String[] cm1=cm[2].split(" ");
		String methodname=cm1[0];
		Method method=Class.forName("server."+classname).getMethod(methodname, null);
		Object obj=Class.forName("server."+classname);
		method.invoke(Class.forName("server."+classname).newInstance(),null);
	}
}
