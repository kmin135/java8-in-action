package ch03;

public class Apple {
	private int weight;
	private String color;
	
	public Apple() {
		this(0);
	}
	public Apple(int weight) {
		this(weight, "red");
	}
	public Apple(int weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + "]";
	}
	
}
