import java.util.ArrayList;




class ReaderWriter implements Runnable{
	Thread th;
	String tna;
	static int mutex=1;
	static int wrt=1;
	static int readCount=0;
	static ArrayList<Integer> arr=new ArrayList<Integer>();
	ReaderWriter(String s){
		th=new Thread(this,s);
		tna=s;
		th.start();
	}
	public void run(){
		try {
			if(tna.startsWith("Reader")){

				downReader();
				readCount++;
				if(readCount==1){
					downWriter();
				}
				upReader();
				
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+" reading this->"+arr);
				System.out.println("ReadCount is->"+readCount);
				Thread.sleep(1000);
				
				downReader();
				readCount--;
				if(readCount==0){
					upWriter();
				}
				System.out.println("ReadCount is->"+readCount);
				upReader();
				
			}
			else if(tna.startsWith("Writer")){
				
				downWriter();
				for(int j=0;j<5;j++){
					arr.add(j);
				}
				System.out.println(Thread.currentThread().getName()+" added->"+arr);
				Thread.sleep(1000);
				upWriter();
				
			}
		} catch (Exception e){}
	}
	void downReader(){
		while(mutex<=0);
		mutex=mutex-1;
	}
	void upReader(){
		mutex=mutex+1;
	}
	void downWriter(){
		while(wrt<=0);
		wrt=wrt-1;
	}
	void upWriter(){
		wrt=wrt+1;
	}
}
public class ReaderWriterThread {
	public static void main(String[] args) throws InterruptedException{
		for(int i=0;i<=5;i++){
			ReaderWriter r1=new ReaderWriter("Reader-"+i+"");
			ReaderWriter w1=new ReaderWriter("Writer-"+i+"");
			Thread.sleep(2000);
		}
	}
}
