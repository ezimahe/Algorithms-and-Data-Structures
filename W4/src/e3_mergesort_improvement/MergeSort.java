package e3_mergesort_improvement;
//@author Eleanor Ezimah
import java.util.Arrays;
import java.util.Random;

public class MergeSort {


	    public static class Merge {
	        public static void sort(Comparable[] a) {
	            Comparable[] aux = new Comparable[a.length];
	            for (int i = 0; i < a.length; i++) {
	                aux[i] = a[i];
	            }
	            sort(a, aux, 0, a.length - 1, 0);
	        }

	        private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi, int depth) {
	            if (depth %2 == 1) {
	                Comparable[] tmp = a;
	                a = aux;
	                aux = a;
	            }
	            if (hi - lo < 16) {
	                for (int i = lo + 1; i <= hi; i++) {
	                    for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
	                        Comparable tmp = a[j];
	                        a[j] = a[j - 1];
	                        a[j - 1] = tmp;
	                    }
	                }
	            } else {
	                int mid = lo + (hi - lo) / 2;
	                sort(a, aux, lo, mid, depth + 1);
	                sort(a, aux, mid + 1, hi, depth + 1);
	                if (aux[mid].compareTo(aux[mid + 1]) > 0)
	                    merge(a, aux, lo, mid, hi, depth);
	            }
	        }

	        public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi, int depth) {
	            int i = lo, j = mid + 1;
	            for (int k = lo; k <= hi; k++) { 
	                if (i > mid) {
	                    a[k] = aux[j++];
	                } else if (j > hi) {
	                    a[k] = aux[i++];
	                } else if (less(aux[j], aux[i])) {
	                    a[k] = aux[j++];
	                }
	                else {
	                    a[k] = aux[i++];
	                }
	            }
	        }

	        private static boolean less(Comparable v, Comparable w) {
	            return v.compareTo(w) < 0;
	        }
	    }

	    public static boolean isSorted(Comparable[] a) {
	        for (int i = 1; i < a.length; i++)
	            if (a[i].compareTo(a[i-1]) < 0) return false;
	        return true;
	    }

	    public static void main(String[] args) {
	    	System.out.println("Author: Eleanor Ezimah");
	    	System.out.println();
	        // Test a reverse sorted array
	        Integer[] nums = new Integer[20];
	        for (int i = 0; i < nums.length; i++)
	            nums[i] = nums.length - i;
	        Merge.sort(nums);
	        System.out.println(Arrays.toString(nums));

	        // Test random arrays
	        Random r = new Random();
	        for (int n = 10; n < 1000; n++) {
	            Integer[] a = new Integer[n];
	            for (int i = 0; i < n; i++)
	                a[i] = r.nextInt(n);
	            Merge.sort(a);
	            if (!isSorted(a)) System.out.println("Error.");
	        }
	    }
	}
