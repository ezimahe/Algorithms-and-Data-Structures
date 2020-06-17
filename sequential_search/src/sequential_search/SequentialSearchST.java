package sequential_search;
//@ Author - Eleanor Ezimah

public class SequentialSearchST<Key extends Comparable<Key>, Value>  {
	private int n;
	private Node first; // first node in the linked list
	
	private class Node {  // linked-list node
	Key key;
	Value val;
	Node next;
	public Node(Key key, Value val, Node next) {
		  this.key  = key;
		  this.val  = val;
		  this.next = next;
		}
	}
	
	public Value get(Key key) { // Search for key, return associated value.
		   for (Node x = first; x != null; x = x.next)
		       if (key.equals(x.key))
		            return x.val;    
		        return null;          
		}
		    	    
	public void put(Key key, Value val){ // Search for key. Update value if found; grow table if new.
		    for (Node x = first; x != null; x = x.next)
		        if (key.equals(x.key))
		           {  x.val = val; return;  }     
		        first = new Node(key, val, first); 
		     }
		     
	public Key min() { //smallest key
		   Node min = first;
		   for(Node x = first; x != null; x = x.next) {
		    	if(x.key.compareTo(min.key) < 0)
		    			 min = x;
		    	 }
		    	 return min.key;
		     }
		     
	public Key max() { //largest key
		   Node max = first;
		   for(Node x = first; x != null; x = x.next) {
		    	if(x.key.compareTo(max.key) > 0)
		    			 max = x;
		    	 }
		    	 return max.key;
		     }
	
	public Key floor(Key key) { //largest key less than or equal to key
		   Key tempMax = first.key;
		   for(Node current = first; current!=null; current = current.next) {
			   if(key.compareTo(current.key) > 0) {
				   if(current.key.compareTo(tempMax) > 0)
					   tempMax = current.key;
			   }
		   }	 
		    	 return tempMax;
		    	
		     }
	public Key ceiling(Key key) { //smallest key greater than or equal to key
		Key tempMin = first.key;
		   for(Node current = first; current!=null; current = current.next) {
			   if(key.compareTo(current.key) < 0) {
				   if(current.key.compareTo(tempMin) < 0)
					   tempMin = current.key;
			   }
		   }	 
		    	 return tempMin;
    	}
		     	     
	public int rank(Key key) { //number of keys less than key
		    if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		    int count = 0;
		    for(Node x = first; x != null; x = x.next) {
		    	if(x.key.compareTo(key) > 0);
		    		 count++;
		    		 
		    	 }
		    	 return count;
		     }
	
	public Key select (int k) { //key of rank k
			Node current = first;
				for(int i = 0; i<k; k++) {
							current = current.next;
		}
					return current.key;
        
    	}
	
	public void delete(Key key) { 
	    	if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
	         	first = delete(first, key);
	     }
	
	public void deleteMin() { //delete smallest key
			delete(this.min());
		}
	
	public void deleteMax() { //delete largest key
			delete(this.max());
		}

    
	public int size(Key lo, Key hi) { //number of keys between lo and hi
			int size = 0;
			for(Node x = first; x != null; x = x.next) {
				if (x.key.compareTo(lo) > 0 && x.key.compareTo(hi) < 1)
					size++;
			
		}
   	 
			return size;
    	}
	private Node delete(Node x, Key key) {
		    if (x == null) return null;
		    if (key.equals(x.key)) {
		         n--;
		             return x.next;
		         }
		         x.next = delete(x.next, key);
		         return x;
		     }

	public boolean isEmpty() {
		     return size() == 0;
		     }

	public int size() {
			return n;
	}

	public boolean contains(Key key) {
		   if (key == null) throw new IllegalArgumentException("argument to contains() is null");
		       return get(key) != null;
		     }

		     
}
