package Day_3;
/**
 * ≤‚ ‘
 * @author xie19
 *
 */
public class ProduersTest {
	public static void main(String[] args) {
		ProducersDemo pro=new ProducersDemo();
		new Thread(new producersDemo1(pro)).start();
		new Thread(new ConsumptionDemo(pro)).start();
	}
}
