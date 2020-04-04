package Day_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Runable�ӿ�ʹ����
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
			lock.lock();//��ȡ��
			if(num>0) {
				System.out.println(Thread.currentThread().getName()+num+"��ƻ��");
				num--;
				Thread.sleep(100);//ģ�������ӳ�100ms
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//����쳣������
		}finally {
			lock.unlock();//�ͷ���
		}
		
	}

}
