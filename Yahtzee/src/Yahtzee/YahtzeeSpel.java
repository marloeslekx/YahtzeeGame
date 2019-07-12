package Yahtzee;

import java.util.*;

public class YahtzeeSpel {

	ArrayList<Integer> dobbelstenen = new ArrayList<>();
	int[] blokkeerArray = new int[5];
	Dobbelsteen worp = new Dobbelsteen();
	Scanner scanner = new Scanner(System.in);
	String gebruikerInput;
	int aantalWorp = 1;
	static int aantalSpelers;
	ArrayList<Speler> spelers = new ArrayList<>();

	YahtzeeSpel() {
		for (int i = 0; i < 5; i++) {
			dobbelstenen.add(i + 1);
		}
	}

	void spelen() {
		System.out.println("Welcome to Yahtzee, press enter to play");
		String gebruikerInput = null;
		boolean spelAan = true;
		gebruikerInput = scanner.nextLine();
		while (spelAan) {
			spelerToevoegen();
			for (int i = 0; i < aantalSpelers; i++) {
				System.out.println("Player " + (i + 1) + " press enter to roll the five dices");
				gebruikerInput = scanner.nextLine();
				werpDobbelsteen();
				vasthouden();
				werpDobbelsteen(blokkeerArray);
				vasthouden();
				werpDobbelsteen(blokkeerArray);
				spelers.get(i).addWorpGeschiedenis(new Worp(dobbelstenen));
				resultaat();
				aantalWorp = 1;
			}
			System.out.println("Would you like to play again? (y/n)");
			gebruikerInput = scanner.nextLine();
			if ("n".equals(gebruikerInput)) {
				spelAan = false;
			}
		}
	}

	private void resultaat() {
		if (dobbelstenen.get(0) == dobbelstenen.get(1) && dobbelstenen.get(0) == dobbelstenen.get(2)
				&& dobbelstenen.get(0) == dobbelstenen.get(3) && dobbelstenen.get(0) == dobbelstenen.get(4)) {
			System.out.println("YAHTZEE!");
		} else {
			System.out.println("You lose\n");
		}

	}

	private void vasthouden() {

		System.out.println("Which dices would you like to hold?");
		gebruikerInput = scanner.nextLine();
		for (int i = 0; i < gebruikerInput.length(); i++) {
			int k = Integer.parseInt(gebruikerInput);
			int j = Integer.parseInt(Integer.toString(k).substring(i, i + 1));
			switch (j) {
			case 1:
				blokkeerArray[0] = 1;
				break;
			case 2:
				blokkeerArray[1] = 1;
				break;
			case 3:
				blokkeerArray[2] = 1;
				break;
			case 4:
				blokkeerArray[3] = 1;
				break;
			case 5:
				blokkeerArray[4] = 1;
				break;
			default:
				break;
			}

		}
		System.out.println("");
	}

	private void werpDobbelsteen() {
		System.out.println("Throw " + aantalWorp);
		int index = 0;
		for (Integer element : dobbelstenen) {
			Integer cijfer = worp.werpen();
			dobbelstenen.set(index, cijfer);
			index++;
		}
		printDobbelsteen();
		aantalWorp++;

	}

	private void werpDobbelsteen(int[] blokkeer) {
		System.out.println("Throw " + aantalWorp);
		for (int i = 0; i < dobbelstenen.size(); i++) {
			if (blokkeer[i] == 0) {
				Integer cijfer = worp.werpen();
				dobbelstenen.set(i, cijfer);
			} else {

				blokkeer[i] = 0;
			}
		}
		printDobbelsteen();
		aantalWorp++;
	}

	private void printDobbelsteen() {
		System.out.println("1 2 3 4 5");
		for (Integer i : dobbelstenen) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public void spelerToevoegen() {
		System.out.println("With how many players would you like to play?");
		gebruikerInput = scanner.nextLine();
		aantalSpelers = Integer.parseInt(gebruikerInput);
		for (int i = 0; i < aantalSpelers; i++) {
			spelers.add(new Speler());
		}
	}
}
