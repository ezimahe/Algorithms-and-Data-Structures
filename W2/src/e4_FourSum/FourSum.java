package e4_FourSum;

import java.util.Arrays;

//@Author Eleanor Ezimah
public class FourSum {


		public int count(int[] a) {
			Arrays.sort(a);
			System.out.println(Arrays.toString(a));
			int count = 0;
			int size = a.length;
			for(int i = 0; i<size;i++) {
				for(int j = i+1; j<size; j++) {
					for(int k = j+1; k<size; k++) {
						for(int l = k+1; l<size; l++) {
							if(a[i] + a[j] + a[k] + a[l] == 0) {
								System.out.println(a[i] + " + " + a[j] + " + "  + a[k] + " + " + a[l] + " = 0");
								count++;
							}
						}
					}
				}
			}
			
			return count;
		}
	}

