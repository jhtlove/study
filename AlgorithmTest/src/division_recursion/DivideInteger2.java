package division_recursion;

//�ݹ顢ѭ�����ۼ�;���ɵ�С����
public class DivideInteger2
{
	private static final int res = 4;

	public static void display(int n,String s)
	{
		//ÿ�εݹ鶼�����ﷵ�أ�����ȫ���������ˣ��ʹ�ӡ��
//��ӡ���ɵĻ����ȷֳ��������ʣ�²��ֵ�Ҳ�ȷֳ��������
//ֱ�ӷ���ֱ�Ӵ�ӡ��û���꣬�´�ѭ��һ����Ҳ�ض�������ꣻ
//�ֳ������Ӿ����ܴ�ݼ���1
		if(n == 0)
		{
			System.out.println(res + " = " + s.substring(3) + " ;");
		}
		else
		{
			//ѭ����ʹ�÷ֳ�ȥ������������������n��1������ѭ���ݹ���ѭ����ģʽ
			//��ѭ���У��ܱ�֤�ݹ�ص���ͬ�Ĳ�Σ�ĳ�ε�ѭ��������n��һ���� 
			for(int i=n;i>=1;i--)
			{
				//�����ݼ�ѭ��������ʹ�ݹ��ջ��Ƚ��ͣ�
				display(n-i,s + " + " + i);//���Ϸֳ�ȥһ��i��ÿ�ֳ�һ�����ۼӷֳ�ȥ��i����¼��
			}
		}
			
	}
	
	public static void main(String[] args)
	{
		display(res,"");

	}

}
