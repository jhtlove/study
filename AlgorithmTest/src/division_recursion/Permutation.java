package division_recursion;
/**
 * 
 * ȫ����
 */
//������static���Զ������������ķ��ͣ�ֻ�����ڷǾ�̬��Ա�����ϣ�staticҪ������������
public class Permutation <T>
{

	public  void swap(T arr[],int a,int b)
	{
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public  void perm(T arr[],int k,int m)
	{
		//k��m����ǰ׺����ӡ����ʼֵ��k=0
		if(k == m)
		{
			//��0��m��ӡ��������
			for(int i=0;i<=m;i++)
			{
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		else
		{
			//ע��߽��飬�� <= ����
			for(int j=k;j<=m;j++)
			{
				swap(arr,k,j);//j���ֵΪm���ܽ��������һ��Ԫ��
				perm(arr,k+1,m);//j<=m,k+1���ֵΪm+1
//��ԭ��ԭ���Ļ��������ϣ�Ϊ��һ�ε�j++����׼��
//����1 2 3,swap���2 1 3,��һ�λ����Ȼ�ԭ��1,2,3,��1��3������������ֱ����2 1 3�����ϣ�2��3����
//���ζ���ԭ���е�1�Դ�������Ԫ�ؽ�����������֤ǰ׺�õ�������Ԫ�أ���Ȼ�п��ܣ���1��5�����󣬲���ԭ������5��1��������ǰ׺����1��ǰ׺�ظ�������
				swap(arr,k,j);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Integer arr[] = {1,2,3};//int �����������ͣ��Է���,����
		//String arr[] = {"a","b","c"};
		Permutation<Integer> p = new Permutation<Integer>();//�������������ϣ�new�����ʱ��ָ����������
		p.perm(arr, 0, arr.length-1);

	}

}
