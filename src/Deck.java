public class Deck {

    Card[] deck = new Card[52];
    Card card;
    int cardsUsed;

    public Deck(){
        int cardCount = 0;
        for(int suit = 0; suit < 4; suit++){
            for(int ranks = 1; ranks < 14; ranks++){
                deck[cardCount] = new Card(suit, ranks);
                cardCount++;
            }
        }
    }

    public void shuffle(){
        for(int i = 51; i > 0; i--){
            int rand = (int)(Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    public int cardsLeft(){
        return 52 - cardsUsed;
    }

    public Card deal(){
        if(!(cardsUsed >= 52)){
            card = deck[cardsUsed];
            cardsUsed++;
        }
        else{
            System.out.println("NO MORE CARDS LEFT IN DECK");
        }
        return card;
    }

    public String toString(){
        String message = "";

        //ENHANCED FOR LOOP - ONLY FOR ACCESSING EVERY ITEM IN ARRAY
        //for(Object variable: array) ... iterate the for loop

        for(Card card: deck){
            message += card.toString() + "\n";
        }
        return message;
    }

}
