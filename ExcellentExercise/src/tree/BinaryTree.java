package tree;

//����ڵ�,���������ڵ㣬�Ϳ��Թ�����ջ����������NodeStack�ֱࣿ����Node�ඨ���push��pop�������ɣ�
class LinkNode
{
	TreeNode data;//�ڵ�Ԫ��ΪTreeNode��nextָ������������һ�£�ΪNode���� ����������TreeNode����
	LinkNode next;
	
	
	
	public LinkNode()
	{
		data = null;
		next = null;
	}



	public LinkNode(TreeNode tn)
	{
		this.data = tn;
		next = null;
	}



	public LinkNode(TreeNode tn, LinkNode next)
	{
		this.data = tn;
		this.next = next;
	}
	
}

//���������Ľڵ�
class TreeNode
{
	int data;
	TreeNode rchirld;
	TreeNode lchirld;
	int level;//���ڲ�Σ�Ϊ���ڵ�+1
	TreeNode()
	{
		data = 0;
		rchirld = null;
		lchirld = null;
	}
	
	public TreeNode(int data)
	{
		this.data = data;
		this.rchirld = null;
		this.lchirld = null;
	}
	
	public TreeNode(int data, TreeNode lchirld, TreeNode rchirld)
	{
		this.data = data;
		this.lchirld = lchirld;//alt + ���·����ͷ���뵱ǰ�У���������λ��
		this.rchirld = rchirld;
	}
	
}



//�ڵ����,˳��洢,ѭ������;����ĳ���Ӱ���ܱ����������������ߵĸ߶�
class NodeQueue
{
	int num = 0;//Ԫ�ظ���
	public static final int MAX = 200;//���   ����capacity,��������������ġ���ȡ�������Ӱ��
	int head = 0;//��ͷָ��
	int tail = 0;//��βָ��
	TreeNode que[] = new TreeNode[200];
	
	NodeQueue()
	{
		num = 0;
		head = 0;
		tail = 0;
	}
	
	public boolean isEmpty()
	{
		if(num == 0)
			return true;
		return false;
	}
	
	public boolean inQue(TreeNode t)
	{
		if(num >= NodeQueue.MAX || (tail + 1) % NodeQueue.MAX == head)
			return false;
		
		que[tail] = t;//����ָ��ָ����еĵ�һ��Ԫ�أ���βָ��ָ�����һ��Ԫ�صĺ���
		tail = (tail + 1) % NodeQueue.MAX;
		num++;
		return true;
	}
	
	public TreeNode outQue()
	{
		if(head == tail)
			return null;
		TreeNode t = que[head];
		head = (head + 1) % NodeQueue.MAX;
		num--;
		return t;
	}
}


////�ڵ�ջ����ʽ�洢(��Ҫһ��ָ�����ϣ�ע�Ᵽ�����������data���ͣ�nextָ�����ͱ�Ȼ��ָ����ࣨ�ýṹ��ָ�룩��)
//class NodeStack
//{
//	int num = 0;
//	Node head = new Node();//��ͷ��㣬ͷָ��Ϊhead,��ʽջ�����Ͳ���Ҫ��ͷ��㣡
//	NodeStack next = null;
//	public boolean isEmpty()
//	{
//		if(num == 0)
//			return true;
//		return false;
//	}
//	
//	/***
//	 * ����βָ�룬����β�巨
//	ͷ�巨�ɷ�Ҳ���ԣ���ջ��ջ��������ͷ����
//	 */
//	public void push(TreeNode t)
//	{
//		Node temp = new Node(t);
//		temp.next = head.next;
//		head.next = temp;
//		num++;
//	}
//	
//	public Node pop()
//	{
//		if(num == 0)
//		{
//			return null;
//		}
//		Node t = head.next;
//		head.next = t.next;
//		return t;
//	}
//}

public class BinaryTree
{
	//����һ��5���ڵ�Ĺ̶�������
	public static TreeNode creatBinaryTree()
	{
		TreeNode root = null;
		root = new TreeNode(0);
		root.level = 0;
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		root.lchirld = n1;
		root.lchirld.level = root.level + 1;
		root.rchirld = n2;
		root.rchirld.level = root.level + 1;
		n1.rchirld = n3;
		n1.rchirld.level = n1.level + 1;
		n2.rchirld = n4;
		n2.rchirld.level = n2.level + 1;
		return root;
	}
	
	//����n���ڵ����������
	public static TreeNode creatFullBinaryTree(int n)
	{
		if(n <= 0)return null;
		int num = n;
		TreeNode root = new TreeNode(0);//���ڵ�
		root.level = 0;
		num--;
		if(num <= 0) return root;
		NodeQueue nq = new NodeQueue();
		nq.inQue(root);
		TreeNode tns[] = new TreeNode[num];//׼���ò��� ���� �ӽڵ㣬��������,û�б�����ڵ�
		for(int i=0;i<tns.length;i++)
		{
			tns[i] = new TreeNode(i+1);
		}
		TreeNode index = null;
		int c = 0;
		while(c < tns.length)
		{
			index = nq.outQue();
			index.lchirld = tns[c];//����
			index.lchirld.level = index.level + 1;
			nq.inQue(index.lchirld);
			c++;
			if(c < tns.length)
			{
				index.rchirld = tns[c];//�Һ���
				index.rchirld.level = index.level + 1;
				nq.inQue(index.rchirld);
				c++;
			}
		}
		//null���ӽڵ㣬û����ӣ���Ϊ׼���õ��ӽڵ㶼�Ƿǿգ���������������
		return root;
	}
	
	//�ݹ�ģ�ǰ�����
	public static void preOrder(TreeNode root)
	{
		if(root != null)
		{
			System.out.print(root.data + "  ");
			preOrder(root.lchirld);
			preOrder(root.rchirld);
		}
		//preOrder(root.lchirld);���������д��if���棬��Ȼ���ֿ�ָ�����rootΪ���ˣ���ȥpreOrder�������ӡ��Һ���
		//preOrder(root.rchirld);
	}
	
	//�ݹ�ģ��������
	public static void inOrder(TreeNode root)
	{
		if(root == null)return;//Ϊ��ֱ�ӷ��أ�ʲôҲ��������ǰ���ַ�����
		inOrder(root.lchirld);
		System.out.print(root.data + " ");
		inOrder(root.rchirld);
	}
	
	
	
	//�ݹ�ģ��������
	public static void postOrder(TreeNode root)
	{
		if(root != null)
		{
			postOrder(root.lchirld);
			postOrder(root.rchirld);
			System.out.print(root.data + "  ");
		}
	}
	
	//�������,�ɱ����������������ΰ����ӡ��
	public static void searchByTier(TreeNode root)
	{
		if(root == null)
			return;
		NodeQueue nq = new NodeQueue();
		nq.inQue(root);
		TreeNode temp = null;
		int level = 0;
		while(!nq.isEmpty())
		{
			temp = nq.outQue();
			if(temp.level == 0)
			{
				System.out.print(temp.data);
				System.out.println();
				level++;
			}
			else if(temp.level == level)
			{
				System.out.print(temp.data);
				System.out.print("  ");
			}
			else if(temp.level > level)
			{
				System.out.println();
				level++;
				System.out.print(temp.data + "  ");
			}
			if(temp.lchirld != null)
			{
				nq.inQue(temp.lchirld);
			}
			if(temp.rchirld != null)
			{
				nq.inQue(temp.rchirld);
			}
		}
	}
	
	//�ǵݹ飬ǰ�����
	public static void searchByPre(TreeNode root)
	{
		TreeNode index = root;
		if(index == null)
		{
			return;
		}
		
	}
	
	//�ǵݹ飬�������
	public static void searchByIn(TreeNode root)
	{
		
	}

	//�ǵݹ飬�������
	public static void searchByPost(TreeNode root)
	{
		
	}
	
	public static void main(String[] args)
	{
		//search(creatFullBinaryTree(200));//�����������Ϊ200����ȫ���Ա�֤200���ڵ�����ڱ��������п������
		searchByTier(creatBinaryTree());
	}

}
