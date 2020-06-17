package e2_faster_merge;

//@author Eleanor Ezimah
import java.util.Arrays;
import java.util.Random;

public class FasterMerge {
	
	public static class Merge {
        public static void sort(Comparable[] a) {
            Comparable[] aux = new Comparable[a.length];  
            sort(a, aux, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
            // Sort a[lo....hi].
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);         
            sort(a, aux, mid + 1, hi);     
            merge(a, aux, lo, mid, hi);    
        }

        public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
         
            int i = lo, j = hi;
            for (int k = lo; k <= mid; k++)
                aux[k] = a[k];
            for (int k = hi; k > mid; k--)
                aux[mid + 1 + hi - k] = a[k];
            for (int k = lo; k <= hi; k++) {
                if (less(aux[i], aux[j]))
                    a[k] = aux[i++];
                else
                    a[k] = aux[j--];
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }

    public static void main(String[] args) {
    	System.out.println("Author : Eleanor Ezimah");
    	System.out.println();
        int n = 30;
        Integer[] a = new Integer[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n);
        }
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }

	}
