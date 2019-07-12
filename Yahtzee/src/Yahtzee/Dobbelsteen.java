package Yahtzee;

import java.util.Random;

public class Dobbelsteen {
	int dobbelsteen;

	public Integer werpen() {
		Random random = new Random();
		dobbelsteen = random.nextInt(6) + 1;
		return dobbelsteen;
	}

}
