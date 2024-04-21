import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPServer {
	public static void main(String[] args) throws IOException {
	
		String value="null";
		int i=0;
		
		DatagramSocket serverSocket=new DatagramSocket(7851); 
		byte[]receiveData=new byte[1024];
		byte[]sendData=new byte[1024];
		
		while(true) {
			DatagramPacket receivePacket=new 
					DatagramPacket(receiveData,receiveData.length);
			
			serverSocket.receive(receivePacket);
			String sen=new
					String(receivePacket.getData());
			
			InetAddress ipaddress = receivePacket.getAddress();
			
			int port =receivePacket.getPort();
			String S=null;
			  File file=new File("Data.txt");
			  final RandomAccessFile R;
			  R=new RandomAccessFile(new File("Data.txt"), "r");
			  
			  String array[]=new String[2];
			  FileReader F;
			  F = new FileReader(file);
			  BufferedReader reader = new
					  BufferedReader(F);
			  
			  while((S = reader.readLine())!=null){
	              
	              String k=S;
	              array =k.split(",");
	              if(array[0].trim().equals(sen.trim())){
	            	  value=array[1];
	            	  i=1;
	                      break;
	              }
	              else{
	                  i=0;
	              }
			  }
			  if(i == 0) {
				  value = "Vehicle is not found";
			  }
			  else {
				  
			  }
	        
			sendData= value.getBytes();
			DatagramPacket sendPacket=new 
					DatagramPacket(sendData,sendData.length,ipaddress,port);
			serverSocket.send(sendPacket);
			
		}
	}
}


