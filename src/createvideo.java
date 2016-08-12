
import ch.randelshofer.media.avi.AVIOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;

public class createvideo {

    public static void main(String[] args) {
        
    
        try{
    
    File f = new File("C:\\MyJava\\video4.avi");

        AVIOutputStream av = new AVIOutputStream(f, AVIOutputStream.VideoFormat.JPG);

        File f2 = new File("C:\\MyJava\\data2");

        int len = f2.listFiles().length;

        av.setFrameRate(3);
//        av.setVideoDimension(500, 500);
        av.setTimeScale(1);

        for (int i = 1; i <= len; i++) {
            try {
                File f1 = new File(f2 + "\\" + i + ".jpg");
//                FileInputStream fis = new FileInputStream(f1);
                BufferedImage bi = ImageIO.read(f1);
                av.writeFrame(bi);
                System.out.println("Image fetched : " + i);

            } catch (Exception e) {
                e.printStackTrace();
            }

         
        }
           av.close();
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
    }
}

