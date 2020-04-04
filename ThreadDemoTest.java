package Day_3;

public class ThreadDemoTest {
	public static void main(String[] args) throws InterruptedException {
		
		ThreadDemo td=new ThreadDemo();
		ThreadDemo3 td1=new ThreadDemo3();
		int e=td1.getPriority();
		System.out.println(e);
		for(int i=1;i<=10;i++) {
			if(i==3){
				td.start();//启动线程
			}
			if(i==5) {
				td1.join();//强制启动该线程
			}
		}
	}
}
