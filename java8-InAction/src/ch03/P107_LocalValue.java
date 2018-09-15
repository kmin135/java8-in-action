package ch03;

public class P107_LocalValue {
	static int staticValue = 33;
	int instanceValue = 77;
	public static void main(String[] args) {
		P107_LocalValue instance = new P107_LocalValue();
		int portNumber = 1337;
		Runnable r = () -> {
			System.out.println(staticValue);
			System.out.println(instance.instanceValue);
			System.out.println(portNumber);
		};
		r.run();
		
		staticValue = 333;
		instance.instanceValue = 777;
		
//		지역변수는 final로 선언되거나 실질적으로 final처럼 취급되어야 한다.
//		람다 생성 후 지역변수값을 수정하기 때문에 아래의 주석을 풀면 컴파일 오류가 발생한다.
//		portNumber = 3306;
		
		r.run();
	}
}
