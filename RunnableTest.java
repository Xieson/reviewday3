package Day_3;
/**
 * ����Lock������
 * @author xie19
 *
 */
public class RunnableTest {
	public static void main(String[] args) {
		RunnableDemo rd=new RunnableDemo();
		new Thread(rd,"С��").start();//�����߳�
		new Thread(rd,"С��").start();//�����߳�
		new Thread(rd,"С��").start();//�����߳�
	}
}
