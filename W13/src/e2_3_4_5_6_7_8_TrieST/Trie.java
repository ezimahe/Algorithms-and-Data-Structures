package e2_3_4_5_6_7_8_TrieST;



import java.util.StringJoiner;

import external_package.Queue;

//Eleanor Ezimah

import external_package.StdOut;

public class Trie{
public static class TrieST<Value> {
	private static int R = 256; // radix
    private Node root;          // root of trie
    private static class Node
    {
       private Object val;
       private Node[] next = new Node[R];
    }
    @SuppressWarnings("unchecked")
	public Value get(String key)
    {
       Node x = get(root, key, 0);
       if (x == null) return null;
       return (Value) x.val;
}
    private Node get(Node x, String key, int d)
    {  // Return value associated with key in the subtrie rooted at x.
       if (x == null) return null;
       if (d == key.length()) return x;
       char c = key.charAt(d); // Use dth key char to identify subtrie.
       return get(x.next[c], key, d+1);
}
    public void put(String key, Value val)
    {  root = put(root, key, val, 0);  }
    private Node put(Node x, String key, Value val, int d)
    {  // Change value associated with key if in subtrie rooted at x.
       if (x == null) x = new Node();
       if (d == key.length()) {  x.val = val; return x; }
       char c = key.charAt(d); // Use dth key char to identify subtrie.
       x.next[c] = put(x.next[c], key, val, d+1);
       return x;
}
    
    public int size()
    {  return size(root);  }
    private int size(Node x)
    {
       if (x == null) return 0;
       int cnt = 0;
       if (x.val != null) cnt++;
       for (char c = 0; c < R; c++)
          cnt += size(x.next[c]);
  return cnt; }
    
    public Iterable<String> keys()
    {  return keysWithPrefix("");  }
    public Iterable<String> keysWithPrefix(String pre)
    {
       Queue<String> q = new Queue<String>();
       collect(get(root, pre, 0), pre, q);
       return q;
  }
    private void collect(Node x, String pre,
                                 Queue<String> q)
    {
       if (x == null) return;
       if (x.val != null) q.enqueue(pre);
       for (char c = 0; c < R; c++)
          collect(x.next[c], pre + c, q);
  }
    
    public Iterable<String> keysThatMatch(String pat)
    {
       Queue<String> q = new Queue<String>();
       collect(root, "", pat, q);
       return q;
  }
    public void collect(Node x, String pre, String pat, Queue<String> q) {
       int d = pre.length();
       if (x == null) return;
       if (d == pat.length() && x.val != null) q.enqueue(pre);
       if (d == pat.length()) return;
       char next = pat.charAt(d);
       for (char c = 0; c < R; c++)
          if (next == '.' || next == c)
             collect(x.next[c], pre + c, pat, q);
  }
  
    public String longestPrefixOf(String s)
  {
     int length = search(root, s, 0, 0);
     return s.substring(0, length);
  }
    private int search(Node x, String s, int d, int length) {
     if (x == null) return length;
     if (x.val != null) length = d;
     if (d == s.length()) return length;
     char c = s.charAt(d);
     return search(x.next[c], s, d+1, length);
}
    
    public void delete(String key)
    {  root = delete(root, key, 0);  }
    private Node delete(Node x, String key, int d)
    {
       if (x == null) return null;
       if (d == key.length())
          x.val = null;
       else
       {
          char c = key.charAt(d);
          x.next[c] = delete(x.next[c], key, d+1);
  }
       if (x.val != null) return x;
       for (char c = 0; c < R; c++)
          if (x.next[c] != null) return x;
       return null;
    }


}

public static void main(String[] args) {
    Trie trie = new Trie();
    trie.trieTests();
}

private void trieTests() {
	StdOut.println("Author - Eleanor Ezimah");
    StdOut.println("Trie Test");
    StdOut.println();
    TrieST<Integer> trieST = new TrieST<>();

    // Put test
    trieST.put("Rene", 0);
    trieST.put("Re", 1);
    trieST.put("Re", 10);
    trieST.put("Algorithms", 2);
    trieST.put("Algo", 3);
    trieST.put("Algor", 4);
    trieST.put("Tree", 5);
    trieST.put("Trie", 6);
    trieST.put("TST", 7);
    trieST.put("Trie123", 8);
    trieST.put("Z-Function", 9);
    
    //size test
    StdOut.println("size()Of Trie:");
        StdOut.println(trieST.size());

    // Get test1
    StdOut.println();
    StdOut.println("GetTest1:");
    StdOut.println("Get Re: " + trieST.get("Re"));
    StdOut.println("Get Algorithms: " + trieST.get("Algorithms"));
    StdOut.println("Get Trie123: " + trieST.get("Trie123"));
    StdOut.println("Get Algori: " + trieST.get("Algori"));
    StdOut.println("Get Zooom: " + trieST.get("Zooom"));
    
    // Get test2
    StdOut.println();
    StdOut.println("GetTest2:");
    StdOut.println("Get TST: " + trieST.get("TST"));
    StdOut.println("Get Algor: " + trieST.get("Algor"));
    StdOut.println("Get Trie123: " + trieST.get("Trie123"));
    StdOut.println("Get Algori: " + trieST.get("Algori"));
    StdOut.println("Get Trie: " + trieST.get("Trie"));
    
    // Keys with prefix tests
    StdOut.println("\nKeys with prefix Alg");
    StringJoiner keysWithPrefix1 = new StringJoiner(" ");

    for(String key : trieST.keysWithPrefix("Alg")) {
        keysWithPrefix1.add(key);
    }
    StdOut.println(keysWithPrefix1.toString());
    StdOut.println("Expected: Algo Algor Algorithms");

    StdOut.println("\nKeys with prefix T");
    StringJoiner keysWithPrefix2 = new StringJoiner(" ");

    for(String key : trieST.keysWithPrefix("T")) {
        keysWithPrefix2.add(key);
    }
    StdOut.println(keysWithPrefix2.toString());
    StdOut.println("Expected: TST Tree Trie Trie123");

    StdOut.println("\nKeys with prefix R");
    StringJoiner keysWithPrefix3 = new StringJoiner(" ");

    for(String key : trieST.keysWithPrefix("R")) {
        keysWithPrefix3.add(key);
    }
    StdOut.println(keysWithPrefix3.toString());
    StdOut.println("Expected: Re Rene");

    StdOut.println("\nKeys with prefix ZZZ");
    StringJoiner keysWithPrefix4 = new StringJoiner(" ");

    for(String key : trieST.keysWithPrefix("ZZZ")) {
        keysWithPrefix4.add(key);
    }
    StdOut.println(keysWithPrefix4.toString());
    StdOut.println("Expected: ");

 // Keys that match tests
    StdOut.println("\nKeys that match Alg..");
    StringJoiner keysThatMatch1 = new StringJoiner("Alg..");

    for(String key : trieST.keysThatMatch("Alg..")) {
        keysThatMatch1.add(key);
    }
    StdOut.println(keysThatMatch1.toString());
    StdOut.println("Expected: Algor");

    StdOut.println("\nKeys that match Re");
    StringJoiner keysThatMatch2 = new StringJoiner(" ");

    for(String key : trieST.keysThatMatch("Re")) {
        keysThatMatch2.add(key);
    }
    StdOut.println(keysThatMatch2.toString());
    StdOut.println("Expected: Re");

    StdOut.println("\nKeys that match Tr.e");
    StringJoiner keysThatMatch3 = new StringJoiner(" ");

    for(String key : trieST.keysThatMatch("Tr.e")) {
        keysThatMatch3.add(key);
    }
    StdOut.println(keysThatMatch3.toString());
    StdOut.println("Expected: Tree Trie");
    
 // Longest-prefix-of tests
	StdOut.println("\nAuthor - Eleanor Ezimah");
	StdOut.println();
    StdOut.println("\nLongest prefix of Re: " + trieST.longestPrefixOf("Re"));
    StdOut.println("Expected: Re");

    StdOut.println("Longest prefix of Algori: " + trieST.longestPrefixOf("Algori"));
    StdOut.println("Expected: Algor");

    StdOut.println("Longest prefix of Trie12345: " + trieST.longestPrefixOf("Trie12345"));
    StdOut.println("Expected: Trie123");

    StdOut.println("Longest prefix of Zooom: " + trieST.longestPrefixOf("Zooom"));
    StdOut.println("Expected: ");
    
    
    // Delete tests
	StdOut.println("\nAuthor - Eleanor Ezimah");
	StdOut.println();
    trieST.delete("Z-Function");

    StdOut.println("\nKeys() after deleting Z-Function key");
    for(String key : trieST.keys()) {
        StdOut.println(key);
    }

    trieST.delete("Rene");

    StdOut.println("\nKeys() after deleting Rene key");
    for(String key : trieST.keys()) {
        StdOut.println(key);
    }

    trieST.delete("Re");

    StdOut.println("\nKeys() after deleting Re key");
    for(String key : trieST.keys()) {
        StdOut.println(key);
    }
}


}


