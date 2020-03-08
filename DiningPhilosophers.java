package pratice;

public class DiningPhilosophers {

	Philosopher[] phils = new Philosopher[5];
	Chopsticks[] chops = new Chopsticks[5];

	// Details about the chopsticks the philosophers can use.
	public class Chopsticks {

		public boolean taken;
		public String name;

		public Chopsticks(String name) {
			this.name = name;
		}

		public synchronized void take() {
			System.out.println(name + " taken");
			this.taken = true;
		}

		public synchronized void putBack() {
			System.out.println(name + " put back");
			this.taken = false;
		}
	}

	// The philosophers that will dine
	public class Philosopher extends Thread {

		private Chopsticks leftchop;
		private Chopsticks rightchop;
		public int hunger = 10;
		public boolean full = false;
		private int i = 0;
		private String nombre;

		// Gives the Philosophers a name and sets what chopsticks are to their left and
		// right.
		public Philosopher(String name, Chopsticks left, Chopsticks right) {
			nombre = name;
			leftchop = left;
			rightchop = right;
		}

		// what the philosopher threads are set to do during execution
		public void run() {
			try {
				do {
					if (full == true) {
						think();
					} else if (leftchop.taken && rightchop.taken) {
						eat();
					} else if (!leftchop.taken && !rightchop.taken) {
						leftchop.take();
						System.out.println("left taken " + leftchop.name);
						rightchop.take();
						System.out.println("right taken " + rightchop.name);
					} else {
						try {
							this.sleep(3000);
						} catch (InterruptedException ie) {
							ie.printStackTrace();
						}
					}
				} while (true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// When the philosophers have both chopsticks this method is called
		public void eat() {

			while (i < hunger) {
				i++;
				System.out.println("Philosophers " + nombre + "'s i is " + i);
				System.out.println("Philosopher " + nombre + " is eating");
			}

			// when full will set the boolean full to true and put back chopsticks.
			if (i == 10) {
				leftchop.putBack();
				rightchop.putBack();
				full = true;
			}

		}

		// philosophers wait/think after they are full from eating
		public void think() {
			try {
				Thread.sleep(10000);
				System.out.println("Philosopher " + nombre + " is thinking.");
				full = false;
				i = 0;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// Initializes the chopsticks and the philosophers, as well as start the
	// threads.
	public void ArrayOfThreads() {
		for (int i = 0; i < chops.length; i++) {
			chops[i] = new Chopsticks("chop up " + i);
		}
		phils[0] = new Philosopher("Philosopher " + 0, chops[0], chops[1]);
		phils[1] = new Philosopher("Philosopher " + 1, chops[1], chops[2]);
		phils[2] = new Philosopher("Philosopher " + 2, chops[2], chops[3]);
		phils[3] = new Philosopher("Philosopher " + 3, chops[3], chops[4]);
		phils[4] = new Philosopher("Philosopher " + 4, chops[4], chops[0]);

		for (int i = 0; i < phils.length; i++) {
			phils[i].start();
		}
	}

	public static void main(String[] args) {

		DiningPhilosophers dp = new DiningPhilosophers();
		dp.ArrayOfThreads();

	}

}