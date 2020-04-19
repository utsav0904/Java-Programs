
import java.util.Stack;

class StackPro
{
    Stack<Integer> st=new Stack<>();
    int max=2;
    synchronized void pushed() throws InterruptedException{
        int value = 0;
        while(true){
                while(st.size()==max){
                	wait();
                }
                System.out.println("Pushed Value->"+ value);
                st.push(value++);
                notify();
                Thread.sleep(1000);
        }
    }
    synchronized void poping() throws InterruptedException{
        while(true){
                while(st.size()==0){
                    wait();
                }
                int val=st.pop();
                System.out.println("Poped Value->"+val);
                notify();
                Thread.sleep(1000);
        }
    }
}

class PushPop implements Runnable{
	
	Thread th;
	String tna;
	int n=0;
	StackPro sp;
	
	PushPop(String s,StackPro sp){
		th=new Thread(this,s);
		this.tna=s;
		this.sp=sp;
		th.start();
	}
	public void run(){
		if(tna.equals("Push")){
			try {
				sp.pushed();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(tna.equals("Pop")){
			try {
				sp.poping();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class PushPopThread {
	public static void main(String [] args){
		
		StackPro s=new StackPro();
		
		PushPop pp1=new PushPop("Push",s);
		
		try{
			Thread.sleep(500);
		}catch(Exception e){}
		
		PushPop pp2=new PushPop("Pop",s);
	}
}
