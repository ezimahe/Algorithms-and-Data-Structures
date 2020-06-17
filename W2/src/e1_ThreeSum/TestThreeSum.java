package e1_ThreeSum;

import java.math.BigInteger;

//@author Eleanor Ezimah

public class TestThreeSum {
	public static void main(String[] args) {

		int test1; 
		int test2; 
		int test3; 
		int[] arrayTest1 = {1000, -10000, 67000}; 
		int[] arrayTest2 = {321222, -98463, 34543};
		int[] arrayTest3 = {700, 7000000, -200000}; 
		
		System.out.println("Author: Eleanor Ezimah");
		System.out.println();
		
		
		test1 = AddThreeBigNumbers(arrayTest1);
		System.out.println("Test1 : " + test1  );
		System.out.println();
		
		test2 = AddThreeBigNumbers(arrayTest2);
		System.out.println("Test2: " + test2  );
		System.out.println();
		
		test3 = AddThreeBigNumbers(arrayTest3);
		System.out.println("Test3: " + test3  );
	}


	public static int AddThreeBigNumbers(int [] a) {
		int threeSumTotal = 0;
		
		ThreeSum threesum = new ThreeSum();
		threeSumTotal = threesum.count(a);
		
		return threeSumTotal;
		
	}

}
