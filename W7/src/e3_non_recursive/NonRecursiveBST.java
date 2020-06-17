package e3_non_recursive;

import external_package.StdOut;

//@author - Eleanor Ezimah

public class NonRecursiveBST{
	
	public class BST<Key extends Comparable<Key>, Value> extends e3_non_recursive.BST<Key, Value> {

    public Value get(Key key) {

        Node current = root;

        while (current != null) {
            int compare = key.compareTo(current.key);

            if (compare < 0) {
                current = current.left;
            } else if (compare > 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }

        return null;
    }

    public void put(Key key, Value value) {
        //First pass to check if key already exists 
        boolean keyExists = false;

        Node current = root;

        while (current != null) {
            int compare = key.compareTo(current.key);

            if (compare < 0) {
                current = current.left;
            } else if (compare > 0) {
                current = current.right;
            } else {
                current.val = value;
                keyExists = true;
                break;
            }
        }

        if (keyExists) {
            return;
        }

        //Second pass

        if (root == null) {
            root = new Node(key, value, 1);
            return;
        }

        current = root;

        while (current != null) {

            int compare = key.compareTo(current.key);
            current.size = current.size + 1;

            if (compare < 0) {

                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node(key, value, 1);
                    break;
                }
            } else if (compare > 0) {

                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Node(key, value, 1);
                    break;
                }
            }
        }
    }
}

public static void main(String[] args) {
    NonRecursiveBST nonrecursiveBST = new NonRecursiveBST();
    BST<Integer, String> testofbinarySearchTree = nonrecursiveBST.new BST<>();
    
    System.out.println("@Authour Eleanor Ezimah");
    System.out.println();

    //Test put()
    testofbinarySearchTree.put(37, "Value 37");
    testofbinarySearchTree.put(10, "Value 10");
    testofbinarySearchTree.put(80, "Value 80");
    testofbinarySearchTree.put(1, "Value 1");
    testofbinarySearchTree.put(20, "Value 20");

    StdOut.println();

    //Test size()
    StdOut.println("Size - " + testofbinarySearchTree.size() + " Expected - 5");
    System.out.println();

    //Test get() and keys()
    for(Integer key : testofbinarySearchTree.keys()) {
        StdOut.println("Key " + key + " - " + testofbinarySearchTree.get(key));
    }

}

}
		

