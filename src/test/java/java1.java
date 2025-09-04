interface  A{
   void show();
}
interface  B{
  void dis();
}
class S implements  A,B{

   public void show(){
      System.out.println("self respect is very improtant !");
  }
  public void  dis(){
      System.out.println("self respect is very important !");
  }
}
class Java1{
    public static void main(String[] args) {
        S obj=new S();
        obj.dis();
        obj.show();

    }
}

