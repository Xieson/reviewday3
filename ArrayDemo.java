package Day_3;

public class ArrayDemo {
	private static Integer[] stu=null;
	private static int size=0;
	//�������鳤��
	public static void leng(int  as) {
		stu=new Integer[as];
	}
	//�������
	public static void add(int add) {
		stu[size]=add;
		size++;
	}
	//��������Ϊ2��������ʲô
	public static int view(int index) {
		for(int i=0;i<size;i++) {
			if(i==index) {
				
				return stu[i];
			}
		}
		return -1;//���û�з���-1
	}
	//����ֵ���ҵ����ڵ�����
	public static int view1(int value) {
		for(int i=0;i<size;i++) {
			if(stu[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	//�������������ֵ
	public static void update(int index,int value) {
		for(int i=0;i<size;i++) {
			if(i==index) {
				stu[i]=value;
			}
		}
	}
	//��������ɾ�������������Ӧλ�õ�ֵ
	public static void del(int index) {
		for(int i=index;i<size-1;i++) {
			stu[i]=stu[i+1];
		}
		stu[size]=null;
		size--;
	}
	public static void main(String[] args) {
		
	}
}
