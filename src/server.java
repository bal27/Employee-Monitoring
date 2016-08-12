
import java.net.*;
import java.io.*;

public class server implements Runnable {

    ServerSocket sersock;

    public void run() {
        try {

            sersock = new ServerSocket(9000);

            while (true) {
                Socket sock = sersock.accept();
                clienthandler obj3 = new clienthandler(sock);
                Thread t = new Thread(obj3);
                t.start();

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    /////////////////////////inner class//////////////////

    class clienthandler implements Runnable {

        DataInputStream dis;
        DataOutputStream dos;
        Socket sock;

        public clienthandler(Socket sock) {

            this.sock = sock;

        }

        public void run() {
            try {

                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());
dos.writeBytes("Hello client\r\n");
                String s = dis.readLine();
                
                System.out.println(s);
                
                
                while(true)
                {
                    String s1=dis.readLine();
                    
                }
                

            } catch (Exception e) {
                e.printStackTrace();

            }

        }
    }
    //////////////////////////////////////////

    
}
