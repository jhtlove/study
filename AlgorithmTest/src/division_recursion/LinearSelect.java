package division_recursion;

import java.util.Random;

/***
 * 
 * ����ѡ��;�ҵ���k���Ԫ��;
 * ����ܻ��ֳ�����������a1��a2ʹ��a1��ÿ��Ԫ�ض�С�ڵ���a2�еģ�����quickSort˼���е�position��
 *��һ��Ԫ�ش�Ķ��ź��棬С�Ķ���ǰ��
 *���ظ�Ԫ����ô�죿
 */
public class LinearSelect
{
	private static Random rad = new Random();
	private static final int  level = 1;
	public static void display(int a[])
	{
		for(int temp:a)
		{
			System.out.print(temp + " ");
		}
		System.out.println();
	}
	
	//�ҳ�����λ��
	public static int position(int arr[],int l,int r)
	{
//int temp = arr[rad.nextInt(r-l+1) + l];//nexInt  0=< r < specified value
		int temp = arr[l];
		int left = l;
		int right = r;
		
		
		//����while����������=temp�ģ����ã�Ϊʲô�أ�
		//��Ϊ�����������ƶ���������ڡ�3,3��,������ӵ��ڣ�positionһֱ��λ��index=1�����˰���ͬԪ�ص����д�С�������
		//���ĳһ��positionû����С��Χ�����綨λ�ڸô�������  �ұ߽磬������߽磬randomsizedSelect���һֱ�ݹ�
		while(left < right)
		{
			//���arr[0]����С��Ԫ�أ��������Լ����ǻ�ͣס������Խ��
			while(arr[right] >= temp && left < right)
			{
				right--;
			}
			if(left < right)
			{
				arr[left] = arr[right];
				left++;
			}
			while(arr[left] <= temp && left < right)
			{
				left++;
			}
			if(left < right)
			{
				arr[right] = arr[left];
				right--;
			}
		}
		arr[left] = temp;
		return left;
	}
		
	

	
	private static int randomsizedSelect(int a[],int p,int r,int k)
	{
//System.out.println(p + "-" + r + "��" + k + "��");
		if(p == r) 
		{
			System.out.println("��" + level + "���Ԫ��Ϊ�� " + a[p]);
			return a[p];
		}
		int i = position(a,p,r);
System.out.println("����λ�ã�" + i);
		if(i-p+1 >= k)
		{
System.out.println(p + "-" + i + "��" + k + "��");
			return randomsizedSelect(a,p,i,k);//���ﲻ���[p��i-1]��
		}
		else
		{
			int j = k - (i - p + 1);
System.out.println(i+1 + "-" + r + "��" + j + "��");
			return randomsizedSelect(a,i+1,r,j);
		}
	}
	
	public static void main(String[] args)
	{
		int a[] = {3,3};//���ӵ���temp��position����һֱָ��1������randomsizedSelectһֱ��0-1���ҵ�1���
		display(a);
		randomsizedSelect(a,0,a.length-1,level);
		display(a);
		
	}

}
