
public class shut {

    
    public static void main(String[] args)
    {
       try{
        Runtime r=Runtime.getRuntime();
       r.exec("shutdown -s -t 0");
       System.exit(0);
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           
       }
    }
    
    
}
