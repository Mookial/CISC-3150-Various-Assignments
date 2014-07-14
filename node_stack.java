import java.util.NoSuchElementException;

public class EStack<T> extends Node<T> {
	class Node<T> {
		public T nodeValue;
		public Node<T> next;
		
		public Node() {}
		
		public Node(T nodeValue, Node<T> next){
			this.nodeValue = nodeValue;
			this.next = next;
		}
	}
		private Node<T> head;
		private int size;
		
		public void push(T val) {
			head = new Node(val, head);
			size++;
		}
		
		public T pop() {
			if(empty()) { 
				throw new NoSuchElementException();
			}
			
			else {
				T temp = head.nodeValue;
				head = head.next;
				size--;
				return temp;
			}
		}
		
		public T top() {
			if(empty()) { 
				throw new NoSuchElementException(); 
			}
			else { 
				return head.nodeValue;
			}
		}
		
		public boolean empty() {
			return head == null;
		}
    
	public static void main(String args[]) {
		EStack e = new EStack();
		
		for(int i = 0; i < 5; i++)
			s.push(i);
			
		System.out.println(s.top());
		System.out.println(s.pop());
		System.out.println(s.top());
	}
}
