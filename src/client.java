import java.io.*;
import java.net.*;



public class client implements Runnable {
    
    Socket sock2;
    
   DataInputStream dis;
   DataOutputStream dos;
   
   public void run()
   {
       try
       {
       sock2=new Socket("127.0.0.1",9000);
       
       dis=new DataInputStream(sock2.getInputStream());
       dos=new DataOutputStream(sock2.getOutputStream());
       
       String s=dis.readLine();
       dos.writeBytes("hello server.\r\n");
       System.out.println(s);
       
       while(true)
       {
           String s2=dis.readLine();
           
       }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       
   }
   
   
       
       
       
       
   }
    
    
    
    
    

