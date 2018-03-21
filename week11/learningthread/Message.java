package week11.learningthread;

public class Message implements Runnable {

	private String name;
	
	public Message(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println(name + " " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
