package OGP2.Proeftoets;

import java.util.Scanner;

public class Recursie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Recursie();
	}

	public Recursie() {

		String value;
		Scanner scanner = new Scanner(System.in);
		boolean stop = false;
		while (!stop) {
			value = scanner.nextLine();
			if (value.equals("end"))
				stop = true;
			else
				permuteer("", value);

		}
	}

	public void permuteer(String prefix, String value) {
		int n = value.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++) {
				permuteer(prefix + value.charAt(i), value.substring(0, i) + value.substring(i + 1, n));
			}
		}
	}

}
