package codeInterviewGuide;

import java.util.Stack;

//本质上也是一道单调栈的题目
public class MaximumMatrixArea {
	
	public int getMaxArea(int[] height){
		int maxRes = 0;
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < height.length; i++){
			if(st.isEmpty() || height[st.peek()] < height[i] ){
				st.push(i);
			}
			else
			{
				while(!st.isEmpty() && height[i] < height[st.peek()]){
					int highPosi = st.pop();
					int leftMargin = st.isEmpty()?0:st.peek();
					int area = (i - leftMargin) * height[highPosi];
					if(area > maxRes)
						maxRes = area;
				}
				st.push(i);
			}
		}
		while(!st.isEmpty()){
			int highPosi = st.pop();
			int leftMargin = st.isEmpty()?0:st.peek();
			int area = (height.length-1 - leftMargin) * height[highPosi];
			if(area > maxRes)
				maxRes = area;
		}
		return maxRes;
	}
	
	public int getMaxMatrixArea(int[][] matrix){
		int maxRes = 0;
		if(matrix.length == 0 || matrix[0].length == 0)
			return maxRes;
		int[] height = new int[matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				height[j] = matrix[i][j] == 0?0:height[j] + matrix[i][j];
			}
			int res = getMaxArea(height);
			if(res > maxRes)
				maxRes = res ;
		}
		return maxRes;
	}
	
	public static void main(String[] args){
		int[][] matrix = {
				{1, 0, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 1, 0}
		};
		MaximumMatrixArea m = new MaximumMatrixArea();
		System.out.println(m.getMaxMatrixArea(matrix));
	}
}
