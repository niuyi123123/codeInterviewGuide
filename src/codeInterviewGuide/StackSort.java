package codeInterviewGuide;

import java.util.Stack;

//ʹ��ջ����
//����ʹ�ö����һ��ջ

public class StackSort {
	public static void sortStack(Stack<Integer> st){
		Stack<Integer> help = new Stack<Integer>();
		
		while(!st.isEmpty()){
			int cur = st.pop();
			if(help.isEmpty() || (!help.isEmpty() && cur <= help.peek())){
				help.push(cur);
			}
			else{
				while(!help.isEmpty() && help.peek() < cur){
					st.push(help.pop());
				}
				help.push(cur);
			}
		}
		while(!help.isEmpty()){
			st.push(help.pop());
		}
	}
	
	public static void main(String[] args){
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(9);
		st.push(4);
		st.push(3);
		st.push(2);
		
		sortStack(st);

		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
	}
}
