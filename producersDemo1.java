package Day_3;
/**
 * ����
 * @author xie19
 *
 */
public class producersDemo1 implements Runnable{
	private ProducersDemo pd=null;
	public producersDemo1(ProducersDemo producersDemo) {
		pd=producersDemo;
	}
	@Override
	public void run() {
		for(int i=1;i<=50;i++) {
			if(i%2==0) {
				pd.push1("���", 12);
			}else {
				pd.push1("С��", 1);
			}
		}
	}

}
