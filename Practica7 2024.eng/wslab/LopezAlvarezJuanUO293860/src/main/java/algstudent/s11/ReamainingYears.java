package algstudent.s11;


public class ReamainingYears {
	public static void main(String[] args) {
		long max = Long.MAX_VALUE;
		long currentTime = System.currentTimeMillis();

		long yearMillis = 365L * 24 * 60 * 60 * 1000;

		long remainingYears2 = (max-currentTime)/yearMillis;
		System.out.println("There are " + remainingYears2 + " years remaining of currentTimeMillis()");

	}

}
