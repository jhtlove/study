package division_recursion;
/***
 * 
 * ��Ȼ�ϲ�����ɨ��һ�ˣ����������;�߽��⴦�����ѵ㣡���� ����bug����
 *
 */
public class MergeSort2
{ 
	//�ϲ�a��a1��a2��a2 + 1��a3,����b�� ��a1 - a3��
	public static void merge(int a[],int a1,int a2,int a3)
	{
		int b[] = new int[a.length];
		int index1 = a1;
		int index2 = a2 + 1;
		int k = a1;
		while(index1 <= a2 && index2 <= a3)
		{
			if(a[index1] <= a[index2])
			{
				b[k] = a[index1];
				k++;
				index1++;
			}
			else
			{
				b[k] = a[index2];
				k++;
				index2++;
			}
		}
		while(index1 <= a2)
		{
			b[k] = a[index1];
			k++;
			index1++;
		}
		while(index2 <= a3)
		{
			b[k] = a[index2];
			k++;
			index2++;
		}
		
		//�ϲ��������ƻ�a
		for(int i=a1;i<=a3;i++)
		{
			a[i] = b[i];
		}
	}
	//�ǵݹ�ϲ�
	public static void scanAndSort(int a[])
	{
		if(a.length <= 1)return;
		int a1 = 0,a2 = 0;
		//a1 = a2 = 3;������ʱ���������ȣ���������
		int i = 0;
		while(a[i] < a[i+1])
		{
			i++;
			if(i == a.length -1) return;//�Ѿ�ȫ��������
		}
		a2 = i;//��¼ǰһ��
		i++;//��ʼ��һ�Σ�++����п���ָ�����һ��Ԫ����
		//ע��߽��⣡����
//��һ����ֻʣ��һ��Ԫ��û�ñȽ���,�����һ��while������ִ��
		boolean b = false;//�����û�кϲ������һ��Ԫ��,ûʣ�����һ���䵥�ģ�����true
//		if(i == a.length - 1)
//		{
//			b = false;
//		}
		while((i < a.length-1))
		{
			
			while(a[i] < a[i+1])
			{
				i++;//���ѭ���Ѿ��ܲ���i�ˣ���ʹi��ֵ��
				if(i == a.length - 1)
				{
					b = true;//�ϲ�����
					break;
				}
			}
			
			merge(a,a1,a2,i);//��û�п���һ��merge�ꣿ
			a2 = i;//a2ָ��ϲ��õ��µ����
			i++;//��ʼ��һ��
		}
		//��i ָ�����ʣ�µ�һ��Ԫ��,û�ú����һ��Ԫ�رȽ�
		if(i == a.length - 1 && b == false)
		{
			merge(a,a1,a2,i);//ר��Ϊ���һ��Ԫ��mergeһ��
		}
	}
	
	public static void display(int a[])
	{
		for(int temp:a)
		{
			System.out.print(temp + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args)
	{
		int a[] = {801,1001,801,825};
		display(a);
		scanAndSort(a);
		display(a);
	}

}
