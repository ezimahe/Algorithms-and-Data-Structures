package e6_merging_sorted_queue;
// @author Mihai Boicu - Reference
public interface Queue<Item> {
		
		/**
		 * Add an item to the queue.
		 * @param item The added item
		 */
		public void enqueue(Item item);
		
		/**
		 * Remove an item from the queue, the least recently added item.
		 * @return The removed item
		 */
		public Item dequeue();	
		
		/**
		 * Check if the queue is empty.
		 * @return true if the queue is empty.
		 */
		public boolean isEmpty();
		
		/**
		 * Return the number of items in the queue.
		 * @return the size of the queue
		 */
		public int size();
		
		/**
		 * Return a string representation of the queue using toString for each item, in the format:
		 * [least-recent-item, item2, ... most-recent-item]
		 * @return a string representation of the queue
		 */
		public String toString();

	}

