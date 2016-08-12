
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import java.io.*;

import java.net.*;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class client_home extends javax.swing.JFrame implements WindowListener {

    client obj2;
    emp_login em;
    changepswd chp;
    String name;
    boolean flag = true;

    /**
     * Creates new form client_home
     */
    public client_home() {

        initComponents();
        this.addWindowListener(this);

        jp2.setVisible(false);

        bt2.setVisible(false);
        bt3.setVisible(false);
        bt4.setVisible(false);

        setSize(740, 600);
        setTitle("Employee Home");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bt1 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        cp1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cta = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        tf1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jp2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbp = new javax.swing.JLabel();
        btp = new javax.swing.JButton();
        lb2 = new javax.swing.JLabel();
        bt2 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bt1.setBackground(new java.awt.Color(255, 255, 255));
        bt1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bt1.setText("CONNECT");
        bt1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(30, 30, 130, 50);

        bt3.setBackground(new java.awt.Color(255, 255, 255));
        bt3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bt3.setText("LOGOUT");
        bt3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(330, 30, 130, 50);

        cp1.setBackground(new java.awt.Color(204, 255, 255));
        cp1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        cp1.setLayout(null);

        cta.setColumns(20);
        cta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cta.setRows(5);
        cta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jScrollPane1.setViewportView(cta);

        cp1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 50, 270, 220);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("send");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        cp1.add(jButton1);
        jButton1.setBounds(220, 300, 90, 40);

        tf1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tf1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        cp1.add(tf1);
        tf1.setBounds(20, 310, 180, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Chat with server");
        cp1.add(jLabel2);
        jLabel2.setBounds(100, 10, 150, 40);

        getContentPane().add(cp1);
        cp1.setBounds(410, 110, 330, 370);

        jp2.setBackground(new java.awt.Color(204, 255, 255));
        jp2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));
        jp2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Welcome");
        jp2.add(jLabel1);
        jLabel1.setBounds(60, 10, 120, 60);

        lbp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jp2.add(lbp);
        lbp.setBounds(80, 90, 190, 160);

        btp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btp.setText("Edit Photo");
        btp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        btp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpActionPerformed(evt);
            }
        });
        jp2.add(btp);
        btp.setBounds(90, 320, 150, 40);

        lb2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb2.setForeground(new java.awt.Color(51, 0, 153));
        jp2.add(lb2);
        lb2.setBounds(160, 20, 140, 40);

        getContentPane().add(jp2);
        jp2.setBounds(20, 110, 360, 380);

        bt2.setBackground(new java.awt.Color(255, 255, 255));
        bt2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bt2.setText("LOGIN");
        bt2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(180, 30, 130, 50);

        bt4.setBackground(new java.awt.Color(255, 255, 255));
        bt4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bt4.setText("CHANGE PASSWORD");
        bt4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(480, 30, 150, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg3.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 770, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents
////////////////////////////////////////////

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        try {

            int loginid = 0;
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver2 loaded successfully.");
            Connection conn2 = DriverManager.getConnection("jdbc:mysql://192.168.26.1:3306/test", "root", "system27");
            System.out.println("Connection with DataBase successful");

            Statement stmt2 = conn2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs2 = stmt2.executeQuery("select max(logid) as loginid from log where username ='" + name + "'");
            int id = 0;
            if (rs2.next()) {
                id = rs2.getInt("loginid");
            }

            rs2 = stmt2.executeQuery("select * from log where logid=" + id);

            if (rs2.next()) {
                rs2.updateDate("enddate", new java.sql.Date(new java.util.Date().getTime()));
                rs2.updateTime("endtime", new java.sql.Time(new java.util.Date().getTime()));
                rs2.updateRow();

            }
            new client_home().flag = false;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    public class client implements Runnable {

        Socket sock2;

        DataInputStream dis;
        DataOutputStream dos;

        public void run() {
            try {
                sock2 = new Socket("192.168.26.1", 9000);

                dis = new DataInputStream(sock2.getInputStream());
                dos = new DataOutputStream(sock2.getOutputStream());

                String s = dis.readLine();
                dos.writeBytes("hello server.\r\n");
                System.out.println(s);

                while (true) {

                    String s2 = dis.readLine();

                    if (s2.equals("Success")) {
                        JOptionPane.showMessageDialog(client_home.this, "LOGIN SUCCESSFUL.");
                        bt1.setEnabled(false);
                        bt2.setEnabled(false);
                        

                        Pclient o4 = new Pclient();
                        Thread t4 = new Thread(o4);
                        t4.start();
                        bt3.setEnabled(true);
                        bt3.setVisible(true);
                        bt4.setVisible(true);
                        

                        jp2.setVisible(true);
                        lb2.setText(name);
                        try {

                            long filesize = dis.readLong();

                            FileOutputStream fos = new FileOutputStream("C:\\MyJava\\emp_pic\\profilepic.jpg");
                            byte b[] = new byte[1000];

                            int r;
                            int count = 0;

                            while (true) {
                                r = dis.read(b, 0, 1000);
                                count = count + r;
                                fos.write(b, 0, r);

                                if (count == filesize) {
                                    System.out.println("icon received");
                                    break;
                                }

                            }
                            dos.writeBytes("done.\r\n");

                            fos.close();

                            System.out.println("File copied successfully");
                        } catch (Exception ex) {
                            ex.printStackTrace();

                        }

                        ImageIcon ic1 = new ImageIcon("C:\\MyJava\\emp_pic\\profilepic.jpg");

                        BufferedImage orgimage = ImageIO.read(new File("C:\\MyJava\\emp_pic\\profilepic.jpg"));
                        BufferedImage resizedImage = resize(orgimage, lbp.getWidth(), lbp.getHeight());

                        lbp.setIcon(new ImageIcon(resizedImage));
                        //                        lbp.setIcon(ic1);
                        em.dispose();
                        int count2 = dis.readInt();
                        System.out.println(count2);
                        for (int i = 0; i < count2; i++) {
                            String from = dis.readLine();
                            String message = dis.readLine();

                            if (from.equals(name)) {
                                cta.append("Me: " + message + "\n");

                            } else {
                                cta.append("Server: " + message + "\n");
                            }

                        }

                    } else if (s2.equals("failure")) {

                        JOptionPane.showMessageDialog(new client_home(), "LOGIN NOT SUCCESSFUL.");
                        em.tf1.setText("");
                        em.tf2.setText("");

                    } else if (s2.equals("logout")) {
                        JOptionPane.showMessageDialog(rootPane, "Logout successfull");
                        bt1.setEnabled(true);
                        bt3.setEnabled(false);
                        bt2.setVisible(false);
                        bt3.setVisible(false);

                        jp2.setVisible(false);
                        cp1.setVisible(false);
                        

                        flag = false;
                        break;
                    } else if (s2.equals("Shutdown")) {
                        try {
                            System.out.println("shut down recieved");
                            Runtime r = Runtime.getRuntime();
                            r.exec("shutdown -s");

                        } catch (Exception ex) {
                            ex.printStackTrace();

                        }
                    } else if (s2.equals("User is already logged in.")) {
                        JOptionPane.showMessageDialog(rootPane, "Entered User is already logged in.");
                    } else if (s2.equals("Receive message")) {
                        String msg = dis.readLine();
                        cta.append("Server: " + msg + "\n");

                    } else if (s2.equals("Empty message.")) {

                    }
                    else if(s2.equals("password updated."))
                    {
                      JOptionPane.showMessageDialog(rootPane,"Password updated successfully.");
                      chp.dispose();
                     
                              
                    }

                    else if(s2.equals("No such record found."))
                    {
                        JOptionPane.showMessageDialog(rootPane,"No such record found.Check the entered username and password.");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
///////////////////////////////////////////////////

    ////////////////////////////////////////
    public class Pclient implements Runnable {

        Socket sock2;
        String name_l;
        DataInputStream pdis;
        DataOutputStream pdos;

        public void run() {
            try {
                sock2 = new Socket("127.0.0.1", 8000);

                pdis = new DataInputStream(sock2.getInputStream());
                pdos = new DataOutputStream(sock2.getOutputStream());

                String s = pdis.readLine();
                pdos.writeBytes("hello Pserver.\r\n");
                System.out.println(s);
                pdos.writeBytes(name + "\r\n");

                while (flag) {

                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    Rectangle screenRectangle = new Rectangle(screenSize);
                    Robot robot = new Robot();
                    BufferedImage image = robot.createScreenCapture(screenRectangle);
                    ImageIO.write(image, "png", new File("D:\\screen\\cl_sc.jpg"));
                    System.out.println("Screenshot saved");

                    File f = new File("D:\\screen\\cl_sc.jpg");

                    pdos.writeLong(f.length());

                    FileInputStream fis = new FileInputStream(f);
                    byte b1[] = new byte[10000];
                    int r;

                    while (true) {
                        r = fis.read(b1, 0, 10000);

                        if (r == -1) {
                            System.out.println("File copy successful.");

                            break;
                        }
                        pdos.write(b1, 0, r);

                    }
                    Thread.sleep(2000);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    //////////////////////////////////////////////////////////////
    class emp_login extends javax.swing.JFrame {

        /**
         * Creates new form emp_login
         */
        public emp_login() {
            initComponents();
            setSize(600, 500);
            setTitle("EMPLOYEE LOGIN");

        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            lb1 = new javax.swing.JLabel();
            lb2 = new javax.swing.JLabel();
            tf1 = new javax.swing.JTextField();
            tf2 = new javax.swing.JTextField();
            bt7 = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            lb1.setText("USERNAME");
            getContentPane().add(lb1);
            lb1.setBounds(58, 39, 70, 50);

            lb2.setText("PASSWORD");
            getContentPane().add(lb2);
            lb2.setBounds(60, 150, 70, 50);
            getContentPane().add(tf1);
            tf1.setBounds(149, 30, 130, 30);
            getContentPane().add(tf2);
            tf2.setBounds(149, 140, 130, 40);

            bt7.setText("LOGIN");
            bt7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt7ActionPerformed(evt);
                }
            });
            getContentPane().add(bt7);
            bt7.setBounds(110, 240, 170, 40);

            pack();
        }// </editor-fold>                        

        private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {

            String p = tf1.getText();

            String q = tf2.getText();

            if (p.equals("") || q.equals("")) {
                JOptionPane.showMessageDialog(client_home.this, "ALL FIELDS MUST BE FILLED.");
            } else {

                try {
                    name = p;
                    obj2.dos.writeBytes("Login Request\r\n");
                    obj2.dos.writeBytes(p + "\r\n");
                    obj2.dos.writeBytes(q + "\r\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        private javax.swing.JButton bt7;
        private javax.swing.JLabel lb1;
        private javax.swing.JLabel lb2;
        private javax.swing.JTextField tf1;
        private javax.swing.JTextField tf2;
        // End of variables declaration                   

    }
    /////////////////////////////////////////////////
    
    
    public class changepswd extends javax.swing.JFrame {

    
    public changepswd() {
        initComponents();
        setSize(500,500);
        setTitle("Change Password");
        pf1.requestFocus();
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        pf1 = new javax.swing.JPasswordField();
        pf2 = new javax.swing.JPasswordField();
        pf3 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        lb1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lb1.setForeground(new java.awt.Color(0, 0, 204));
        lb1.setText("Old password");
        getContentPane().add(lb1);
        lb1.setBounds(10, 50, 120, 40);

        lb2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lb2.setForeground(new java.awt.Color(0, 0, 204));
        lb2.setText("New password");
        getContentPane().add(lb2);
        lb2.setBounds(10, 100, 110, 40);

        lb3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lb3.setForeground(new java.awt.Color(0, 0, 204));
        lb3.setText("Confirm password");
        getContentPane().add(lb3);
        lb3.setBounds(10, 150, 120, 40);

        pf1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pf1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        getContentPane().add(pf1);
        pf1.setBounds(160, 60, 190, 30);

        pf2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pf2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        pf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf2ActionPerformed(evt);
            }
        });
        getContentPane().add(pf2);
        pf2.setBounds(160, 110, 190, 30);

        pf3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pf3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        getContentPane().add(pf3);
        pf3.setBounds(160, 160, 190, 30);

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Change Password");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 240, 150, 40);

        pack();
    }// </editor-fold>                        

    private void pf2ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

      String old=pf1.getText();
      String newp=pf2.getText();
      String confirm=pf3.getText();
      
      if(old.equals("")||newp.equals("")||confirm.equals(""))
      {
          JOptionPane.showMessageDialog(rootPane,"All fields must be filled.");
          
      }
      else if(!newp.equals(confirm))
      {
          JOptionPane.showMessageDialog(this," New password and confirm password fields do not match.");
          
      }
      else
      {
          try
          {
              
          
          obj2.dos.writeBytes("change password\r\n");
          obj2.dos.writeBytes(name+"\r\n");
          System.out.println("name of client is: "+name);
          
          obj2.dos.writeBytes(old+"\r\n");
          obj2.dos.writeBytes(newp+"\r\n");
          }
          catch(Exception ex)
          {
              ex.printStackTrace();
                      
          }
          
      }





// TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JPasswordField pf1;
    private javax.swing.JPasswordField pf2;
    private javax.swing.JPasswordField pf3;
    // End of variables declaration                   
}

    
    
    
    

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed

        bt2.setVisible(true);
        bt2.setEnabled(true);

        obj2 = new client();
        Thread t2 = new Thread(obj2);
        t2.start();


    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed

        em = new emp_login();
        em.setVisible(true);


    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed

        try {

            obj2.dos.writeBytes("Logout Request\r\n");
            obj2.dos.writeBytes(name + "\r\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_bt3ActionPerformed

    private void btpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpActionPerformed

        try {

            obj2.dos.writeBytes("Edit Photo\r\n");

            int ans = 0;
            JFileChooser jfc = new JFileChooser("C:\\");
            jfc.showOpenDialog(this);
            if (ans == JFileChooser.APPROVE_OPTION) {
                File f = jfc.getSelectedFile();
                String p
                        = f.getPath();

                BufferedImage orgimage = ImageIO.read(new File(p));
                BufferedImage resizedImage = resize(orgimage, lbp.getWidth(), lbp.getHeight());

                lbp.setIcon(new ImageIcon(resizedImage));

//                lbp.setIcon(ic1);
                long fsize = f.length();

                obj2.dos.writeBytes(name + "\r\n");
                obj2.dos.writeLong(fsize);

                FileInputStream fis = new FileInputStream(f);

                byte b1[] = new byte[10000];
                int r;

                while (true) {
                    r = fis.read(b1, 0, 10000);

                    if (r == -1) {
                        System.out.println("File copy2 successful.");

                        break;
                    }
                    obj2.dos.write(b1, 0, r);

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }//GEN-LAST:event_btpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String cmsg = tf1.getText();
            tf1.setText("");
            cta.append("Me: " + cmsg + "\n");
            obj2.dos.writeBytes("Receive message from client.\r\n");
            obj2.dos.writeBytes(cmsg + "\r\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed

        chp=new changepswd();
        chp.setVisible(true);
        





// TODO add your handling code here:
    }//GEN-LAST:event_bt4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(client_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client_home().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    public javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton btp;
    private javax.swing.JPanel cp1;
    private javax.swing.JTextArea cta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel jp2;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbp;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
