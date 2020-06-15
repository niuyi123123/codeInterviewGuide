package codeInterviewGuide;

import java.util.LinkedList;

//array��ʾ�������飬w��ʾwindow�ĳ���
public class MaximumInWindow {
	public static int[] getMaxmumInWindow(int[] array, int w){
		//ά��һ���������������ֵ
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[array.length - w + 1];
		int index = 0;
		for(int i = 0; i<array.length; i++){
			while(!qmax.isEmpty() && array[qmax.peekLast()] <= array[i]){
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst() == i-w)
				qmax.pollFirst();
			if(i >= w-1){
//				System.out.println(index);
				res[index++] = array[qmax.peekFirst()];
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] array = {1, 2, 55, 12, 31, 2, 1};
		int[] res ;
		res = getMaxmumInWindow( array, 3);
		for(int num: res){
			System.out.println(num);
		}
	}
}
