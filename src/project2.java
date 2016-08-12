
import static java.awt.Frame.NORMAL;
import java.io.*;
import java.net.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.lang.*;

public class project2 extends javax.swing.JFrame {

    mytablemodel tm;
    ArrayList<server.clienthandler> al = new ArrayList<>();
    ArrayList<chatroom> al2 = new ArrayList<>();

    public project2() {
        initComponents();
        setSize(650, 600);
        setTitle("ADMIN HOME");
        tm = new mytablemodel();
        jt1.setModel(tm);

        server obj1 = new server();
        Thread t = new Thread(obj1);
        t.start();
        Pserver o5 = new Pserver();
        Thread t5 = new Thread(o5);
        t5.start();

    }
    ///////////////////inner class/////////////////

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

        class clienthandler implements Runnable {

            DataInputStream dis;
            DataOutputStream dos;
            Socket sock;
            String name="";
            int loginid = 0;

            public clienthandler(Socket sock) {

                al.add(this);
                tm.fireTableDataChanged();
                this.sock = sock;

            }

            public void run() {

                try {

                    dis = new DataInputStream(sock.getInputStream());
                    dos = new DataOutputStream(sock.getOutputStream());
                    dos.writeBytes("Hello client\r\n");
                    String s = dis.readLine();

                    System.out.println(s);

                    while (true) {
                        String s1 = dis.readLine();

                        if (s1.equals("Login Request")) {

                            name = "";

                            int flag = 0;

                            String m = dis.readLine();
                            String n = dis.readLine();
                            System.out.println("Received Username is : " + m + "\n password is : " + n);
                            for (int i = 0; i < al.size(); i++) {
                                if (al.get(i).name.equals(m)) {

                                    flag = 1;
                                    break;

                                }
                            }
                            if (flag == 1) {
                                dos.writeBytes("User is already logged in.\r\n");

                            } else {
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    System.out.println("Driver loaded successfully.");
                                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
                                    System.out.println("Connection with DataBase successful");

                                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                    ResultSet rs = stmt.executeQuery("select * from employee where username='" + m + "' and password ='" + n + "'");

                                    System.out.println("ResultSet created");

                                    if (rs.next()) {
                                        dos.writeBytes("Success\r\n");
                                                       name = m;
                                        tm.fireTableDataChanged();
                         
                                        try {
                                            File f = new File(System.getProperty("user.home") + "\\images\\" + m + ".jpg");
                                            FileInputStream fis = new FileInputStream(System.getProperty("user.home") + "\\images\\" + m + ".jpg");
                                            long fs = f.length();
                                            dos.writeLong(f.length());
                                            byte b[] = new byte[1000];

                                            int r;
                                            int count = 0;

                                            while (true) {
                                                r = fis.read(b, 0, 1000);
                                                count = count + r;
                                                dos.write(b, 0, r);

                                                if (count == fs) {
                                                    System.out.println("image icon sent to client");

                                                    break;
                                                }

                                            }
                                            String jh = dis.readLine();
                                            System.out.println("File copied successfully");
                                            try {
                                                int count2 = 0;

                                                Class.forName("com.mysql.jdbc.Driver");
                                                System.out.println("Driver2 loaded successfully.");
                                                Connection conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
                                                System.out.println("Connection with DataBase successful");

                                                Statement stmt2 = conn2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                                ResultSet rs2 = stmt2.executeQuery("select count(*) as c1 from chat where msgto='" + name + "' or msgfrom ='" + name + "'");
                                                if (rs2.next()) {
                                                    count2 = rs2.getInt("c1");
                                                }
                                                dos.writeInt(count2);
                                                rs2 = stmt2.executeQuery("select * from chat where msgto='" + name + "'or msgfrom ='" + name + "'");
                                                while (rs2.next()) {
                                                    dos.writeBytes(rs2.getString("msgfrom") + "\r\n");
                                                    dos.writeBytes(rs2.getString("msg") + "\r\n");

                                                }

                                            } catch (Exception ex) {
                                                ex.printStackTrace();

                                            }

                                        } catch (Exception ex) {
                                            ex.printStackTrace();

                                        }

                                        try {
                                            Class.forName("com.mysql.jdbc.Driver");
                                            System.out.println("Driver2 loaded successfully.");
                                           
                                            Connection conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
                                            System.out.println("Connection with DataBase successful");

                                            Statement stmt2 = conn2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                            ResultSet rs2 = stmt2.executeQuery("select * from log ");
                                            System.out.println("ResultSet2 created");

                                            rs2.moveToInsertRow();

                                            rs2.updateString("username", name);
                                            rs2.updateDate("stdate", new java.sql.Date(new java.util.Date().getTime()));
                                            rs2.updateTime("sttime", new java.sql.Time(new java.util.Date().getTime()));
                                            rs2.insertRow();

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        dos.writeBytes("failure\r\n");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else if (s1.equals("Logout Request")) {
                            String name = dis.readLine();
                            System.out.println(name);
                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                                System.out.println("Driver2 loaded successfully.");
                                Connection conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
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
                                al.remove(this);
                                tm.fireTableDataChanged();

                                dos.writeBytes("logout\r\n");
                                break;
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else if (s1.equals("Edit Photo")) {
                            String namep = dis.readLine();
                            long fs2 = dis.readLong();
                            System.out.println("Size of new image icon is: " + fs2);

                            try {
                                FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "\\images\\" + namep + ".jpg");

                                byte b[] = new byte[10000];
                                int r, count;
                                count = 0;
                                while (true) {
                                    r = dis.read(b, 0, 10000);

                                    count = count + r;
                                    fos.write(b, 0, r);

                                    if (count == fs2) {
                                        break;
                                    }

                                }
                                fos.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();

                            }

                        } else if (s1.equals("Receive message from client.")) {
                            String msg2 = dis.readLine();
                            int flag = 0;
                            int index = -1;

                            for (int i = 0; i < al2.size(); i++) {
                                if (al2.get(i).cname.equals(name)) {
                                    flag = 1;
                                    index = i;
                                }

                            }
                            if (flag == 0) {
                                chatroom ch = new chatroom(name);
                                ch.setVisible(true);

                                ch.ta1.append(name + ": " + msg2 + "\n");
                                al2.add(ch);

                            } else {
                                al2.get(index).ta1.append(name + ": " + msg2 + "\n");
                                al2.get(index).toFront();
                                al2.get(index).setState(NORMAL);
                            }

                            try {

                                Class.forName("com.mysql.jdbc.Driver");
                                System.out.println("Driver loaded successfully.");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
                                System.out.println("Connection with DataBase successful");

                                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs = stmt.executeQuery("select * from chat");
                                rs.moveToInsertRow();
                                rs.updateString("msgto", "Server");
                                rs.updateString("msgfrom", name);
                                rs.updateString("msg", msg2);
                                rs.insertRow();

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        
                        else if(s1.equals("change password"))
                        {
                            String username= dis.readLine();
                            String oldpswd=dis.readLine();
                            String newpswd=dis.readLine();
                            
                            try {

                                Class.forName("com.mysql.jdbc.Driver");
                                System.out.println("Driver loaded successfully.");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
                                System.out.println("Connection with DataBase successful");

                                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                
                                ResultSet rs=stmt.executeQuery("select * from employee where username='"+username+"' and password='"+oldpswd+"'");
                                
                                if(rs.next())
                                {
                                    rs.updateString("password",newpswd);
                                    rs.updateRow();
                                    dos.writeBytes("password updated.\r\n");
                                    
                                    
                                }
                                
                                else
                                {
                                    dos.writeBytes("No such record found.\r\n");
                                    
                                    
                                }
                                
                                
                            }
                            catch(Exception ex)
                            {
                                ex.printStackTrace();
                            }
                                
                            
                            
                                                    
                            
                            
                        }

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    al.remove(this);
                    tm.fireTableDataChanged();

                }
            }
        }
    }

    /////////////////////////////////////////////////
    public class Pserver implements Runnable {

        ServerSocket sersock;

        public void run() {
            try {

                sersock = new ServerSocket(8000);

                while (true) {
                    Socket sock = sersock.accept();
                    Pclienthandler obj3 = new Pclienthandler(sock);
                    Thread t = new Thread(obj3);
                    t.start();

                }
            } catch (Exception e) {
                e.printStackTrace();

            }

        }

        class Pclienthandler implements Runnable {

            DataInputStream pdis;
            DataOutputStream pdos;
            Socket sock;
            String name;

            public Pclienthandler(Socket sock) {

                tm.fireTableDataChanged();

                this.sock = sock;

            }

            public void run() {
                try {

                    pdis = new DataInputStream(sock.getInputStream());
                    pdos = new DataOutputStream(sock.getOutputStream());
                    pdos.writeBytes("Hello pclient\r\n");
                    String s = pdis.readLine();
                    String name = pdis.readLine();
                    System.out.println(s);

                    File f2 = new File(System.getProperty("user.home") + "\\screenshots\\" + "\\" + name + "\\" + new java.sql.Date(new java.util.Date().getTime()));
                    String ar[] = f2.list();

                    if (!f2.exists()) {
                        f2.mkdirs();

                    }
                    int i = f2.listFiles().length;
                    while (true) {

                        long size = pdis.readLong();
                        System.out.println(System.getProperty("user.home"));

                        FileOutputStream fos = new FileOutputStream(f2 + "\\" + i + ".jpg");

                        byte b[] = new byte[10000];
                        int r, count;
                        count = 0;
                        while (true) {
                            r = pdis.read(b, 0, 10000);

                            count = count + r;
                            fos.write(b, 0, r);

                            if (count == size) {
                                break;
                            }

                        }
                        fos.close();
                        i++;
                        Thread.sleep(2000);
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
    }

    ////////////////////////////////////////
    class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).sock.getInetAddress().getHostAddress();

            } else {
                return al.get(rowIndex).name;
            }

        }

    }
    ///////////////////////

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        lb3 = new javax.swing.JLabel();
        bt2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        bt3 = new javax.swing.JButton();
        bts1 = new javax.swing.JButton();
        bts2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(null);

        bt1.setBackground(new java.awt.Color(255, 255, 255));
        bt1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bt1.setForeground(new java.awt.Color(0, 0, 204));
        bt1.setText("ADD EMPLOYEE");
        bt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(30, 110, 170, 50);

        lb3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 255, 51));
        lb3.setText("      ADMIN  HOME");
        getContentPane().add(lb3);
        lb3.setBounds(80, 20, 280, 50);

        bt2.setBackground(new java.awt.Color(255, 255, 255));
        bt2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bt2.setForeground(new java.awt.Color(0, 0, 204));
        bt2.setText("VIEW EMPLOYEE");
        bt2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(30, 200, 170, 50);

        jt1.setBackground(new java.awt.Color(204, 255, 255));
        jt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        jt1.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IP Address", "Name of employee"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 80, 280, 300);

        bt3.setBackground(new java.awt.Color(255, 255, 255));
        bt3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bt3.setForeground(new java.awt.Color(0, 0, 204));
        bt3.setText("VIEW LOGS");
        bt3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(30, 290, 170, 50);

        bts1.setBackground(new java.awt.Color(255, 255, 255));
        bts1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        bts1.setText("Shutdown Selected");
        bts1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        bts1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bts1ActionPerformed(evt);
            }
        });
        getContentPane().add(bts1);
        bts1.setBounds(330, 430, 140, 40);

        bts2.setBackground(new java.awt.Color(255, 255, 255));
        bts2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bts2.setText("Shutdown all");
        bts2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        bts2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bts2ActionPerformed(evt);
            }
        });
        getContentPane().add(bts2);
        bts2.setBounds(480, 430, 130, 40);

        jButton1.setText("jButton1");
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 330, 73, 23);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("Chat");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(200, 430, 120, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 650, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        new project3().setVisible(true);
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        new viewemp().setVisible(true);

    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed

        new viewlog().setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_bt3ActionPerformed

    private void bts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bts1ActionPerformed

        if (jt1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "No row selected");

        } else {
            try {
                al.get(jt1.getSelectedRow()).dos.writeBytes("Shutdown\r\n");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

// TODO add your handling code here:
    }//GEN-LAST:event_bts1ActionPerformed

    private void bts2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bts2ActionPerformed

        for (int i = 0; i < al.size(); i++) {
            try {
                al.get(i).dos.writeBytes("Shutdown\r\n");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_bts2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (jt1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "No employee selected for chat.");

        } else {
            String name = al.get(jt1.getSelectedRow()).name;
            //new chatroom(name).setVisible(true);

            int flag = 0, index = -1;
            for (int i = 0; i < al2.size(); i++) {
                if (al2.get(i).cname.equals(name)) {
                    flag = 1;
                    index = i;
                    break;
                }

            }
            if (flag == 0) {
                chatroom cr = new chatroom(name);
                cr.setVisible(true);
                al2.add(cr);

            } else {
                al2.get(index).toFront();
                al2.get(index).setState(NORMAL);

            }

        }


    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(project2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(project2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(project2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(project2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new project2().setVisible(true);
            }
        });
    }

    public class chatroom extends javax.swing.JFrame {

        String cname;

        public chatroom(String cname) {

            initComponents();
            setSize(500, 500);
            setTitle("Chatroom");
            this.cname = cname;
            lb1.setText("Chat with " + cname);
            tf1.requestFocus();

            try {

                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded successfully.");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
                System.out.println("Connection with DataBase successful");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from chat where msgto='" + cname + "' or msgfrom='" + cname + "'");
                while (rs.next()) {
                    String msg = rs.getString("msg");

                    String msg_from = rs.getString("msgfrom");
                    if (msg_from.equals("Server")) {
                        ta1.append("Me: " + msg + "\n");

                    } else {
                        ta1.append(cname + ": " + msg + "\n");

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            bt1 = new javax.swing.JButton();
            tf1 = new javax.swing.JTextField();
            jScrollPane1 = new javax.swing.JScrollPane();
            ta1 = new javax.swing.JTextArea();
            lb1 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            bt1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            bt1.setForeground(new java.awt.Color(0, 0, 204));
            bt1.setText("Send");
            bt1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
            bt1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt1ActionPerformed(evt);
                }
            });
            getContentPane().add(bt1);
            bt1.setBounds(330, 350, 100, 30);

            tf1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
            getContentPane().add(tf1);
            tf1.setBounds(60, 350, 240, 30);

            ta1.setColumns(20);
            ta1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
            ta1.setRows(5);
            ta1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
            jScrollPane1.setViewportView(ta1);

            getContentPane().add(jScrollPane1);
            jScrollPane1.setBounds(60, 70, 330, 250);

            lb1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            lb1.setForeground(new java.awt.Color(0, 0, 204));
            getContentPane().add(lb1);
            lb1.setBounds(130, 10, 200, 40);

            pack();
        }// </editor-fold>                        

        private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {

            String msg = tf1.getText();

            tf1.setText("");

            for (int i = 0; i < al.size(); i++) {
                if (al.get(i).name.equals(cname)) {
                    try {

                        if (msg.equals("")) {

                            al.get(i).dos.writeBytes("Empty message.\r\n");
                            JOptionPane.showMessageDialog(rootPane, "Attempt to send empty message.");
                            tf1.requestFocus();

                        } else {
                            tf1.requestFocus();

                            ta1.append("Server: " + msg + "\n");
                            al.get(i).dos.writeBytes("Receive message\r\n");
                            al.get(i).dos.writeBytes(msg + "\r\n");
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            try {

                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded successfully.");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
                System.out.println("Connection with DataBase successful");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from chat");

                rs.moveToInsertRow();
                rs.updateString("msgto", cname);

                rs.updateString("msgfrom", "Server");

                rs.updateString("msg", msg);
                rs.insertRow();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        /**
         * @param args the command line arguments
         */
        // Variables declaration - do not modify                     
        private javax.swing.JButton bt1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel lb1;
        private javax.swing.JTextArea ta1;
        private javax.swing.JTextField tf1;
        // End of variables declaration                   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bts1;
    private javax.swing.JButton bts2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt1;
    private javax.swing.JLabel lb3;
    // End of variables declaration//GEN-END:variables
}
