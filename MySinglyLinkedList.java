package homework1;

public class MySinglyLinkedList<E> implements Cloneable {
	
	// nested node class
	private static class Node<E> {
		
		private E element;		// references element stored at this node
		private Node<E> next;	// references next node in list
		
		// methods
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() {return element;}
	
		public Node<E> getNext() {return next;}
		
		public void setNext(Node<E> n) {next = n;}
	}
	
	private Node<E> head = null;	// first node
	private Node<E> tail = null;	// last node
	private int size = 0;			// number of elements (nodes) in list
	
	// constructor
	public MySinglyLinkedList() {}
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size == 0;}
	
	// returns first element
	public E first() {				
		if (isEmpty()) return null;
		return head.getElement();
	}
	
	// returns last element
	public E last() {				
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	// adds element "e" to front of list
	public void addFirst(E e) {		
		head = new Node<>(e, head);		// create and link new node
		
		// if only 1 element in list...
		if (size == 0)
			tail = head;	// tail becomes head also
		size++;
	}
	
	// adds element "e" to end of list
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);	// node will become tail
		if (isEmpty())
			head = newest;
		else
			tail.setNext(newest);	// new node after existing tail
		tail = newest;				// new node becomes tail
		size++;
	}
	
	// removes and returns first element
	public E removeFirst() {
		if (isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		
		if (size == 0)
			tail = null;
		return answer;
	}
	
	@SuppressWarnings({"unchecked"})
	public boolean equals(Object o) {
		if (o == null) return false;
		if (getClass() != o.getClass()) return false;
		
		MySinglyLinkedList<E> other = (MySinglyLinkedList<E>) o;
		if (size != other.size) return false;
		Node<E> walkA = head;							// traverse primary list
		Node<E> walkB = other.head;					// traverse secondary list
		
		while (walkA != null) {
			if (!walkA.getElement().equals(walkB.getElement())) return false;
			
			// mismatch
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;	// reach this --> everything matched
	}
	
	@SuppressWarnings({"unchecked"})
	public MySinglyLinkedList<E> clone() throws CloneNotSupportedException {
		MySinglyLinkedList<E> other = (MySinglyLinkedList<E>) super.clone();
		
		// independent chain of nodes
		if (size > 0) {
			other.head = new Node<>(head.getElement(), null);
			Node<E> walk = head.getNext();
			Node<E> otherTail = other.head;
			
			// make new node storing the same element
			while (walk != null) {
				Node<E> newest = new Node<>(walk.getElement(), null);
				otherTail.setNext(newest);	// link the previous node to this node
				otherTail = newest;
				walk = walk.getNext();
			}
		}
		return other;
	}
	
	public int hashCode() {
		int h = 0;
		for (Node<E> walk = head; walk != null; walk = walk.getNext()) {
			h ^= walk.getElement().hashCode();
			h = (h << 5) | (h >>> 27);
		}
		return h;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		Node<E> walk = head;
		
		while (walk != null) {
			sb.append(walk.getElement());
			if (walk != tail)
				sb.append(", ");
			walk = walk.getNext();
		}
		sb.append(")");
		return sb.toString();
	}
}




