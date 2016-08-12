class Fact
{
    
    int facto(int n)
    {
        int result;
        if(n==1) return 1;
       result= facto(n-1)*n;
             
       return result;
    }
        
        
    }
    
class rec1
{
    
    public static void main
            (String[] args)
            {
                
                Fact obj=new Fact();
                
                int res=obj.facto(3);
                System.out.println(res);
                
                
                
                
            }
    
}