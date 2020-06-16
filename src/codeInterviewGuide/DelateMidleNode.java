package codeInterviewGuide;

public class DelateMidleNode {
	class Node {
		public int value ;
		public Node next;
		Node(int date)
		{
			this.value = date;
		}
	}
	
	public void removeMiddleNode(Node head)  {
		if(head == null || head.next == null)
			return;
		Node fastPoint = head;
		Node slowPoint = head;
		while(fastPoint.next != null && fastPoint.next.next != null){
			fastPoint = fastPoint.next.next;
			slowPoint = slowPoint.next;
		}
		slowPoint.value = slowPoint.next.value;
		slowPoint.next = slowPoint.next.next;
	}
	
	public void bianli(Node head){
		Node point = head;
		while(point != null){
			System.out.println(point.value);
			point = point.next;
		}
	}
	
	public static void main(String[] args){
		DelateMidleNode dl = new DelateMidleNode();
		Node node1 = dl.new Node(1);
		Node node2 = dl.new Node(2);
		Node node3 = dl.new Node(3);
		Node node4 = dl.new Node(4);
		Node node5 = dl.new Node(5);
		Node node6 = dl.new Node(6);
		Node node7 = dl.new Node(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		dl.removeMiddleNode(node1);
		dl.bianli(node1);
	}
}
