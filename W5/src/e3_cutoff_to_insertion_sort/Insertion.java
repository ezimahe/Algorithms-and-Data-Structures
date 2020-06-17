package e3_cutoff_to_insertion_sort;
// Referenced from the textbook website
import java.util.Comparator;

public class Insertion {
	   private Insertion() { }

	 
	    public static void sort(Comparable[] a) {
	        int n = a.length;
	        for (int i = 1; i < n; i++) {
	            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
	                exch(a, j, j-1);
	            }
	            assert isSorted(a, 0, i);
	        }
	        assert isSorted(a);
	    }

	 
	    public static void sort(Comparable[] a, int lo, int hi) {
	        for (int i = lo + 1; i < hi; i++) {
	            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
	                exch(a, j, j-1);
	            }
	        }
	        assert isSorted(a, lo, hi);
	    }

	  
	    public static void sort(Object[] a, Comparator comparator) {
	        int n = a.length;
	        for (int i = 1; i < n; i++) {
	            for (int j = i; j > 0 && less(a[j], a[j-1], comparator); j--) {
	                exch(a, j, j-1);
	            }
	            assert isSorted(a, 0, i, comparator);
	        }
	        assert isSorted(a, comparator);
	    }

	   
	    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
	        for (int i = lo + 1; i < hi; i++) {
	            for (int j = i; j > lo && less(a[j], a[j-1], comparator); j--) {
	                exch(a, j, j-1);
	            }
	        }
	        assert isSorted(a, lo, hi, comparator);
	    }


	    public static int[] indexSort(Comparable[] a) {
	        int n = a.length;
	        int[] index = new int[n];
	        for (int i = 0; i < n; i++)
	            index[i] = i;

	        for (int i = 1; i < n; i++)
	            for (int j = i; j > 0 && less(a[index[j]], a[index[j-1]]); j--)
	                exch(index, j, j-1);

	        return index;
	    }

	   
	    // is v < w ?
	    private static boolean less(Comparable v, Comparable w) {
	        return v.compareTo(w) < 0;
	    }

	    // is v < w ?
	    private static boolean less(Object v, Object w, Comparator comparator) {
	        return comparator.compare(v, w) < 0;
	    }
	        
	    // exchange a[i] and a[j]
	    private static void exch(Object[] a, int i, int j) {
	        Object swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }

	    // exchange a[i] and a[j]  (for indirect sort)
	    private static void exch(int[] a, int i, int j) {
	        int swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }

	    private static boolean isSorted(Comparable[] a) {
	        return isSorted(a, 0, a.length);
	    }

	    // is the array a[lo..hi) sorted
	    private static boolean isSorted(Comparable[] a, int lo, int hi) {
	        for (int i = lo + 1; i < hi; i++)
	            if (less(a[i], a[i-1])) return false;
	        return true;
	    }

	    private static boolean isSorted(Object[] a, Comparator comparator) {
	        return isSorted(a, 0, a.length, comparator);
	    }

	    // is the array a[lo..hi) sorted
	    private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
	        for (int i = lo + 1; i < hi; i++)
	            if (less(a[i], a[i-1], comparator)) return false;
	        return true;
	    }

	   // print array to standard output
	    private static void show(Comparable[] a) {
	        for (int i = 0; i < a.length; i++) {
	            StdOut.println(a[i]);
	        }
	    }

	    public static void main(String[] args) {
	        String[] a = StdIn.readAllStrings();
	        Insertion.sort(a);
	        show(a);
	    }
	}


