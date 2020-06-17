package e5_random_key;
//@author - Eleanor Ezimah
import external_package.StdOut;
import external_package.StdRandom;


public class RandomKey {
	public class BST<Key extends Comparable<Key>, Value> extends e5_random_key.BST<Key, Value> {
	 public Key randomKey() {
         if (isEmpty()) {
             return null;
         }

         int randomIndex = StdRandom.uniform(size());
         return select(randomIndex);
     }
 }

 public static void main(String[] args) {
     RandomKey randomkey = new RandomKey();
     BST<Integer, String> binaryST = randomkey.new BST<>();

     //Test put()
     binaryST.put(7, "Value 7");
     binaryST.put(100, "Value 100");
     binaryST.put(8, "Value 8");
     binaryST.put(10, "Value 10");
     binaryST.put(2, "Value 2");
     

     //Test size(), get() and keys()
     System.out.println("@Authour Eleanor Ezimah");
     System.out.println();

     StdOut.println("Size - " + binaryST.size() + " Expected - 5");
     System.out.println();
     
     for(Integer key : binaryST.keys()) {
         StdOut.println("Key " + key + " - " + binaryST.get(key));
     }

     StdOut.println("\nRandom keys:");
     StdOut.println(binaryST.randomKey());
     StdOut.println(binaryST.randomKey());
     StdOut.println(binaryST.randomKey());
     StdOut.println(binaryST.randomKey());
     StdOut.println(binaryST.randomKey());
 }

}
