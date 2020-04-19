




class Database{
	Database(){
		
	}
	void read(){
		System.out.println(Thread.currentThread().getName()+" Reading Data");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		System.out.println(Thread.currentThread().getName()+" Finish Reading Data");
	}
	void update(){
		System.out.println(Thread.currentThread().getName()+" Updataing Data");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {		}
		System.out.println(Thread.currentThread().getName()+" Finish Updating Data");
	}
	
}
class Child implements Runnable{
	Thread th;
	Database st;
	static int a=10;
	String tna;
	
	Child(String s,Database st){
		th=new Thread(this,s);
		this.st=st;
		tna=s;
		th.start();
	}
	public void run(){	
	   st.read();
	   synchronized(st){
		 st.update();
	   }  
	}
	
}

public class ReadUpdateSynchronized {
	public static void main(String []args){
		Database b=new Database();
		Child c1=new Child("Pradip",b);
		Child c2=new Child("Ravi",b);
		Child c3=new Child("Mehul",b);
		Child c4=new Child("SUPER",b);
	}
}
