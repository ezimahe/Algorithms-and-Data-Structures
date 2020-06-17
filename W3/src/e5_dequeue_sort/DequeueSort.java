package e5_dequeue_sort;

public class DequeueSort {
	public static void main(String[] args) {
		String[] suit = {"S", "C", "H", "D"};
		String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] deck = new String[52];
 
		
		for (int i = 0; i < deck.length; i++) {
			deck[i] = rank[i%13] + suit[i/13];
		}
		
		for (int i = 0; i < deck.length; i++) {
			int index = (int)(Math.random()* deck.length);
			
			String temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;

		}
		
		for (String c: deck) {
			System.out.println(c);
		}
		
	}
		   public static void shellSort(String[] c)
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
		   public static void insertionSort(String [] c)
		     {  
		        int N = a.length;
		        for (int i = 1; i < N; i++)
		        {  
		           for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
		              exch(a, j, j-1);
		} }
		   public static void selectionSort(String [] c)
		     { 
		        int N = a.length;             
		        for (int i = 0; i < N; i++)
		        {  
		           int min = i;                
		           for (int j = i+1; j < N; j++)
		              if (less(a[j], a[min])) min = j;
		           exch(a, i, min);
		} }
		
}

}
