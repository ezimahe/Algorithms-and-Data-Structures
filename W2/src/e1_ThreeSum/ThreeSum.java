package e1_ThreeSum;

import java.math.BigInteger;

// @author Eleanor Ezimah

public class ThreeSum {
	public int count(int[] a) {
		int N = a.length;
		int count = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N;j++) {
				for(int k=j+1; k<N;k++) {
					BigInteger sumOfThree = BigInteger.valueOf(0);
					sumOfThree = sumOfThree.add(BigInteger.valueOf(a[i]));
					sumOfThree = sumOfThree.add(BigInteger.valueOf(a[j]));
					sumOfThree = sumOfThree.add(BigInteger.valueOf(a[k]));

					if(sumOfThree == BigInteger.valueOf(0)) {
						count++;
						if(count==1) {
							System.out.println("Following Combinations equal to zero:");
						}
						System.out.println(a[i] + " + " + a[j] +  " + " + a[k] +
								" = 0" );
					}
				}
			}
		}
		return count;
	}
}
