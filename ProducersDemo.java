package Day_3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �߳�ͨ��
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
				this.wait();//����ͬ��������,�߳̽���ȴ�����,ֻ�ܱ������̻߳���
				//this.wait();,this.notify();ֻ������synchronized����;
			}
			this.name=name;			
			Thread.sleep(10);
			this.age=age;
			this.flag=true;
			this.notify();//����һ���µ��߳�
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public  void push1(String name,int age) {
			lock.lock();
			try {
				while(flag){				
					notFull.await();//��������ʹ��synchronizedʱ,java.util.concurrent�����await()����������wait();����
				}
				this.name=name;			
				Thread.sleep(10);
				this.age=age;
				this.flag=true;
				notFull.signal();////��������ʹ��synchronizedʱ,java.util.concurrent�����signal()����������notify();����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
	}
	//����
	public synchronized void pall() {
		try {
			while(!flag) {
				this.wait();//����
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
