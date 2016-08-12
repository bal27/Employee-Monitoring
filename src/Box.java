 class B1
{
    
double width,height,depth;

B1()
{
    width=height=depth=-1;
    
}
B1( B1 obj)
{
    width=obj.width;
    depth=obj.depth;
    height=obj.height;
}
B1(double a, double b , double c)
{
    width=a;
    depth=b;
    height=c;
}
    
    
   double func()
   {
       
       return width*height*depth;
   }
    
    
}
public class Box {
    public static void main(String args[])
    {
        
        B1 obj=new B1();
        System.out.println(obj.func());
        
        B1 obj2=new B1(10,30,24);
        System.out.println(obj2.func());
        
        B1 obj3=new B1(obj2);
        System.out.println(obj3.func());
        
        
    }
    
    
}
