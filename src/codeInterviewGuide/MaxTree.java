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
	//构建这棵树应该当遵守以下两个原则：
	//每一个数的父节点是它的左边第一个比它大的 数字和右边第一个比它大的数字中，较小的那个
	// 如果一个数字左边没有比它大的数，右边也没有。那这个数字是这棵树中最大的一个数字，也就是这棵树的根节点
	public static Node covertArrayToMaxTree(int[] array){
		Node root = null;
		Stack<Integer> st = new Stack<Integer>();
		int[] leftFirstBiggerNum = new int[array.length];
		int[] rightFirstBiggerNum = new int[array.length];
		//初始化
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
	
	//测试通过，可以通过一个单调栈找到左侧第一个大于的数字，和右侧第一个大于的数字
	public static void main(String[] args){
		int[] arr = {1, 3, 6, 9 , 2, 5, 7};
		covertArrayToMaxTree(arr);
	} 
}
