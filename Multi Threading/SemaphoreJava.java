
class  SThread implements Runnable{
	String tna;
	Thread th;
	static int sharedvalue=0;
	static int count=1;
	
	SThread(String s){
		th=new Thread(this,s);
		this.tna=s;
		th.start();
	}
	public void run() {
		
		if(tna.equals("Pradip")){
			System.out.println("Starting " + tna);
			try {
				System.out.println("Waiting for Enter to Critical Region->"+tna);
				down();
				System.out.println(tna+" Enter into Critical Region");
				
				for(int i=0;i<3;i++){
					sharedvalue++;
					System.out.println("SharedResource Value->"+sharedvalue);
					Thread.sleep(1000);
				}
			} catch (Exception e){}
				System.out.println(tna+" leaves the Critical Region");
				up();
		}
		else if(tna.equals("Ravi")){
			System.out.println("Starting " + tna);
			try {
				System.out.println("Waiting for Enter to Critical Region->"+tna);
				down();
				System.out.println(tna+" Enter into Critical Region");
				
				for(int i=0;i<3;i++){
					sharedvalue--;
					System.out.println("SharedResource Value->"+sharedvalue);
					Thread.sleep(1000);
				}
			} catch (Exception e){}
				
				System.out.println(tna+" leaves the Critical Region");
				up();
		}
	}
	void down(){
		while(count<=0);
		count=count-1;
	}
	void up(){
		count=count+1;
	}
}

public class SemaphoreJava {
	public static void main(String []args){
		SThread mt1 = new SThread("Pradip");
        SThread mt2 = new SThread("Ravi");
	}
}
