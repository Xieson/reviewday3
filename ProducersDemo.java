package Day_3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信
 * @author xie19
 *
 */
public class ProducersDemo {
	private String name;
	private int age;
	private boolean flag=false;
	private Lock lock=new ReentrantLock();
	private Condition notFull  = lock.newCondition(); 
	public synchronized void push(String name,int age) {
		try {
			while(flag){				
				this.wait();//调用同步锁机制,线程进入等待池中,只能被其他线程唤醒
				//this.wait();,this.notify();只适用于synchronized机制;
			}
			this.name=name;			
			Thread.sleep(10);
			this.age=age;
			this.flag=true;
			this.notify();//唤醒一个新的线程
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public  void push1(String name,int age) {
			lock.lock();
			try {
				while(flag){				
					notFull.await();//当方法不使用synchronized时,java.util.concurrent里面的await()方法代替了wait();方法
				}
				this.name=name;			
				Thread.sleep(10);
				this.age=age;
				this.flag=true;
				notFull.signal();////当方法不使用synchronized时,java.util.concurrent里面的signal()方法代替了notify();方法
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
	}
	//消费
	public synchronized void pall() {
		try {
			while(!flag) {
				this.wait();//开启
			}
			System.out.println(this.name+"--"+this.age);
			Thread.sleep(10);
			this.flag=false;
			this.notify();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  void pall1() {
		lock.lock();
		try {
			while(!flag) {
				notFull.await();
			}
			System.out.println(this.name+"--"+this.age);
			Thread.sleep(10);
			this.flag=false;
			notFull.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
}
