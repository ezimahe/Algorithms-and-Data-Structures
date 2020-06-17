package e2_card;

//@author - Eleanor Ezimah
public class Card {

	 public static void main (String [] args) {  

	   }
	    public static int Spade   = 4;
	    public static int Heart  = 3;
	    public static int Club   = 2;
	    public static int Diamond = 1;

	    private int rank;
	    private int suit;
	    private static String[] Suit = {"Hearts", "Clubs", "Spades", "Diamonds"};
	    private static String[] Rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};                     

	    private int cardSuit;
	    private int cardRank;

	    public Card(int suit, int rank) {
	       if (rank == 1)
	          cardRank = 14;    
	       else
	          cardRank = (int) rank;
	          cardSuit = (int) suit;
	    }

	    public int suit() {
	       return this.cardSuit;         
	    }

	    public String suitStr() {
	       return(this.Suit[ this.cardSuit ]);                                
	    }

	    public int rank() {
	       return this.cardRank;
	    }

	    public String rankStr() {
	       return ( Rank[ cardRank ] );
	    }


	    public String toString() {
	       return ( Rank[ cardRank ] + Suit[ cardSuit ] );
	    }
	    
	 }
	
