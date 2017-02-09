package war;

import java.util.Arrays;

class Player {

	private String name = "";
	private Card hand[] = {};
	private Card collected[] = new Card[52];
	private int left = 0;
	private int collect = 0;

	public Player(String name) {
		setName(name);
	}

	public Card[] getHand() {
		return hand;
	}

	public void setHand(Card[] hand) {
		if (hand == null) {
			throw new RuntimeException("Null pointer compare.");
		}
		this.hand = hand;
	}

	public Card[] getCollected() {
		return collected;
	}

	public void setCollected(Card[] collected) {
		if (collected == null) {
			throw new RuntimeException("Null pointer compare.");
		}
		this.collected = collected;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new RuntimeException("Null pointer compare.");
		}
		this.name = name;
	}

	public void collect (Object[] cards) {
		if (cards == null) {
			throw new RuntimeException("Null pointer compare.");
		}
		for (int i = 0; i < cards.length; i++) {
			collected[collect++] = (Card) cards[i];
		}
	}

	public void receive(Card[] cards) {
		if (cards == null) {
			throw new RuntimeException("Null pointer compare.");
		}
		this.hand = cards;
		this.left = hand.length - 1;
	}

	public Card play() {
		if (getLeft() <= 0) {
			// TODO Exception.
		}
		return getHand()[left--];
	}

	public int getLeft() {
		return left;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", hand=" + Arrays.toString(hand) + ", collected=" + Arrays.toString(collected)
				+ ", left=" + left + ", collect=" + collect + "]";
	}
}
