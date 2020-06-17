package e2_DistinctivePair;

	import java.util.Arrays;
//@Author Eleanor Ezimah

	public class DistinctivePair {

		public int DistinctivePair(int[] array) {
			int count = 0;
			Arrays.sort(array);
			int initialValuePair;
			
			for(int i =0;i<array.length;i++) {
				initialValuePair = array[0];
				int previousIvalue = 0;
				if(i>0) {
					previousIvalue = i-1;
				}
				for(int j =i+1;j<array.length;j++) {
					if(array[i] != array[j] && array[j] != array[j-1] ) {
						if(array[i] != array[previousIvalue] || i==0) {
							if(count==0) {
								System.out.println("Here are the list of distinctive pairs");
							}
							System.out.println(array[i] + " and " + array[j] + " are pairs");
							count++;
						}

					}
				}
			}
			return count;
		}
	}

