package e6_merging_sorted_queue;
//@author Eleanor Ezimah
import e6_merging_sorted_queue.Queue;

public class MergingSortedQueue {

	public static Queue<Item> mergeQ(Queue<Item> a, Queue<Item> b) {
        Queue<Item> q = new Queue();
        while (!a.isEmpty() || !b.isEmpty()) {
            if (a.isEmpty()) q.enqueue(b.dequeue());
            else if (b.isEmpty()) q.enqueue(a.dequeue());
            else if (a.peek().compareTo(b.peek()) < 0) q.enqueue(a.dequeue());
            else q.enqueue(b.dequeue());
        }
        return q;
    }

}


