package my.demo;

//ö��
public class TestEnum
{

	//��ö��ֻ��һ��ֵ�����Ե�����̬���ģʽ
	enum C
	{
		A
	}
	
	enum WeekDay
	{
		MON("xingqiyi")
		{
			public void display()
			{
				System.out.println("����һ");
			}
		},TUE
		{
			public void display()
			{
				System.out.println("���ڶ�");
			}
		},WED
		{
			public void display()
			{
				System.out.println("������");
			}
		},THU
		{
			public void display()
			{
				System.out.println("������");
			}
		},FRI("xingqiwu")
		{
			public void display()
			{
				System.out.println("������");
			}
		},SAT
		{
			public void display()
			{
				System.out.println("������");
			}
		},SUN
		{
			public void display()
			{
				System.out.println("������");
			}
		};
		
		String value;
		
		public String getValue()
		{
			return this.value;
		}
		
		private WeekDay()
		{
			
		}
		
		private WeekDay(String value)
		{
			this.value = value;
		}
		
		public abstract void display();

	}
	
	enum Grade{
		A("100-80")
		{
			//ʵ�ֳ��󷽷� getLocal()
			public  String getLocal()
			{
				return("��");
			}
		},//�����ö��ŷָ�A��B��C
		B("79-60")
		{
			//ʵ�ֳ��󷽷� getLocal()
			public  String getLocal()
			{
				return("��");
			}
		},
		C("59-0")
		{
			//ʵ�ֳ��󷽷� getLocal()
			public  String getLocal()
			{
				return("��");
			}
		};//�ֺű�����
		
		private String value;
		
		//˽�й��캯����ʹ�ñ��˲�����new A B C ֮��Ķ���
		private Grade(String s)
		{
			value = s;
		}
		
		public String getValue()
		{
			return this.value;
		}
		
		public abstract String getLocal();//���󷽷�û�з����壬����ӷֺţ�
		//A,B,C����new�����Ķ��󣬳��󷽷��ܱ�֤new��ͬ����ʵ�ֲ�ͬ�ķ���getLocal
		}
	
	public static void main(String[] args)
	{
		//���ַ���ת��ö�٣��������������û��ύֵ�Ƿ�Ϸ�
		Grade.valueOf("B");//ת��Grade���͵Ķ���
		//����ö��ֵ������һ������
		Grade g[] = Grade.values();
		for(Grade gg: g)
		{
			System.out.println(gg);
		}
		
		WeekDay w = WeekDay.FRI;
		w.display();
		System.out.println(w.value);
		
		System.out.println(WeekDay.MON.getValue());
	}

}
