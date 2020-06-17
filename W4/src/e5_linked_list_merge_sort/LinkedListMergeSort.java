package e5_linked_list_merge_sort;
import java.util.Random;
//@author Eleanor Ezimah
public class LinkedListMergeSort {


	    public static class Node {
	        Comparable val;
	        Node next;
	        Node(Comparable x) { val = x; }
	        public String toString() {
	            Node current = this;
	            StringBuilder sb = new StringBuilder();
	            while (current != null) {
	                sb.append(current.val + " ");
	                current = current.next;
	            }
	            return sb.toString();
	        }
	    }
	    public static class RandomQueue<Item> implements Iterable<Item> {
	        Item[] items;
	        int N;

	        public RandomQueue() {
	            items = (Item[]) new Object[4];
	            N = 0;
	        }
	        public boolean isEmpty() { return N == 0; }
	        public int size() { return N; }
	        public void enqueue(Item item) {
	            items[N++] = item;
	            if (items.length == N) {
	                resize(items.length * 2);
	            }
	        }
	        public Item dequeue() {
	            if (isEmpty()) throw new java.util.NoSuchElementException("Cannot dequeue from empty queue");
	            int r = StdRandom.uniform(0, N);
	            Item item = items[r];
	            items[r] = items[--N];
	            if (N < items.length / 4 && items.length > 4) {
	                resize(items.length / 2);
	            }
	            return item;
	        }
	    public static class MergeList {
	        // Get Node with min value and make it head of list
	        private static Node getMin(Node a) {
	            Comparable minVal = a.val;
	            Node current = a;
	            Node minNode = null;
	            while (current.next != null) {
	                if (less(current.next.val, minVal)) {
	                    minNode = current;
	                    minVal = current.next.val;
	                }
	                current = current.next;
	            }
	            if (minNode == null) return a;
	            // Node with min value is minNode.next
	            Node tmp = minNode.next.next;
	            Node actualMinNode = minNode.next;
	            actualMinNode.next = a;
	            minNode.next = tmp;
	            return actualMinNode;
	        }
	        public static Node sort(Node a) {
	            // Get minimum node
	            a = getMin(a);
	            Node root = a;
	            while (true) {
	                Node lo = root.next;
	                Node mid = lo;
	                while (mid.next != null && !less(mid.next.val, mid.val)) {
	                    mid = mid.next;
	                }
	                if (mid.next == null) {
	                    if (root == a) return a;  // sorted
	                    root = a;
	                    continue;
	                }
	                Node hi = mid.next;
	                while (hi.next != null && !less(hi.next.val, hi.val))
	                    hi = hi.next;
	                merge(root, lo, mid, hi);
	                if (hi.next == null) {
	                    if (root == a) return a;  // sorted
	                    root = a;
	                } else {
	                    root = hi;
	                }
	            }
	        }
	        public static void merge(Node root, Node lo, Node mid, Node hi) {
	            Node curLeft = lo;
	            Node curRight = mid.next;
	            Node curRoot = root;
	            Node stopLeft = mid.next;
	            Node stopRight = hi.next;
	            while (curLeft != stopLeft|| curRight != stopRight) {
	                if (curLeft == stopLeft) {
	                    curRoot.next = curRight;
	                    curRight = curRight.next;
	                } else if (curRight == stopRight) {
	                    curRoot.next = curLeft;
	                    curLeft = curLeft.next;
	                } else if (less(curLeft.val, curRight.val)) {
	                    curRoot.next = curLeft;
	                    curLeft = curLeft.next;
	                } else {
	                    curRoot.next = curRight;
	                    curRight = curRight.next;
	                }
	                curRoot = curRoot.next;
	            }
	            curRoot.next = stopRight;
	        }
	        private static boolean less(Comparable v, Comparable w) {
	            return v.compareTo(w) < 0;
	        }
	        public static boolean isSorted(Node a) {
	            while (a.next != null) {
	                if (less(a.next.val, a.val)) return false;
	                a = a.next;
	            }
	            return true;
	        }
	    }
	    public static void main(String[] args) {
	        int n = 30;
	        Random r = new Random();
	        Node head = new Node(n);
	        Node current = head;
	        RandomQueue<Integer> rq = new RandomQueue();
	        for (int i = 0; i < n; i++) {
	            rq.enqueue(i);
	        }
	        for (int i = 0; i < n; i++) {
	            Node next = new Node(rq.dequeue());
	            current.next = next;
	            current = next;
	        }
	        System.out.println(head);
	        head = MergeList.sort(head);
	        System.out.println(head);

	        for (int t = 0; t < 100; t++) {
	            head = new Node(r.nextInt());
	            current = head;
	            for (int i = 0; i < n; i++) {
	                Node next = new Node(r.nextInt());
	                current.next = next;
	                current = next;
	            }
	            head = MergeList.sort(head);
	            if (!MergeList.isSorted(head)) System.out.printf("We have a problem");
	        }
	    }
	    }
}
	

