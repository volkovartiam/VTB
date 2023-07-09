package examples.four_4.stats;

public class StatsDemoApp {

	public static void main(String[] args) {

		Stats<Integer> intStats = new Stats<>(1, 2, 3, 4, 5, 6);
		System.out.println("Average = " + intStats.avg() );

		Stats<Integer> intAnotherStats = new Stats<>(1, 2, 3, 4, 5, 6);
		System.out.println("Average = " + intAnotherStats.avg() );


		Stats<Double> doubleStats = new Stats<>(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		System.out.println("Average = " + doubleStats.avg() );

		/*
		Mistake by compilation
		Stats<String> strStats = new Stats<>("1", "2", "3", "4", "5", "6");
		*/
		
		if(intStats.sameAvg(doubleStats) ) {
		//if(intStats.sameAvg(intAnotherStats) ) {
			System.out.println("Averages is equals");
		} else {
			System.out.println("Averages is NOT equals");
		}
	}

}
