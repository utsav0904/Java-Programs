import java.util.Random;


class Booth{
	Random rn;
	int n;
	Booth(){
		n=0;
		rn=new Random();
	}
	 void voting() throws InterruptedException{
		
		System.out.println(Thread.currentThread().getName()+" Enter in Voting Room");
		System.out.println(Thread.currentThread().getName()+" Start Voting.");
		Thread.sleep(1000);
		while(true){
			n=rn.nextInt(11)+1;
			if(n==5){
				System.out.println(Thread.currentThread().getName()+" Has Voted.");
				System.out.println(Thread.currentThread().getName()+" Leaves the Voting Room");
				break;
			}
		}
		Thread.sleep(1000);
	}
}

class Peoples implements Runnable {
	Booth b;
	Thread th;
	
	Peoples(int s,Booth b){
		th=new Thread(this,""+s);
		this.b=b;
		th.start();
	}
	public void run(){	
		try{
			synchronized (b) {
				b.voting();
			}
		}catch(Exception e){}
	}
}


public class EVM_VOTING {
	public static void main(String[] args) throws InterruptedException{
		Booth b=new Booth();
		for(int i=0;i<6;i++){
			Peoples p=new Peoples(i,b);
		//	p.th.join();
		}
	}
}