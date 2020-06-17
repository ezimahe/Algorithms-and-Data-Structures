package e4_natural_mergesort;
//@autho - Eleanor Ezimah

import java.util.Arrays;
import java.util.Random;

public class NaturalMergeSort {
	
	    public static class MergeBUN {
	        public static void sort(Item[] a) {
	            int N = a.length;
	            Item[] aux = new Item[N];
	            while (true) {
	                for (int lo = 0; lo < N - 2; lo++) {
	                    int mid = lo;
	                    while (mid < N - 2 && !less(a[mid+1], a[mid]))
	                        mid++;
	                    int hi = mid + 1;
	                    while (hi < N - 1 && !less(a[hi+1], a[hi]))
	                        hi++;
	                    merge(a, aux, lo, mid, hi);
	                    if (hi - lo == N - 1) return;
	                    lo = hi;
	                }
	            }
	        }
	        public static void merge(Item[] a, Item[] aux, int lo, int mid, int hi) {
	            int i = lo, j = mid + 1;
	            for (int k = lo; k <= hi; k++)  
	                aux[k] = a[k];
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
	        private static boolean less(Item v, Item w) {
	            return v.compareTo(w) < 0;
	        }
	        public static boolean isSorted(Item[] a) {
	            for (int i = 1; i < a.length; i++)
	                if (less(a[i], a[i-1])) return false;
	            return true;
	        }
	    }

	    public static class MergeBU {
	        public static void sort(Item[] a) {
	            int N = a.length;
	            Item[] aux = new Item[N];
	            for (int sz = 1; sz < N; sz = sz+sz)
	                for (int lo = 0; lo < N-sz; lo += sz+sz)
	                    merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
	        }
	        public static void merge(Item[] a, Item[] aux, int lo, int mid, int hi) {
	           
	            int i = lo, j = mid + 1;
	            for (int k = lo; k <= hi; k++)  
	                aux[k] = a[k];
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
	        private static boolean less(Item v, Item w) {
	            return v.compareTo(w) < 0;
	        }
	        public static boolean isSorted(Item[] a) {
	            for (int i = 1; i < a.length; i++)
	                if (less(a[i], a[i-1])) return false;
	            return true;
	        }
	    }

	    
	}

}
