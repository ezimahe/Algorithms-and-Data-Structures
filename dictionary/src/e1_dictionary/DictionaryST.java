package e1_dictionary;
//@author Eleanor Ezimah
import java.util.NoSuchElementException;
import external_package.Queue;
import external_package.StdDraw;
import external_package.StdOut;

public class DictionaryST <Key extends Comparable<Key>, Value> {
	private Node root;             // root of BST

    private class Node {
        private Key word;           // sorted by word
        private Value definition;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree
        private double xCoordinate, yCoordinate;

        public Node(Key word, Value definition, int size) {
            this.word = word;
            this.definition = definition;
            this.size = size;
        }
    }
    private int treeLevel;

    public DictionaryST() {
    }

 
    public boolean isEmpty() {
        return size() == 0;
    }


    public int size() {
        return size(root);
    }

    // return number of word-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }


    public boolean contains(Key word) {
        if (word == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(word) != null;
    }

    public Value get(Key word) {
        return get(root, word);
    }

    private Value get(Node x, Key word) {
        if (word == null) throw new IllegalArgumentException("calls get() with a null word");
        if (x == null) return null;
        int cmp = word.compareTo(x.word);
        if      (cmp < 0) return get(x.left, word);
        else if (cmp > 0) return get(x.right, word);
        else              return x.definition;
    }


    public void put(Key word, Value definition) {
        if (word == null) throw new IllegalArgumentException("calls put() with a null word");
        if (definition == null) {
            delete(word);
            return;
        }
        root = put(root, word, definition);
        assert check();
    }

    private Node put(Node x, Key word, Value definition) {
        if (x == null) return new Node(word, definition, 1);
        int cmp = word.compareTo(x.word);
        if      (cmp < 0) x.left  = put(x.left,  word, definition);
        else if (cmp > 0) x.right = put(x.right, word, definition);
        else              x.definition   = definition;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }


    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }


    public void delete(Key word) {
        if (word == null) throw new IllegalArgumentException("calls delete() with a null word");
        root = delete(root, word);
        assert check();
    }

    private Node delete(Node x, Key word) {
        if (x == null) return null;

        int cmp = word.compareTo(x.word);
        if      (cmp < 0) x.left  = delete(x.left,  word);
        else if (cmp > 0) x.right = delete(x.right, word);
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
        return min(root).word;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 


    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).word;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 

 
    public Key floor(Key word) {
        if (word == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, word);
        if (x == null) return null;
        else return x.word;
    } 

    private Node floor(Node x, Key word) {
        if (x == null) return null;
        int cmp = word.compareTo(x.word);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, word);
        Node t = floor(x.right, word); 
        if (t != null) return t;
        else return x; 
    } 

    public Key floor2(Key word) {
        return floor2(root, word, null);
    }

    private Key floor2(Node x, Key word, Key best) {
        if (x == null) return best;
        int cmp = word.compareTo(x.word);
        if      (cmp  < 0) return floor2(x.left, word, best);
        else if (cmp  > 0) return floor2(x.right, word, x.word);
        else               return x.word;
    } 


    public Key ceiling(Key word) {
        if (word == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Node x = ceiling(root, word);
        if (x == null) return null;
        else return x.word;
    }

    private Node ceiling(Node x, Key word) {
        if (x == null) return null;
        int cmp = word.compareTo(x.word);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, word); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, word); 
    } 


    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        Node x = select(root, k);
        return x.word;
    }

    // Return word of rank k. 
    private Node select(Node x, int k) {
        if (x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 


    public int rank(Key word) {
        if (word == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(word, root);
    } 

    // Number of keys in the subtree less than word.
    private int rank(Key word, Node x) {
        if (x == null) return 0; 
        int cmp = word.compareTo(x.word); 
        if      (cmp < 0) return rank(word, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(word, x.right); 
        else              return size(x.left); 
    } 


    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }


    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.word); 
        int cmphi = hi.compareTo(x.word); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.word); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 


    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }


    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }


    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.word);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }


    private boolean check() {
        if (!isBST())            StdOut.println("Not in symmetric order");
        if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent()) StdOut.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.word.compareTo(min) <= 0) return false;
        if (max != null && x.word.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.word) && isBST(x.right, x.word, max);
    } 

    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(root); }
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    } 

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key word : keys())
            if (word.compareTo(select(rank(word))) != 0) return false;
        return true;
    }
    public void draw() {
        treeLevel = 0;
        setCoordinates(root, 0.9);

        StdDraw.setPenColor(StdDraw.BLACK);
        drawLines(root);
        drawNodes(root);
    }

    private void setCoordinates(Node node, double distance) {
        if (node == null) {
            return;
        }

        setCoordinates(node.left, distance - 0.05);
        node.xCoordinate = (0.5 + treeLevel++) / size();
        node.yCoordinate = distance - 0.05;
        setCoordinates(node.right, distance - 0.05);
    }

    private void drawLines(Node node) {
        if (node == null) {
            return;
        }

        drawLines(node.left);

        if (node.left != null) {
            StdDraw.line(node.xCoordinate, node.yCoordinate, node.left.xCoordinate, node.left.yCoordinate);
        }
        if (node.right != null) {
            StdDraw.line(node.xCoordinate, node.yCoordinate, node.right.xCoordinate, node.right.yCoordinate);
        }

        drawLines(node.right);
    }

    private void drawNodes(Node node) {
        if (node == null) {
            return;
        }

        double nodeRadius = 0.032;

        drawNodes(node.left);

        StdDraw.setPenColor(StdDraw.WHITE);
        //Clear the node circle area
        StdDraw.filledCircle(node.xCoordinate, node.yCoordinate, nodeRadius);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.circle(node.xCoordinate, node.yCoordinate, nodeRadius);
        StdDraw.text(node.xCoordinate, node.yCoordinate, String.valueOf(node.word));

        drawNodes(node.right);
    }

    public static void main(String[] args) { 
        DictionaryST<String, String> testDictionary = new DictionaryST<String, String>();
        
        System.out.println("@Authour Eleanor Ezimah");
        System.out.println();
        
      //Test put()
        testDictionary.put("Variable", "Names a data-type value");
        testDictionary.put("Operator", "Names a data-type operation");
        testDictionary.put("Literal", "Source-code representation of a value");
        testDictionary.put("Expression", "A literal, a variable, or a sequence of operations on literals and/or variables that produces a value");
        testDictionary.put("Assignment", "Assign a data-type value to a variable");
        testDictionary.put("Declaration", "Create a variable of a specified type, named with a given identifier");
        testDictionary.put("Floor", "Largest integer not greater than x");
        testDictionary.put("Ceiling", "Smallest integer not smaller than x");
        testDictionary.put("Size", "Number of key-value pairs");
        testDictionary.put("Select", "Key of rank k");
        testDictionary.put("Max", "Largest key");
        testDictionary.put("Insert", "Insert a key into the priority queue");
        testDictionary.put("Constant", "A program whose running time’s order of growth is constant executes a fixed number of operations to finish its job");
        testDictionary.put("Linear", "Programs that spend a constant amount of time processing each piece of input data, or that are based on a single for loop");
        testDictionary.put("Logarithmic", "A program whose running time’s order of growth is logarithmic is barely slower than a constant-time program");

        StdOut.println();
        //test find a word
        testDictionary.get("Select");
        testDictionary.get("Insert");
        
        
        //Test size()
        StdOut.println("Size: " + testDictionary.size() + " Expected: 15");

        //Test get() and keys()
        for(String word : testDictionary.keys()) {
            StdOut.println("Word: " + word + "; Definition: " + testDictionary.get(word));
        }

        System.out.println();
        System.out.println("\n@Authour Eleanor Ezimah");
        System.out.println();
        
        //Test delete()
        StdOut.println("\nDelete word Linear");
        System.out.println();
        testDictionary.delete("Linear");
        for(String word : testDictionary.keys()) {
            StdOut.println("Key " + word + ": " + testDictionary.get(word));
        }

        StdOut.println();

        //Test size()
        StdOut.println("Size: " + testDictionary.size() + " Expected: 14");

        //Test min()
        StdOut.println("Min word: " + testDictionary.min() + " Expected: Assignment");

        //Test max()
        StdOut.println("Max word: " + testDictionary.max() + " Expected: Variable");

        //Test floor()
        StdOut.println("Floor of Size: " + testDictionary.floor("Size") + " Size");
        StdOut.println("Floor of Linear: " + testDictionary.floor("Linear") + " Linear");

        //Test ceiling()
        StdOut.println("Ceiling of Size: " + testDictionary.ceiling("Size") + " Size");
        StdOut.println("Ceiling of Linear: " + testDictionary.ceiling("Linear") + " Literal");

        //Test select()
        StdOut.println("Select Word of rank 4: " + testDictionary.select(4) + " Expected: Expression");

        //Test rank()
        StdOut.println("Rank of Word Size: " + testDictionary.rank("Size") + " Expected: 12");
        StdOut.println("Rank of Word Linear: " + testDictionary.rank("Linear") + " Expected: 7");

        //Test deleteMin()
        StdOut.println("\nDelete min");

        testDictionary.deleteMin();
        for(String key : testDictionary.keys()) {
            StdOut.println("Key " + key + ": " + testDictionary.get(key));
        }

        //Test deleteMax()
        StdOut.println("\nDelete max");

        testDictionary.deleteMax();
        for(String key : testDictionary.keys()) {
            StdOut.println("Key " + key + ": " + testDictionary.get(key));
        }

        StdOut.println("Size: " + testDictionary.size() + " Expected: 12");
    
    }
}

