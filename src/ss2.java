
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class ss2 extends javax.swing.JFrame {

    
    public ss2() {
       
        try {
            initComponents();
            BufferedImage orgimage = ImageIO.read(getClass().getResource("bg3.jpg"));
            BufferedImage resizedImage = resize(orgimage,400,300);
            jLabel1.setIcon(new ImageIcon(resizedImage));
            setSize(400,300);
            //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width/2)-(this.getWidth()/2);
            int y = (height/2)-(this.getHeight()/2);
            setLocation(x, y);
            //--------------------------
            
            new Thread(new ss2.progress()).start();
        } catch (IOException ex) {
            Logger.getLogger(ss1.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public class progress implements Runnable
    {

        @Override
        public void run() 
        {
            for (int i = 1; i <=100; i++) 
            {
                if(i<30)
                {
                    jLabel2.setText("Initializing..............");
                jProgressBar1.setValue(i);
                }
                else if(i<60)
                {
                    jLabel2.setText("Loading................");
                jProgressBar1.setValue(i);
                }
                else if(i<90)
                {
                    jLabel2.setText("Processing..............");
                jProgressBar1.setValue(i);
                }
                else
                {
                    jLabel2.setText("Launching..............");
                jProgressBar1.setValue(i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ss1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            dispose();
            new client_home().setVisible(true);
           
        }
        
    }
    
    public static BufferedImage resize(BufferedImage image, int width, int height) 
    {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 240, 110, 30);

        jProgressBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 255)));
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(10, 280, 390, 20);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 410, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ss2().setVisible(true);
                
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
