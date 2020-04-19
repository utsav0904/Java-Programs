import java.util.Random;

class WatchTvThread{
	Thread father,son;
	int totalbrusttime_father=100,totalbrusttime_son=50;
	Random brtime;
	int breaktime;
	final int timeslice=10;
	static int count=1;
	
	
	WatchTvThread(){
		brtime=new Random();
		father=new Thread(){
			public void run(){
				while(totalbrusttime_father>0){
					try {
						down();
						breaktime=brtime.nextInt(10)+1;
						System.out.println("Father Start Watching Tv");
						for(int i=1;i<=timeslice;i++){
							if(breaktime==5){
								System.out.println("Break//");
								System.out.println("Remote Handed To other");
								totalbrusttime_father--;
								up();
								wait();
							}
							totalbrusttime_father--;
						}
						System.out.println("Father 30 mins Over.");
						up();
						notify();
						
					}catch(Exception e){}	
				}	
			}
		};father.start();
		son=new Thread(){
			public void run(){
				while(totalbrusttime_son>0){
					try {
						down();
						breaktime=brtime.nextInt(10)+1;
						System.out.println("Son Start Watching Tv");
						for(int i=1;i<=timeslice;i++){
							Thread.sleep(1000);
							
							if(breaktime==5){
								System.out.println("Break///");
								System.out.println("Remote Handed To other");
								totalbrusttime_son--;
								up();
								wait();
							}
							totalbrusttime_son--;
						}
						System.out.println("Son 30 mins Over.");
						up();
						notify();
						
					}catch(Exception e){}
				}
			}
		};son.start();
	}
	
	void down(){
		while(count<=0);
		count=count-1;
	}
	void up(){
		count=count+1;
	}
}
public class FatherSonTvFight {
	public static void main(String[] args) {	
		WatchTvThread wth=new WatchTvThread();	
	}
}
