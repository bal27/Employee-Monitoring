
import ch.randelshofer.media.avi.AVIOutputStream;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Desktop;
import static java.awt.SystemColor.desktop;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class viewlog extends javax.swing.JFrame {

    ArrayList<logs> al = new ArrayList<>();
    tablemodel tm;

    public viewlog() {
        initComponents();
        tm = new tablemodel();

        jt1.setModel(tm);
        plb3.setVisible(false);
        setTitle("VIEW LOG");
        setSize(1000, 700);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver2 loaded successfully.");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
            System.out.println("Connection with DataBase successful");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from employee");
            cb1.addItem("--    SELECT      --");

            while (rs.next()) {

                cb1.addItem(rs.getString("username"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    ////////////////////////////////////////////////////////

    class tablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int i, int j) {
            if (j == 0) {
                return al.get(i).date;
            } else {
                return al.get(i).time;
            }

        }

    }
    /////////////////////////////////////////

    class logs {

        String date;
        String time;

        public logs(String date, String time) {
            this.date = date;
            this.time = time;

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox();
        cb2 = new javax.swing.JComboBox();
        cb5 = new javax.swing.JComboBox();
        plb3 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        cb3 = new javax.swing.JComboBox();
        cb4 = new javax.swing.JComboBox();
        cb6 = new javax.swing.JComboBox();
        cb7 = new javax.swing.JComboBox();
        bt1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        btv = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Select  employee");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 40, 130, 50);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Select start date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 140, 120, 50);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Select end date");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 260, 120, 50);

        cb1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        cb1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 255)));
        cb1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb1ItemStateChanged(evt);
            }
        });
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        getContentPane().add(cb1);
        cb1.setBounds(150, 50, 200, 30);

        cb2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"2012","2013","2014","2015","2016"}));
        cb2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 255)));
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });
        getContentPane().add(cb2);
        cb2.setBounds(140, 150, 80, 30);

        cb5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2012","2013","2014","2015","2016"}));
        cb5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        cb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb5ActionPerformed(evt);
            }
        });
        getContentPane().add(cb5);
        cb5.setBounds(140, 270, 80, 30);

        plb3.setBackground(new java.awt.Color(204, 255, 255));
        plb3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        plb3.setLayout(null);

        lb1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb1.setForeground(new java.awt.Color(0, 0, 204));
        lb1.setText("Username");
        plb3.add(lb1);
        lb1.setBounds(30, 70, 150, 30);

        lb2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb2.setForeground(new java.awt.Color(0, 0, 204));
        lb2.setText("Name");
        plb3.add(lb2);
        lb2.setBounds(30, 130, 120, 30);

        lb3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb3.setForeground(new java.awt.Color(0, 0, 204));
        lb3.setText("E-mail");
        plb3.add(lb3);
        lb3.setBounds(30, 180, 120, 40);

        lb4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb4.setForeground(new java.awt.Color(0, 0, 204));
        lb4.setText("Phone");
        plb3.add(lb4);
        lb4.setBounds(30, 240, 120, 40);

        lb5.setText("ICON");
        lb5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));
        plb3.add(lb5);
        lb5.setBounds(210, 60, 140, 210);

        getContentPane().add(plb3);
        plb3.setBounds(480, 30, 370, 460);

        cb3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01","02","03","04","05","06","07","08","09","10","11","12"}));
        cb3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        getContentPane().add(cb3);
        cb3.setBounds(230, 150, 70, 30);

        cb4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
        cb4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        cb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb4ActionPerformed(evt);
            }
        });
        getContentPane().add(cb4);
        cb4.setBounds(310, 150, 70, 30);

        cb6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01","02","03","04","05","06","07","08","09","10","11","12" }));
        cb6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        getContentPane().add(cb6);
        cb6.setBounds(230, 270, 70, 30);

        cb7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
        cb7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        getContentPane().add(cb7);
        cb7.setBounds(310, 270, 70, 30);

        bt1.setBackground(new java.awt.Color(255, 255, 255));
        bt1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bt1.setForeground(new java.awt.Color(0, 0, 204));
        bt1.setText("Fetch Data");
        bt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(40, 370, 160, 40);

        jt1.setBackground(new java.awt.Color(53, 255, 255));
        jt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(jt1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 460, 390, 170);

        btv.setBackground(new java.awt.Color(255, 255, 255));
        btv.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btv.setForeground(new java.awt.Color(0, 0, 204));
        btv.setText("View Video");
        btv.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 255, 255)));
        btv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvActionPerformed(evt);
            }
        });
        getContentPane().add(btv);
        btv.setBounds(240, 370, 160, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 860, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb5ActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed

    }//GEN-LAST:event_cb1ActionPerformed

    private void cb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb1ItemStateChanged

        String username = cb1.getSelectedItem().toString();
        plb3.setVisible(true);
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Driver2 loaded successfully.");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
            System.out.println("Connection with DataBase successful");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from employee where username='" + username + "'");

            if (rs.next()) {

                lb1.setText(username);
                lb2.setText(rs.getString("name"));
                lb3.setText(rs.getString("email"));
                lb4.setText(rs.getString("phone"));

                lb5.setIcon(new ImageIcon(System.getProperty("user.home") + "\\images\\" + username + ".jpg"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_cb1ItemStateChanged

    private void cb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb4ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed

        String username = cb1.getSelectedItem().toString();
        int y1 = Integer.parseInt((String) cb2.getSelectedItem());
        int m1 = Integer.parseInt((String) cb3.getSelectedItem());
        int d1 = Integer.parseInt((String) cb4.getSelectedItem());
        int y2 = Integer.parseInt((String) cb5.getSelectedItem());
        int m2 = Integer.parseInt((String) cb6.getSelectedItem());
        int d2 = Integer.parseInt((String) cb7.getSelectedItem());
        java.sql.Date dl = new java.sql.Date(y1 - 1900, m1 - 1, d1);
        java.sql.Date dl2 = new java.sql.Date(y2 - 1900, m2 - 1, d2);

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Driver loaded successfully.");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system27");
            System.out.println("Connection with DataBase successful");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("Select distinct(stdate) from log where stdate>='" + dl + "'and enddate<='" + dl2 + "' and username='" + username + "'");
            while (rs.next()) {
                String stdate1 = rs.getString("stdate");
                Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs2 = stmt2.executeQuery("Select logid from log where stdate='" + stdate1 + "' and username='" + username + "'");
                int seconds = 0;
                while (rs2.next()) {
                    int logid = rs2.getInt("logid");
                    Statement stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs3 = stmt3.executeQuery("Select TIME_TO_SEC(endtime)-TIME_TO_SEC(sttime) as sec from log where logid=" + logid);
                    if (rs3.next()) {
                        seconds = seconds + Integer.parseInt(rs3.getString("sec"));

                    }
                }

                if (seconds < 60) {

                    System.out.println("Date is: " + stdate1);
                    String time = "Time is: " + seconds + "seconds";
                    al.add(new logs(stdate1, time));
                    tm.fireTableDataChanged();

                } else {
                    System.out.println("Date is: " + stdate1);
                    String time = "Time is : " + seconds / 60 + "minutes " + (seconds % 60) + "seconds.";
                    al.add(new logs(stdate1, time));
                    tm.fireTableDataChanged();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_bt1ActionPerformed

    private void btvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvActionPerformed

        if (jt1.getSelectedRow() == -1) {

        } else {
            String username = cb1.getSelectedItem().toString();

            String date = al.get(jt1.getSelectedRow()).date;

            File f = new File(System.getProperty("user.home") + "\\videos\\" + username);

            if (!f.exists()) {
                f.mkdirs();

            }
            try{
            File f2 = new File(f + "\\" + date + ".avi");
          

            

                AVIOutputStream av = new AVIOutputStream(f2, AVIOutputStream.VideoFormat.JPG);
                File f3 = new File(System.getProperty("user.home")+"\\screenshots\\"+username+"\\"+date);
                int len = f3.listFiles().length;

                av.setFrameRate(3);
                av.setTimeScale(1);
//                av.setVideoDimension(500, 500);

                for ( int j = 0; j < len; j++) {
                    try {
                        File f1 = new File(f3 + "\\" + j + ".jpg");
//                        FileInputStream fis = new FileInputStream(f1);
                        BufferedImage bi  = ImageIO.read(f1);
                        av.writeFrame(bi);
                        System.out.println("Image fetched : " + j);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                av.close();
                System.out.println("Video created successfully.");
                Desktop.getDesktop().open(f2);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        
        
        
        }


    }//GEN-LAST:event_btvActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb2ActionPerformed

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
            java.util.logging.Logger.getLogger(viewlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewlog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton btv;
    private javax.swing.JComboBox cb1;
    private javax.swing.JComboBox cb2;
    private javax.swing.JComboBox cb3;
    private javax.swing.JComboBox cb4;
    private javax.swing.JComboBox cb5;
    private javax.swing.JComboBox cb6;
    private javax.swing.JComboBox cb7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JPanel plb3;
    // End of variables declaration//GEN-END:variables
}
