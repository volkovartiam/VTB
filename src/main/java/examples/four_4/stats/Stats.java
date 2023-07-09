package examples.four_4.stats;

public class Stats<T extends Number> {

	private T[] nums;
	
	public Stats(T... nums ) {
		this.nums = nums;
	}
	
	public double avg() {
		double sum = 0.0;
		for (int i = 0; i < nums.length; i++) {
			//sum = sum + nums[i];
			sum = sum + nums[i].doubleValue();
		}
		return sum/ nums.length;
	}
	
	/*
	public boolean sameAvg(Stats<T> another) {
		return Math.abs(this.avg() - another.avg() ) < 0.0001;
	}
	*/

	public boolean sameAvg(Stats<?> another) {
		return Math.abs(this.avg() - another.avg() ) < 0.0001;
	}
	
	
}
