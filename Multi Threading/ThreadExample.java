



class ChildThread extends Thread{
	
	int i;
	
	ChildThread(String s,int i){
		super(s);
		this.i=i;
		start();
	}
	public void run(){
		for(int j=i;j<=i+9;j++){
			System.out.println("      "+getName()+" ="+j);
			try{
				Thread.sleep(500);
			}
			catch(Exception e){}
		}
	}

}

public class ThreadExample {
  public static void main(String []args){
	  Thread t=Thread.currentThread();
	  
	  ChildThread c1=new ChildThread("Pradip",1);
	  try{c1.join();}catch(Exception e){}
	  ChildThread c2=new ChildThread("Ravi",11);
	  try{c2.join();}catch(Exception e){}
	  ChildThread c3=new ChildThread("Mehul",21);
	  try{c3.join();}catch(Exception e){}
	  
	    System.out.println("    Main="+t.isAlive());
		System.out.println("    Child c1="+c1.isAlive());
		System.out.println("    Child c2="+c2.isAlive());
		System.out.println("    Child c3="+c3.isAlive());
		
		for(int i=0;i<10;i++){
			System.out.println("   "+i+" "+t.getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("    Main="+t.isAlive());
		System.out.println("    Child c1="+c1.isAlive());
		System.out.println("    Child c2="+c2.isAlive());
		
		
		
	  
  }
}
