

public class abc {

   public static void main(String[] args)
   {
       
   
    int month[][];
    month=new int[5][4];
    int i,j,k=0;
    for (i=0;i<5;i++
            )
    {
        
        for(j=0;j<4;j++)
        {
            month[i][j]=k;
            k++;
        }
    }1
    
    for (i=0;i<5;i++
            )
    {
        
        for(j=0;j<4;j++)
        {
            
            System.out.print(month[i][j]);
        }
        System.out.println();
    }
   }
}
