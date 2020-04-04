package Day_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Runable接口使用所
 * @author xie19
 *
 */
public class RunnableDemo implements Runnable{
	private static int num=50;
	private static Lock lock=new ReentrantLock();
	@Override
	public void run() {
		for(int i=1;i<=50;i++) {
			dow();
		}
		
	}

	private void dow() {
		try {
			lock.lock();//获取锁
			if(num>0) {
				System.out.println(Thread.currentThread().getName()+num+"号苹果");
				num--;
				Thread.sleep(100);//模拟网络延迟100ms
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//输出异常的类型
		}finally {
			lock.unlock();//释放锁
		}
		
	}

}
