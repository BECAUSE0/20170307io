package com.hand.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class downPdf {
	public static void downLoad(String urlStr,String fileName) throws IOException{
		URL url=new URL(urlStr);
		int count;
		FileOutputStream filestr=new FileOutputStream(fileName);
		URLConnection connect=url.openConnection();
		DataInputStream in=new DataInputStream(connect.getInputStream());
		DataOutputStream out= new DataOutputStream(filestr);
		byte[] buff = new byte[1024];
		while ((count = in.read(buff)) > 0)
			out.write(buff,0,count);
		out.close();
		in.close();
	 }
	
	public static void main( String[] args ){
		try {
			downLoad("http://www.madore.org/~david/math/padics.pdf","abc.pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
