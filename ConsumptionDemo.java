package Day_3;
/**
 * ����
 * @author xie19
 *
 */
public class ConsumptionDemo implements Runnable{
	private ProducersDemo pd=null;
	public ConsumptionDemo(ProducersDemo producersDemo) {
		pd=producersDemo;
	}
	@Override
	public void run() {
		for(int i=1;i<=50;i++) {
			pd.pall1();
		}
		
	}
	
}
