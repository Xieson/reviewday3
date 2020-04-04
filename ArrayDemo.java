package Day_3;

public class ArrayDemo {
	private static Integer[] stu=null;
	private static int size=0;
	//定义数组长度
	public static void leng(int  as) {
		stu=new Integer[as];
	}
	//添加数据
	public static void add(int add) {
		stu[size]=add;
		size++;
	}
	//查找索引为2的数据是什么
	public static int view(int index) {
		for(int i=0;i<size;i++) {
			if(i==index) {
				
				return stu[i];
			}
		}
		return -1;//如果没有返回-1
	}
	//根据值查找到所在的索引
	public static int view1(int value) {
		for(int i=0;i<size;i++) {
			if(stu[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	//跟换数组里面的值
	public static void update(int index,int value) {
		for(int i=0;i<size;i++) {
			if(i==index) {
				stu[i]=value;
			}
		}
	}
	//根据索引删除数组里面的相应位置的值
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
