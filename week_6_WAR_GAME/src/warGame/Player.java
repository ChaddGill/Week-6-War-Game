package warGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card>hand;
	private int score;
	private String name;
	final int topCard = 0;
	
	public Player(String name) {
		hand = new ArrayList<Card>();
		setScore(0);
		setName(name);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// gets player name
	 
	
	public void describe() {
		System.out.println("Player Name: "+getName());

	}
	
	
	  //returns top card or flip card
	 
	
	public Card flip() {
		Card cardFlipped = hand.get(topCard);
		hand.remove(topCard);
		return cardFlipped;
	}
	
	
	 // Takes Deck as an argument and calls the draw method on the deck,
	 // adding the returned Card to the hand field.
	 
	
	public void draw(Deck deck) {
		for(int index = 1; index <= 26; index++) {
			Card card = deck.draw();
			hand.add(card);
		}
	}
	
	
	  // Adds 1 to the score
	
	
	public void incrementScore() {
		score++;
	}
}
