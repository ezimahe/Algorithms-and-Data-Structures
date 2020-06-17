package e1_brute_force_substring_search;

import external_package.StdOut;

//Eleanor Ezimah
public class Brute {

	    // return offset of first match or n if no match
	    public static int search1(String pat, String txt) {
	        int m = pat.length();
	        int n = txt.length();

	        for (int i = 0; i <= n - m; i++) {
	            int j;
	            for (j = 0; j < m; j++) {
	                if (txt.charAt(i+j) != pat.charAt(j))
	                    break;
	            }
	            if (j == m) return i;            // found at offset i
	        }
	        return n;                            // not found
	    }

	    // return offset of first match or N if no match
	    public static int search2(String pat, String txt) {
	        int m = pat.length();
	        int n = txt.length();
	        int i, j;
	        for (i = 0, j = 0; i < n && j < m; i++) {
	            if (txt.charAt(i) == pat.charAt(j)) j++;
	            else {
	                i -= j;
	                j = 0;
	            }
	        }
	        if (j == m) return i - m;    // found
	        else        return n;        // not found
	    }


	    // return offset of first match or n if no match
	    public static int search1(char[] pattern, char[] text) {
	        int m = pattern.length;
	        int n = text.length;

	        for (int i = 0; i <= n - m; i++) {
	            int j;
	            for (j = 0; j < m; j++) {
	                if (text[i+j] != pattern[j])
	                    break;
	            }
	            if (j == m) return i;            // found at offset i
	        }
	        return n;                            // not found
	    }

	    // return offset of first match or n if no match
	    public static int search2(char[] pattern, char[] text) { 
	        int m = pattern.length;
	        int n = text.length;
	        int i, j;
	        for (i = 0, j = 0; i < n && j < m; i++) {
	            if (text[i] == pattern[j]) j++;
	            else {
	                i -= j;
	                j = 0;
	            }
	        }
	        if (j == m) return i - m;    // found
	        else        return n;        // not found
	    } 

	    public static void main(String[] args) {
	    	System.out.println("Author - Eleanor Ezimah");
	    	System.out.println("Brute Test");
	        
	        System.out.println("\nTest1");
	        testBrute( "abracadabra ","abacadabrabracabracadabrabrabracad");
	        System.out.println("\nTest2");
	        testBrute( "rab","abacadabrabracabracadabrabrabracad");
	        System.out.println("\nTest3");
	        testBrute( "rabrabracad","abacadabrabracabracadabrabrabracad");
	        System.out.println("\nTest4");
	        testBrute( "bcara","abacadabrabracabracadabrabrabracad");
	        System.out.println("\nTest5");
	        testBrute( "abacad","abacadabrabracabracadabrabrabracad");
	        
	    }
	        
	    public static void testBrute(String pat, String txt)
	    {	   
	        char[] pattern = pat.toCharArray();
	        char[] text    = txt.toCharArray();

	        int offset1a = search1(pat, txt);
	        int offset2a = search2(pat, txt);
	        int offset1b = search1(pattern, text);
	        int offset2b = search2(pattern, text);

	        // print results
	        StdOut.println("text:    " + txt);
	        
	        // from brute force search method 1a
	        StdOut.print("pattern: ");
	        for (int i = 0; i < offset1a; i++)
	            StdOut.print(" ");
	        StdOut.println(pat);

	        // from brute force search method 2a
	        StdOut.print("pattern: ");
	        for (int i = 0; i < offset2a; i++)
	            StdOut.print(" ");
	        StdOut.println(pat);

	        // from brute force search method 1b
	        StdOut.print("pattern: ");
	        for (int i = 0; i < offset1b; i++)
	            StdOut.print(" ");
	        StdOut.println(pat);

	        // from brute force search method 2b
	        StdOut.print("pattern: ");
	        for (int i = 0; i < offset2b; i++)
	            StdOut.print(" ");
	        StdOut.println(pat);
	        

	        
	       
	    }
	}