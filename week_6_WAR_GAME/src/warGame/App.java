package warGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
	static Scanner scan = new Scanner(System.in);
	
	public static List<Player>getPlayers(Scanner scan){
		List<Player>players = new ArrayList<Player>(2);
		for(int index = 0;index < 2;index++) {
			System.out.printf("Enter Player %d name: ", index+1);
			String name = scan.nextLine();
			if((name == null)||(name.isEmpty())) {
				name = String.format(name);
			}
			Player player = new Player(name);
			players.add(player);
		}
		return players;
	}
	
	
	public static void main(String[]args) {
		List<Player>players = getPlayers(scan);
		Player player1 = players.get(0);
		Player player2 = players.get(1);
		Deck deck = new Deck();
		deck.shuffle();
		player1.draw(deck);
		player2.draw(deck);
		
		System.out.println();
		System.out.println(player1.getName() + " is playing " + player2.getName());
		System.out.println("MAY THE WAR COMMENCE!");
		System.out.println("_______________________________________");
		
		//Iterates 26 rounds of War between Players.
		
		for(int counter = 0; counter < 26; counter++) { 
			Card player1Card = player1.flip();
			Card player2Card = player2.flip();
			
			if(player1Card.getValue() > player2Card.getValue()) {
				System.out.println();
				System.out.println(player1.getName() + "'s Card: "+ player1Card.describe());
				System.out.println(player2.getName() + "'s Card: "+ player2Card.describe());
				System.out.println(player1.getName() + " gets a point!!");
				player1.incrementScore();
				System.out.println(player1.getName() + "'s Score: "+player1.getScore());
				System.out.println(player2.getName() + "'s Score: "+player2.getScore());
				System.out.println("_______________________________________");
			}
			else if(player1Card.getValue() < player2Card.getValue()) {
				System.out.println();
				System.out.println(player1.getName() + "'s Card: "+ player1Card.describe());
				System.out.println(player2.getName() + "'s Card: "+ player2Card.describe());
				System.out.println(player2.getName() + " gets a point!!");
				player2.incrementScore();
				System.out.println(player1.getName() + "'s Score: "+player1.getScore());
				System.out.println(player2.getName() + "'s Score: "+player2.getScore());
				System.out.println("_______________________________________");
			}
			else {
				System.out.println(player1.getName() + "'s Card: "+ player1Card.describe());
				System.out.println(player2.getName() + "'s Card: "+ player2Card.describe());
				System.out.println("No one wins this Battle! Draw!!!");
				System.out.println(player1.getName() + "'s Score: "+player1.getScore());
				System.out.println(player2.getName() + "'s Score: "+player2.getScore());
				System.out.println("_______________________________________");
			}
		}
		
		System.out.println(player1.getName() + "'s Score: "+player1.getScore());
		System.out.println(player2.getName() + "'s Score: "+player2.getScore());
		
		
		if(player1.getScore() > player2.getScore()) {
			System.out.println(player1.getName() + " is the winner!!!");
		}
		else if(player1.getScore() < player2.getScore()) {
			System.out.println(player2.getName() + " is the winner!!!");
		}
		else {
			System.out.println("Tie!! There is no winners in this War!!");
		}
	} 
}