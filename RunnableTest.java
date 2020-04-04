package Day_3;
/**
 * 测试Lock锁机制
 * @author xie19
 *
 */
public class RunnableTest {
	public static void main(String[] args) {
		RunnableDemo rd=new RunnableDemo();
		new Thread(rd,"小明").start();//开启线程
		new Thread(rd,"小红").start();//开启线程
		new Thread(rd,"小张").start();//开启线程
	}
}
