import java.util.Random;


public class Random_Example {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int randomNum = random.nextInt(100); // returns any number between(0-99) and inclusive.

		System.out.println(randomNum);
	}

}
