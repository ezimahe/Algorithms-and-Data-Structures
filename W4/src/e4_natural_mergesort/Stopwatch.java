package e4_natural_mergesort;
//@author Mihai Boicu - Reference

public class Stopwatch {
		
		/**
		 * The time in ms when the watch was started. -1 if not yet started.
		 */
		private long startTime;
		
		/**
		 * The time in ms when the watch was stopped. -1 if not yet stopped.
		 */	
		private long stopTime;
		
		/**
		 * Create a stop watch not yet started. 
		 */
		public StopWatch() {
			this.startTime = -1;
			this.stopTime = -1;
		}
		
		/**
		 * Start the stop watch
		 * @throws RuntimeException if already started
		 */
		public void start() {
			if (this.startTime>0) {
				throw new RuntimeException("Stopwatch already started.");
			}
			this.startTime = System.currentTimeMillis();
		}
		
		/**
		 * Stop the stop watch
		 * @throws RuntimeException if already stopped
		 */	
		public void stop() {
			if (this.stopTime>0) {
				throw new RuntimeException("Stopwatch already stopped.");
			}
			this.stopTime = System.currentTimeMillis();
		}
		
		/**
		 * Compute the elapsed time in miliseconds.
		 * @return the elapsed time in miliseconds.
		 */
		public long elapsedTimeInMiliseconds() {
			if (this.startTime<0) {
				throw new RuntimeException("Stopwatch not started.");
			}
			if (this.stopTime<0) {
				throw new RuntimeException("Stopwatch not stopped.");
			}		
			return this.stopTime-this.startTime;
		}
	 	
		/**
		 * Compute the elapsed time in seconds.
		 * @return the elapsed time in seconds.
		 */
		public double elapsedTimeInSeconds() {
			if (this.startTime<0) {
				throw new RuntimeException("Stopwatch not started.");
			}
			if (this.stopTime<0) {
				throw new RuntimeException("Stopwatch not stopped.");
			}		
			return (this.stopTime-this.startTime)/1000.0;
		}
	 		

	}

