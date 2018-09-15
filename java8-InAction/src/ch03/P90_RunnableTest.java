package ch03;

public class P90_RunnableTest {
	public static void main(String[] args) {
		Runnable r1 = () -> System.out.println("Hello World 1");
		
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World 2");
			}
		};
		
		run(r1);
		run(r2);
		run(() -> System.out.println("Hello World 3"));
	}
	
	public static void run(Runnable r) {
		r.run();
	}
}
