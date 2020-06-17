package e6_merging_sorted_queue;
//@author Eleanor Ezimah
public class TestMergingSortedQueue {
	public static void main(String[] args) {
        Queue<Item> a = new Queue<>();
        Queue<Item> b = new Queue<>();
        int n = 20;
        int cura = 0;
        int curb = 0;
        Random r = new Random();
        while (--n > 0) {
            cura += r.nextInt(3);
            curb += r.nextInt(3);
            a.enqueue(cura);
            b.enqueue(curb);
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(mergeQ(a, b));
    }
}
