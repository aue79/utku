import java.util.ArrayList;

public class Player {
    public String name;
    public int achive=0;
    public ArrayList<Cards> cards = new ArrayList<Cards>();

    public Player(String name) {
        this.name = name;
    }
    public  void addCard(Cards card){
        cards.add(card);
    }

    public void showCards() {
 for(int i=0;i<cards.size();i++){
     System.out.print(cards.get(i).type+cards.get(i).name+ " İndex="+Integer.toString(i)+" ");
 }
 System.out.println();
    }
    public void achiveInc(){
        this.achive++;
    }
    public void setcarskoz(String typ){
        for(int i=0;i<this.cards.size();i++){
            if(this.cards.get(i).type.equals(typ)){
                this.cards.get(i).setRank();
            }
        }
    }
    public void playableCards_SHOW(String typ,int max,String koz){
        boolean kartvar=false;
        for(int i=0;i<cards.size();i++){
            if(this.cards.get(i).type.equals(typ)&&this.cards.get(i).rank>max) {
                kartvar=true;
                System.out.print(cards.get(i).type + cards.get(i).name + " İndex="+Integer.toString(i)+" ");
            }
        }
        if(!kartvar){
            for(int i=0;i<cards.size();i++){
                if(this.cards.get(i).type.equals(typ)) {
                    kartvar=true;
                    System.out.print(cards.get(i).type + cards.get(i).name + " İndex="+Integer.toString(i)+" ");

                }}
        }
        if(!kartvar){
            for(int i=0;i<cards.size();i++){
                if(this.cards.get(i).type.equals(koz)) {
                    kartvar=true;
                    System.out.print(cards.get(i).type + cards.get(i).name + " İndex="+Integer.toString(i)+" ");
                }}
        }
        if(!kartvar){
            this.showCards();
        }

    }
}
