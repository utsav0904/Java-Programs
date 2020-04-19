




class SynchronizeMethod{
	public SynchronizeMethod() {
		
	}
	synchronized void callMe(){
		try{
			Thread.sleep(500);
		}catch(Exception e){}
		ThreadChild.a--;
		System.out.println("Thread Entering->"+Thread.currentThread().getName()+" A->"+ThreadChild.a);
	}
}

class ThreadChild implements Runnable{
	Thread th;
	SynchronizeMethod st;
	static int a=10;
	
	ThreadChild(String s,SynchronizeMethod st,int p){
		th=new Thread(this,s);
		th.setPriority(p);
		this.st=st;
		th.start();
	}
	public void run(){
	   st.callMe();
	}
	
}

public class SynchronizationThread {
	public static void main(String []args){
		SynchronizeMethod st=new SynchronizeMethod();
		
		ThreadChild c1=new ThreadChild("Pradip",st,9);
		
		ThreadChild c2=new ThreadChild("Ravi",st,5);
		
		ThreadChild c3=new ThreadChild("Mehul",st,8);
		
		
		
		
	}
}
