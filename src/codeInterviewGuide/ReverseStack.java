package codeInterviewGuide;

import java.util.Stack;


//��ջ�е�Ԫ������
//ʹ�õݹ���ʵ��
public class ReverseStack {
	//ʵ��һ��������ջ�׵�Ԫ��ȡ��������Ԫ��˳�򲻸ı�
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
	//����getAndRemoveLastElementʹ��ջ�е�Ԫ������
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
