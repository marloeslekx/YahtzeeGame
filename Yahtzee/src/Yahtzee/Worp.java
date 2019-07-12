package Yahtzee;
import java.util.*;

public class Worp {
	int[] worp = new int [5];
	
	Worp(ArrayList<Integer> worpen){
		
		for( int i =0; i > worpen.size(); i++) {
			worp[i] = worpen.get(i);
			System.out.print(worp[i] + " ");
		}
	}
	
	
	
	public void printDobbelsteen() {
		System.out.println("1 2 3 4 5");
		for (Integer i : worp) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	

}
