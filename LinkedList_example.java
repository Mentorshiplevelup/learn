package Chapter1;

public class LinkedList_example{
	Node head ;
	
	static class Node{
		String key ;
		int data ;
		Node next ;
		
		Node(String k ,int V){
			key=k ;
			data=V ;
			next=null ;
		}
	}
	
	public static LinkedList_example insert(LinkedList_example list,String key,int data) {
		Node new_node = new Node(key,data) ;
		new_node.next=null ;
		int flag=0 ;
		if(list.head==null) {
			list.head=new_node ;
		}
		else {
			Node last =list.head ;
			
			while(last.next!=null) {
				if(last.key==key) {
					flag=1 ;
				}
				last=last.next ;
			}
			
			if(flag==0) {
				last.next=new_node ;
			}
			
		}
		
		return list ;
	}
	
	public static void printList(LinkedList_example list)
	{
		Node currNode=list.head ;
		System.out.println("LinkedList is : "); 
		
		while(currNode!=null) {
			System.out.println("Key : "+currNode.key+ "  ||   Data : "+currNode.data);
			currNode=currNode.next ;
		}
	}
	public static void main(String[] args) {
		LinkedList_example list = new LinkedList_example() ;
		
		list.insert(list,"sanj",1) ;
		list.insert(list,"anil", 2) ;
		list.insert(list,"sud",3) ;
		list.insert(list,"sanj",4) ;
		
		printList(list) ;
		
	}
}