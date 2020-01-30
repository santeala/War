import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }
    /*ArrayList METHODS
        size() = returns the size, ie number of items, in the arrayList
        add(obj) = adds the obj to the arrayList at the END of the arrayList
        add(int, obj) = adds the obj at the int index of the arrayList; reorganize the arrayList accordingly
        get(int) = returns obj from the arrayList at the int index
        set(int, obj) = replace object int the arrayList at index with object
        remove(int) = removes an object at the index in arrayList; reorganizes accordingly
     */

    public void addCard(Card c){
        if(c != null){
            hand.add(c);
        }
    }

    public void removeCard(Card c){
        if(c != null){
            hand.remove(c);
        }
    }

    public void removeCard(int position){
        if(position >= 0 && position < hand.size()){
            hand.remove(position);
        }
    }

    public Card getCard(int positon){
        if(positon >= 0 && positon < hand.size()){
            return hand.get(positon);
        }
        else
            return null;
    }

    public int getCardCount(){
        return hand.size();
    }

    public String toString(){
        return hand.toString();
    }

}
