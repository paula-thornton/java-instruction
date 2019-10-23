public class CardDeckApp {

    public static void main(String[] args) {
        System.out.println("DECK");
        String[] deck = getDeck();
        displayCards(deck);

        System.out.println("\n\nSHUFFLED DECK");
        shuffleDeck(deck);
        displayCards(deck);

        int count = 4;
        System.out.println("\n\nHAND OF " + count + " CARDS");
        String[] hand = dealCards(deck, count);
        displayCards(hand);
    }

    private static String[] getDeck() {
        String[] deck = new String[52];

        // add code that creates deck here
        String[] suite = {"clubs", "diamonds", "hearts", "spades"} ;
        String[] rank = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        		"jack", "queen", "king"};

        int index = 0;
        
        for (String s : suite) {
            for (String r : rank) {
                deck[index] = r + " of " + s;
                index++;
            }
        }
        
	//	for (int s = 0; s < suite.length; s++) {
	//		for (int r = 0; r < rank.length; r++) {
	//			deck[index] = rank[r] + " of " + suite[s];
	//			index++;
	//		}
	//	}
        
        return deck;
    }

    private static void displayCards(String[] cards) {
        // add code that displays cards here
    	for (String s: cards) {
    		System.out.print(s + " | ");
    	}
    }

    private static void shuffleDeck(String[] deck) {
        
        // add code that shuffles the deck here
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = (int) (Math.random() * deck.length-1);
            String temp1 = deck[randomIndex];
            deck[randomIndex] = deck[i];
            deck[i] = temp1;
        }
    }

    private static String[] dealCards(String[] deck, int count) {
        String[] hand = new String[count];
        for (int i = 0; i < count; i++) {
        	hand[i] = deck[i];
        }		
        return hand;
    }
}