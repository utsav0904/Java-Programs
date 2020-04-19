import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;



class Operations{
	static Map<Object,Integer> map=new HashMap<Object,Integer>();
	Scanner scan=new Scanner(System.in);
	int k,v;
	Random rn;
	public Operations() {
		map.put(3,33);
		map.put(4,55);
		rn=new Random();
	}
	 void add() throws InterruptedException{
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+" Enter in insert...");
			System.out.println("Enter Rollno and Marks->");
			//k=scan.nextInt();
			//v=scan.nextInt();
			map.put(rn.nextInt(5),rn.nextInt(100));
			System.out.println(map);
			System.out.println(Thread.currentThread().getName()+" Leaves..");
			notify();
			wait();
		}
	 void remove() throws InterruptedException{
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+" Enter in Delete...");
			System.out.println("Enter the Rollno to delete->");
			//k=scan.nextInt();
			if(map.containsKey(rn.nextInt(5))){
				map.remove(rn.nextInt(5));
				System.out.println(map);
			}
			else{
				System.out.println("Wrong Rollno");
			}
			System.out.println(Thread.currentThread().getName()+" Leaves..");
			notify();
			wait();
		}
	 void update() throws InterruptedException{
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+" Enter in Update...");
			System.out.println("Enter the Rollno to Update & Marks->");
			//k=scan.nextInt();
			//v=scan.nextInt();
			if(map.containsKey(rn.nextInt(5))){
				map.put(rn.nextInt(5),rn.nextInt(5));
				System.out.println(map);
			}
			else{
				System.out.println("Wrong Rollno");
			}
			System.out.println(Thread.currentThread().getName()+" Leaves..");
			notify();
			wait();
		}
		
}
class DML implements Runnable{
	
	Operations op;
	Thread th;
	int action;
	DML(String s,Operations op,int action){
		th=new Thread(this,s);
		this.op=op;
		this.action=action;
		th.start();
	}
	public void run() {
		while(true){
			synchronized (op) {
				if(action==1){
					try {
						op.add();
					} catch (InterruptedException e) {
					}
				}
				else if(action==3){
					try {
						op.remove();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else{
					try {
						op.update();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
public class DmlOpreation {
	public static void main(String[] args){	
		Operations op=new Operations();
		//insert=1 update=2 delete=3
		DML d1=new DML("Pradip",op,2);
		DML d2=new DML("Ravi",op,1);
		DML d3=new DML("Darshak",op,3);
		DML d4=new DML("Shubh",op,2);
		DML d5=new DML("Rajan",op,3);

	}
}
