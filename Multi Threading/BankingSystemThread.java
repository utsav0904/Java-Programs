import java.util.Scanner;


class Bank{
	
	int amt=0;
	Scanner scan=new Scanner(System.in);
	
	synchronized void deposite() throws InterruptedException{
			
			System.out.println(Thread.currentThread().getName()+" Start deposite");
			System.out.println("Enter Amt to Deposite->");
			amt=scan.nextInt();
			System.out.println(Thread.currentThread().getName()+" Deposited->"+amt);
			Thread.sleep(1000);
			
	}
	synchronized void withdrawal() throws InterruptedException{
			
			System.out.println(Thread.currentThread().getName()+" Start Withdrawing");
			System.out.println("Enter Amt to withdrawn->");
			amt=scan.nextInt();
			System.out.println(Thread.currentThread().getName()+" Withdrawal->"+amt);
			Thread.sleep(1000);
	}
	
}

class Customers implements Runnable{
	String tna;
	Thread th;
	Bank bk;
	int n;
	Scanner scan;
	
	Customers(String s,Bank bk){
		th=new Thread(this,s);
		tna=s;
		n=-1;
		scan=new Scanner(System.in);
		this.bk=bk;
		th.start();
	}
	public void run(){
		try {
			for(int i=0;i<5;i++){
				System.out.println(tna+" you Enter What To Do(0-d/1-w)->");
				int n=scan.nextInt();
				
				if(n==0){
					bk.deposite();
				}
				else if(n==1){
					bk.withdrawal();
				}
				else{
					System.out.println(" Sorry Wrong Input!!!");
				}
			}
			
		} catch (Exception e) {}

	}
}
public class BankingSystemThread {
	public static void main(String []args) throws InterruptedException{
		String s[]=new String[]{"Pradip","Ravi","Mehul"};
		Bank bk=new Bank();
		Customers c[] = new Customers[3];
		for(int i=0;i<3;i++){
			c[i]=new Customers(s[i],bk);
			Thread.sleep(5000);
		}
	}
}
