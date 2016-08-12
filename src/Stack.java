




 class Stack1 {
    
    private int stck[];
    
    private int tos;
    //int size;
    
    Stack1(int i)
    {
        stck=new int[i];
        tos=-1;
        //size=i;
    }
    void push(int j)
    {
        if(tos==stck.length-1)
        {
            
            System.out.println("Stack full. cannot push");
            
        }
        else
        {
            
            stck[++tos]= j ;
            
        }
    }
    
    int pop()
    {
        
        if(tos<0)
        {
            
            System.out.println("stack empty.");
            return 0;
        }
        else
        {
           return stck[tos--]; 
            
        }
    
      }
 }

class Stack
{
    
    public static void main(String args[])
    {
        
        Stack1 obj=new Stack1(10);
        for(int i=0;i<10;i++)
        {
        obj.push(i);
        }
        
        for(int i=0;i<10;i++)
        {
            System.out.println("Popping out");
            
            System.out.println(obj.pop());
            
            
        }
        
    }
    
}
