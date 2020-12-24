package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
	private int integer;
	public ThreadedGreeter(int integer) {
		this.integer = integer;
	}

	@Override
	public void run() {
		System.out.println(integer);
		if(integer<=50) {
			Thread t = new Thread(new ThreadedGreeter(integer+1));
			t.start();
		}
	}

}
