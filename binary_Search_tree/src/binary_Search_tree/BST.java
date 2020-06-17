package binary_Search_tree;
//@author Eleanor Ezimah

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> { 
	private Node root;             // root of BST

    private class Node {
        private Key emailID;           // sorted by key
        private Value phone;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key emailID, String firstname, String lastname, Value phone, int size) {
            this.emailID = emailID;
            this.phone = phone;
            this.size = size;
        }
    }
    
	    public BST() {
	    }

	    public boolean isEmpty() {
	        return size() == 0;
	    }

	    public int size() {
	        return size(root);
	    }

	    // return number of key-value pairs in BST rooted at x
	    private int size(Node x) {
	        if (x == null) return 0;
	        else return x.size;
	    }


	    public boolean contains(Key emailID) {
	        if (emailID == null) throw new IllegalArgumentException("argument to contains() is null");
	        return get(emailID) != null;
	    }

	    public Value get(Key emailID) {
	        return get(root, emailID);
	    }

	    private Value get(Node x, Key emailID ) {
	        if (emailID == null) throw new IllegalArgumentException("calls get() with a null key");
	        if (x == null) return null;
	        int cmp = emailID.compareTo(x.emailID);
	        if      (cmp < 0) return get(x.left, emailID);
	        else if (cmp > 0) return get(x.right, emailID);
	        else              return x.phone;
	    }
	    
	    public void put(Key emailID, Value phone, String firstname, String lastname) {
	        if (emailID == null) throw new IllegalArgumentException("calls put() with a null key");
	        if (phone == null && firstname == null && lastname == null) {
	            delete(emailID);
	            return;
	        }
	        root = put(root, emailID, phone, firstname, lastname);
	    }
	    

	    private Node put(Node x, Key emailID, Value phone, String firstname, String lastname) {
	        if (x == null) return new Node(emailID, lastname, firstname, phone, 1);
	        int cmp = emailID.compareTo(x.emailID);
	        if      (cmp < 0) x.left  = put(x.left,  emailID, phone, firstname, lastname);
	        else if (cmp > 0) x.right = put(x.right, emailID, phone, firstname, lastname);
	        else              x.phone   = phone;
	        x.size = 1 + size(x.left) + size(x.right);
	        return x;
	    }


	    public Key max() {
	        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
	        return max(root).emailID;
	    } 

	    private Node max(Node x) {
	        if (x.right == null) return x; 
	        else                 return max(x.right); 
	    } 
	    

	    public Key ceiling(Key emailID) {
	        if (emailID == null) throw new IllegalArgumentException("argument to ceiling() is null");
	        if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
	        Node x = ceiling(root, emailID);
	        if (x == null) return null;
	        else return x.emailID;
	    }

	    private Node ceiling(Node x, Key emailID) {
	        if (x == null) return null;
	        int cmp = emailID.compareTo(x.emailID);
	        if (cmp == 0) return x;
	        if (cmp < 0) { 
	            Node t = ceiling(x.left, emailID); 
	            if (t != null) return t;
	            else return x; 
	        } 
	        return ceiling(x.right, emailID); 
	    } 

	    public void deleteMax() {
	        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
	        root = deleteMax(root);
	    }

	    private Node deleteMax(Node x) {
	        if (x.right == null) return x.left;
	        x.right = deleteMax(x.right);
	        x.size = size(x.left) + size(x.right) + 1;
	        return x;
	    }

	    public void deleteMin() {
	        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
	        root = deleteMin(root);
	    }

	    private Node deleteMin(Node x) {
	        if (x.left == null) return x.right;
	        x.left = deleteMin(x.left);
	        x.size = size(x.left) + size(x.right) + 1;
	        return x;
	    }

	    public void delete(Key key) {
	        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
	        root = delete(root, key);
	    }

	    private Node delete(Node x, Key emailID) {
	        if (x == null) return null;

	        int cmp = emailID.compareTo(x.emailID);
	        if      (cmp < 0) x.left  = delete(x.left,  emailID);
	        else if (cmp > 0) x.right = delete(x.right, emailID);
	        else { 
	            if (x.right == null) return x.left;
	            if (x.left  == null) return x.right;
	            Node t = x;
	            x = min(t.right);
	            x.right = deleteMin(t.right);
	            x.left = t.left;
	        } 
	        x.size = size(x.left) + size(x.right) + 1;
	        return x;
	    } 

	    public Key min() {
	        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
	        return min(root).emailID;
	    } 

	    private Node min(Node x) { 
	        if (x.left == null) return x; 
	        else                return min(x.left); 
	    }
	    

	}

 
