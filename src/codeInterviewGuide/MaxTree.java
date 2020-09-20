package codeInterviewGuide;

import java.util.Stack;

public class MaxTree {
	
	 class Node{
		public int value;
		public Node right;
		public Node left;
		public Node(int data){
			this.value = data;
		}
	}
<<<<<<< HEAD
	int a = 0;
=======

>>>>>>> master
	//���������Ӧ�õ�������������ԭ��
	//ÿһ�����ĸ��ڵ���������ߵ�һ��������� ���ֺ��ұߵ�һ��������������У���С���Ǹ�
	// ���һ���������û�б�����������ұ�Ҳû�С�����������������������һ�����֣�Ҳ����������ĸ��ڵ�
	public static Node covertArrayToMaxTree(int[] array){
		Node root = null;
		Stack<Integer> st = new Stack<Integer>();
		int[] leftFirstBiggerNum = new int[array.length];
		int[] rightFirstBiggerNum = new int[array.length];
		//��ʼ��
		for(int i = 0; i < leftFirstBiggerNum.length ; i++){
			leftFirstBiggerNum[i] = -1;
		}
		for(int i = 0; i < rightFirstBiggerNum.length; i++){
			rightFirstBiggerNum[i] = -1;
		}
		
		for(int i = 0; i < array.length; i++){
			if(st.isEmpty() || array[st.peek()] > array[i]){
				st.push(i);
			}
			else{
				while(!st.isEmpty() && array[st.peek()] < array[i]){
					int index = st.pop();
					if(!st.isEmpty())
						leftFirstBiggerNum[index] = st.peek();
					rightFirstBiggerNum[index] = i;
					st.push(i);
				}
			}
		}
		while(!st.isEmpty()){
			int index = st.pop();
			if(!st.isEmpty()){
				leftFirstBiggerNum[index] = st.peek();
			}
		}
		
		for(int i = 0; i < array.length; i++){
			System.out.println(leftFirstBiggerNum[i]+" "+ rightFirstBiggerNum[i]);
		}
		
		return root;
	}
	
	//����ͨ��������ͨ��һ������ջ�ҵ�����һ�����ڵ����֣����Ҳ��һ�����ڵ�����
	public static void main(String[] args){
		int[] arr = {1, 3, 6, 9 , 2, 5, 7};
		covertArrayToMaxTree(arr);
	} 
}
