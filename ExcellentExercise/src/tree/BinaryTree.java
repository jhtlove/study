package tree;

//链表节点,定义好链表节点，就可以构建出栈，而不需在NodeStack类？直接在Node类定义出push和pop操作即可？
class LinkNode
{
	TreeNode data;//节点元素为TreeNode，next指针则必须与该类一致，为Node类型 ！！而不是TreeNode类型
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

//二叉树树的节点
class TreeNode
{
	int data;
	TreeNode rchirld;
	TreeNode lchirld;
	int level;//所在层次，为父节点+1
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
		this.lchirld = lchirld;//alt + 上下方向箭头，与当前行，交换上下位置
		this.rchirld = rchirld;
	}
	
}



//节点队列,顺序存储,循环队列;数组的长度影响能保存的满二叉树的最高的高度
class NodeQueue
{
	int num = 0;//元素个数
	public static final int MAX = 200;//最大   容量capacity,入队数量随着树的”深度“增大，有影响
	int head = 0;//队头指针
	int tail = 0;//队尾指针
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
		
		que[tail] = t;//队首指针指向队列的第一个元素，队尾指针指向最后一个元素的后面
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


////节点栈，链式存储(需要一个指针链上，注意保存所需的数据data类型，next指针类型必然是指向该类（该结构的指针），)
//class NodeStack
//{
//	int num = 0;
//	Node head = new Node();//带头结点，头指针为head,链式栈根本就不需要带头结点！
//	NodeStack next = null;
//	public boolean isEmpty()
//	{
//		if(num == 0)
//			return true;
//		return false;
//	}
//	
//	/***
//	 * 设置尾指针，便于尾插法
//	头插法可否？也可以，出栈入栈都在链表头即可
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
	//建立一个5个节点的固定二叉树
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
	
	//建立n个节点的满二叉树
	public static TreeNode creatFullBinaryTree(int n)
	{
		if(n <= 0)return null;
		int num = n;
		TreeNode root = new TreeNode(0);//根节点
		root.level = 0;
		num--;
		if(num <= 0) return root;
		NodeQueue nq = new NodeQueue();
		nq.inQue(root);
		TreeNode tns[] = new TreeNode[num];//准备好材料 —— 子节点，存入数组,没有保存根节点
		for(int i=0;i<tns.length;i++)
		{
			tns[i] = new TreeNode(i+1);
		}
		TreeNode index = null;
		int c = 0;
		while(c < tns.length)
		{
			index = nq.outQue();
			index.lchirld = tns[c];//左孩子
			index.lchirld.level = index.level + 1;
			nq.inQue(index.lchirld);
			c++;
			if(c < tns.length)
			{
				index.rchirld = tns[c];//右孩子
				index.rchirld.level = index.level + 1;
				nq.inQue(index.rchirld);
				c++;
			}
		}
		//null的子节点，没有入队，因为准备好的子节点都是非空，构造满二叉树嘛
		return root;
	}
	
	//递归的，前序遍历
	public static void preOrder(TreeNode root)
	{
		if(root != null)
		{
			System.out.print(root.data + "  ");
			preOrder(root.lchirld);
			preOrder(root.rchirld);
		}
		//preOrder(root.lchirld);这两句必须写到if里面，不然出现空指针错误，root为空了，还去preOrder它的左孩子、右孩子
		//preOrder(root.rchirld);
	}
	
	//递归的，中序遍历
	public static void inOrder(TreeNode root)
	{
		if(root == null)return;//为空直接返回，什么也不做，和前面手法类似
		inOrder(root.lchirld);
		System.out.print(root.data + " ");
		inOrder(root.rchirld);
	}
	
	
	
	//递归的，后序遍历
	public static void postOrder(TreeNode root)
	{
		if(root != null)
		{
			postOrder(root.lchirld);
			postOrder(root.rchirld);
			System.out.print(root.data + "  ");
		}
	}
	
	//按层遍历,可遍历任意二叉树，如何按层打印？
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
	
	//非递归，前序遍历
	public static void searchByPre(TreeNode root)
	{
		TreeNode index = root;
		if(index == null)
		{
			return;
		}
		
	}
	
	//非递归，中序遍历
	public static void searchByIn(TreeNode root)
	{
		
	}

	//非递归，后序遍历
	public static void searchByPost(TreeNode root)
	{
		
	}
	
	public static void main(String[] args)
	{
		//search(creatFullBinaryTree(200));//队列数组最大为200，完全可以保证200个节点的树在遍历过程中可以入队
		searchByTier(creatBinaryTree());
	}

}
