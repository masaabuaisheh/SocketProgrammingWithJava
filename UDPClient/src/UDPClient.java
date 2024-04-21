import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
    	
    	while(true){
    	BufferedReader datauser = new 
    			BufferedReader(new
    					InputStreamReader(System.in));
    	DatagramSocket clientsocket = new DatagramSocket( );
    	
    	InetAddress ipaddress = InetAddress.getByName("192.168.1.18"); 
    	byte[] send = new byte[1024];
    	byte[] receive = new byte[1024];
    	
    	String sent=datauser.readLine();
    	send =sent.getBytes();
    	
    	DatagramPacket sendpacket=new 
    			DatagramPacket(send,send.length,ipaddress,7851); 
    	clientsocket.send(sendpacket);
    	
    	DatagramPacket receivepacket=new 
    			DatagramPacket(receive,receive.length);
    	clientsocket.receive(receivepacket);
    	
    	String modifiedSentence = new String (receivepacket.getData());
    	System.out.println("FROM SERVER:" + modifiedSentence);
    	clientsocket.close();
    	
       }
    	
    }
}