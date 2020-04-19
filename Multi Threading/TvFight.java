import java.util.Random;


class TvClass{
	int b;
	Random rn;
	TvClass(){
		rn=new Random();
		b=0;
	}
	synchronized void watching() throws InterruptedException{
			System.out.println(Thread.currentThread().getName()+" StartWatching tv..");
			Thread.sleep(1000);
			b=rn.nextInt(5)+1;
			for(int i=0;i<10;i++){
				System.out.println("CountWatch="+i+"     "+b);
				Thread.sleep(500);
				if(b==2){
					System.out.println("Break..");
					break;
				}
			}	
			System.out.println(Thread.currentThread().getName()+" StopWatching tv..");
			notify();
			wait();
	}
}
class Father_Son implements Runnable{
	Thread th;
	TvClass tv;
	Father_Son(String s,TvClass tv){
		th=new Thread(this,s);
		this.tv=tv;
		th.start();
	}
	public void run(){
		while(true){
			try {
				tv.watching();
			} catch (InterruptedException e){}
		}
	}
}
public class TvFight {
	public static void main(String []args) throws InterruptedException{
		TvClass tv=new TvClass();
		Father_Son fs1=new Father_Son("father",tv);
		Thread.sleep(1000);
		Father_Son fs2=new Father_Son("son",tv);
	}
}
