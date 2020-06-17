package e4_FourSum;
//@Author Eleanor Ezimah

public class TestFourSum {

		public static void main(String[] args) {

			System.out.println("Author: Eleanor Ezimah");
			int[] myArray1 = generateRandomArray(5);
			TestFourSum(myArray1,"Test Scenario 1");
			SkipLine();
			
			int[] myArray2 = generateRandomArray(10);
			TestFourSum(myArray2,"Test Scenario 2");
		}
		
		public static void TestFourSum(int[] a, String s) {
			
			System.out.println("s");
			int count;
			FourSum myFourSum = new FourSum();
			count = myFourSum.count(a);
			
			System.out.println(s + " Total Four Sums : " + count);
		}
		
		
		public static int[] generateRandomArray(int size) {
			int[] randomArray = new int[size];
			int minValue = -10;
			int maxValue = 10;
			
			for(int i=0;i<size; i++) {
				randomArray[i] = minValue + (int) (Math.random() * (maxValue-minValue +1));
			}
			return randomArray;
		}
		
		public static void SkipLine() {
			System.out.println();
		}

	}


