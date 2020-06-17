package e6_shell_sort;

//@author - Eleanor Ezimah

public class ShellSort {

	
 	public static void sort(Comparable[] a)
	     { 
	        int N = a.length;
	        int h = 1;
	        while (h < N/3) h = 3*h + 1; 
	        while (h >= 1)
	        { 
	           for (int i = h; i < N; i++)
	           {  
	              for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
	                 exch(a, j, j-h);
	}
	           	h = h/3; }
	}

	private static boolean less(Comparable comparable, Comparable comparable2) {
		// TODO Auto-generated method stub
		return false;
	}

	private static void exch(Comparable[] a, int j, int i) {
		// TODO Auto-generated method stub
		
	}

}
