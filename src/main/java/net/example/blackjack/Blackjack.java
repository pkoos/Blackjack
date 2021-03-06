package net.example.blackjack;

import java.util.Random;

public class Blackjack {
	final Deck cards;
	final Player human, dealer;
	private boolean keepGoing = true;

	public Blackjack() {
		cards = new Deck(new Random());
		human = new Player("Player");
		dealer = new Player("Dealer");
	}

	public void play() {
		cards.shuffle();
		cards.deal(2, human, dealer);
		human.checkHand(human.hand);
		playerLoop();
		dealerLoop();
		System.out.println(calculateWinner(human, dealer) + " wins!");
	}

	private void playerLoop() {
		while ((!over21(human) && this.getKeepGoing())) {
			human.hitOrStand(cards, this);
		}
	}

	private boolean over21(Player player) {
		return player.getPlayerScore() > 21;
	}

	private void dealerLoop() {
		keepGoing = true;
		for(Card c : dealer.hand) {
			if(c != null) {
				dealer.addToPlayerScore(c.getCardValue());
			}
		}
		while (keepGoing) {
			if (dealer.getPlayerScore() > 16) {
				dealer.stand(this);
			} else {
				dealer.hit(cards.getTopCard());
			}
		}

	}

	private String calculateWinner(Player p1, Player p2) {
		if (p1.getPlayerScore() > p2.getPlayerScore()) {
			return p1.name;
		} else {
			return p2.name;
		}
	}

	public void setKeepGoing(boolean keepGoing) {
		this.keepGoing = keepGoing;
	}

	public boolean getKeepGoing() {
		return this.keepGoing;
	}
	
	public void calculateAceValue(Card card,Player player) {
		if(player.getPlayerScore() < 11) {
			
		}
	}

}