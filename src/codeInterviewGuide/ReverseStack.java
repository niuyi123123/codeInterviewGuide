package codeInterviewGuide;

import java.util.Stack;


//将栈中的元素逆序
//使用递归来实现
public class ReverseStack {
	//实现一个函数将栈底的元素取出，其他元素顺序不改变
	public static int getAndRemoveLastElement(Stack<Integer> st){
		int result = st.pop();
		if(st.isEmpty()){
			return result;
		}
		else
		{
			int last = getAndRemoveLastElement(st);
			st.push(result);
			return last;
		}
	}
	//调用getAndRemoveLastElement使得栈中的元素逆序
	public static void reverse(Stack<Integer> st){
		if(st.isEmpty())
			return ;
		int last = getAndRemoveLastElement(st);
		reverse(st);
		st.push(last);
	}
	
	public static void main(String[] args){
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		reverse(st);
		
		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
	}
}
