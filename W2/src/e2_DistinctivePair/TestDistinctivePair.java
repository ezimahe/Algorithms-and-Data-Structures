package e2_DistinctivePair;
import java.util.Arrays;
// @author Eleanor Ezimah
public class TestDistinctivePair {
	


		public static void main(String[] args) {

			System.out.println("Author: E;eanor Ezimah");
			System.out.println();
			
			int[] arrayTest1 = {1,2,3,4,5};
			CreateDistinctivePair("Test  1",arrayTest1);
			SkipLine();

			int[] arrayTest2 = {1,1,1};
			CreateDistinctivePair("Test  2",arrayTest2);
		}

		public static void CreateDistinctivePair(String s,int[] a) {
			
			System.out.println(s);
			System.out.println(Arrays.toString(a));
			int numberOfPairs;
			
			DistinctivePair distinct = new DistinctivePair();
			numberOfPairs = distinct.DistinctivePair(a);
			if(numberOfPairs == 0) {
				System.out.println("There are no distinctive pairs");
			}
			else
			{
				
				System.out.println("Total distinctive pairs: " +numberOfPairs);
			}
			
			
			
		}
		public static void SkipLine() {
			System.out.println();
		}

	}


