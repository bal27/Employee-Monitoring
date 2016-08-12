class A
{
    
  int a,b;
  
  A(int a,int b)
  {
      
      this.a=a;
      this.b=b;
  }
  
  void func(A obj){
      a=obj.a+5;
      b=obj.b*10;
      
      
      
      System.out.println("Value of a and b inside func is "+ a+" and "+b);
      
      
      
  }
    
    
   }


public class Pass {
    public static void main(String[] args)
    {
        
        
       A obj=new A(5,10);
       System.out.println("Value of a and b inside main before call is "+ obj.a+" and "+obj.b);
       obj.func(obj);
       System.out.println("Value of a and b inside main after call is "+ obj.a+" and "+obj.b);
      
    }
    
}
