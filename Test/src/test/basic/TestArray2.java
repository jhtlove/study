package test.basic;

//����ģ��������ô�죿
public class TestArray2
{
	public static void disArray(int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static int comDivisor(int a, int b)
	{
		int com = 1;
		for (int i = 1; i <= Math.min(a, b); i++)// <= �ٸ��Ⱥź�����
		{
			if (a % i == 0 && b % i == 0)
			{
				com = i;
			}
		}
		return com;
	}
	//������a��ѭ������kλ
	public static void leftMov(int a[], int k)
	{
		int x = k % a.length;// ����λ��
		int index = 0;// �ƶ�ǰ��λ��
		// int index = 0;
		int temp = 0;// �ƶ�Ԫ��
		int temp1 = 0;// ��һ���ƶ�Ԫ��
		if (comDivisor(a.length, x) == 1)// ���ʣ����ж�
		{
			System.out.println("��ѭ����:");
			temp1 = a[index];// ��һ���ƶ�Ԫ��;Ϊ�˵�һ����˳��ִ�� temp=temp1;
			for (int i = 0; i < a.length; i++)
			{
				temp = temp1;
				index = (index - x + a.length) % a.length;// ���ƺ��λ��
				temp1 = a[index];// ������һ�����ƶ���Ԫ��
				a[index] = temp;// Ŀ��λ�÷��뱻�ƶ�Ԫ��
			}
		} else
		{
			System.out.println("ѭ����:");
			temp1 = a[index];// Ϊ�˵�һ����˳��ִ�� temp=temp1;
			int num = comDivisor(a.length, x);// �����ʣ��ƶ����Լ���κ�ͻ����ѭ��
			for (int j = 0; j < a.length; j++)
			{
				temp = temp1;// ��һ���ƶ���Ԫ�أ�����һ�α�ռλ��Ԫ��
				if (num != 0)
				{
					// temp = a[index];//������α��ƶ���Ԫ��
					index = (index - x + a.length) % a.length;
					;
					temp1 = a[index];// ������һ�����ƶ���Ԫ��
					a[index] = temp;// Ŀ��λ�÷��뱻�ƶ�Ԫ��
				} else
				{
					// ֻ��num==0ʱִ��һ�Σ������ֳ�ʼ������
					index++;
					index = index % a.length;// ����
					num = comDivisor(a.length, x);// ��������λ��
					temp = a[index];// ����ƶ���Ԫ�أ����µĿ�ʼ�����¸�ֵ����������һ�α�ռλ��Ԫ��
					index = (index - x + a.length) % a.length;
					temp1 = a[index];
					a[index] = temp;
				}
				num--;
				// System.out.println("index=" + index);
			}
		}
	}

	public static void initArray(int a[])
	{
		for (int i = 0; i < a.length; i++)
		{
			a[i] = i + 1;
		}
	}

	public static void main(String[] args)
	{
		int a[] = new int[9];
		initArray(a);
		disArray(a);
		leftMov(a, 3);
		disArray(a);
		// for(int i=0;i<a.length;i++)
		// {
		// //ȡģk����������Ϊk-1
		// a[i] = (i + 1) % a.length;//����Ԫ�ص�ֵ����ʾ��һ��Ԫ�ص�λ��
		// }
		// a[a[0]]

	}

}
