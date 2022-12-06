import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public int Starter_index;
    public int max;
    public int starter;
    public String koz;

    public static ArrayList<Player> PLAYER = new ArrayList<Player>();
    public static ArrayList<Cards> cards = new ArrayList<Cards>();
    public static void Setcards(){
        cards.add((new Cards(1,"kupa","2")));
        cards.add((new Cards(2,"kupa","3")));
        cards.add((new Cards(3,"kupa","4")));
        cards.add((new Cards(4,"kupa","5")));
        cards.add((new Cards(5,"kupa","6")));
        cards.add((new Cards(6,"kupa","7")));
        cards.add((new Cards(7,"kupa","8")));
        cards.add((new Cards(8,"kupa","9")));
        cards.add((new Cards(9,"kupa","10")));
        cards.add((new Cards(10,"kupa","j")));
        cards.add((new Cards(11,"kupa","Q")));
        cards.add((new Cards(12,"kupa","K")));
        cards.add((new Cards(13,"kupa","A")));
        cards.add((new Cards(1,"karo","2")));
        cards.add((new Cards(2,"karo","3")));
        cards.add((new Cards(3,"karo","4")));
        cards.add((new Cards(4,"karo","5")));
        cards.add((new Cards(5,"karo","6")));
        cards.add((new Cards(6,"karo","7")));
        cards.add((new Cards(7,"karo","8")));
        cards.add((new Cards(8,"karo","9")));
        cards.add((new Cards(9,"karo","10")));
        cards.add((new Cards(10,"karo","j")));
        cards.add((new Cards(11,"karo","Q")));
        cards.add((new Cards(12,"karo","K")));
        cards.add((new Cards(13,"karo","A")));
        cards.add((new Cards(1,"Maca","2")));
        cards.add((new Cards(2,"Maca","3")));
        cards.add((new Cards(3,"Maca","4")));
        cards.add((new Cards(4,"Maca","5")));
        cards.add((new Cards(5,"Maca","6")));
        cards.add((new Cards(6,"Maca","7")));
        cards.add((new Cards(7,"Maca","8")));
        cards.add((new Cards(8,"Maca","9")));
        cards.add((new Cards(9,"Maca","10")));
        cards.add((new Cards(10,"Maca","j")));
        cards.add((new Cards(11,"Maca","Q")));
        cards.add((new Cards(12,"Maca","K")));
        cards.add((new Cards(13,"Maca","A")));
        cards.add((new Cards(1,"Sinek","2")));
        cards.add((new Cards(2,"Sinek","3")));
        cards.add((new Cards(3,"Sinek","4")));
        cards.add((new Cards(4,"Sinek","5")));
        cards.add((new Cards(5,"Sinek","6")));
        cards.add((new Cards(6,"Sinek","7")));
        cards.add((new Cards(7,"Sinek","8")));
        cards.add((new Cards(8,"Sinek","9")));
        cards.add((new Cards(9,"Sinek","10")));
        cards.add((new Cards(10,"Sinek","j")));
        cards.add((new Cards(11,"Sinek","Q")));
        cards.add((new Cards(12,"Sinek","K")));
        cards.add((new Cards(13,"Sinek","A")));

    }

    public void setname() {


        Scanner myObj = new Scanner(System.in);
        for(int i=0;i<4;i++){
            System.out.println("Enter username");

            String userName = myObj.nextLine();
           PLAYER.add(new Player(userName));

        }

    }
    public void ruffle(){
        Random random = new Random();
     while (cards.size()!=0){
         for(int i=0;i<4;i++){
             int rand= random.nextInt(cards.size());
             PLAYER.get(i).addCard(cards.get(rand));
             cards.remove(rand);
         }
         
     }
    }
    public int getStarter_index(){
        return this.Starter_index;
    }
    public int getMax(){
        return this.max;
    }
    public void setValue(int  starter_index,int max){
        this.max=max;
        this.Starter_index=starter_index;
    }
    public void tender(){
      int player_index=0;
        Scanner myObj = new Scanner(System.in);
        int max=0;
        int enter_value;
        for(int i=0;i<4;i++){
            System.out.println(PLAYER.get(i).name+" ihaleye giriniz");
            enter_value= myObj.nextInt();
            if(enter_value>13){
                System.out.println("Bu değeri giemezsiniz");
                System.out.println(PLAYER.get(i).name+" ihaleye giriniz");
                enter_value= myObj.nextInt();
            }
            else if(enter_value>max){
                max=enter_value;
                player_index=i;
            }
            this.starter=player_index;
        }
        System.out.println("ihaleyi kazanan"+PLAYER.get(player_index).name+"alması gereken minumum el "+Integer.toString(max));
        setValue(player_index,max);

    }
    public void game(){
        setname();
        Setcards();
        ruffle();
        for(int i=0;i<4;i++){
            PLAYER.get(i).showCards();
        }
        tender();
        setkoz();
        hands(starter,PLAYER.get(0).cards.size());
        for(int i=0;i<4;i++){
            System.out.println(PLAYER.get(i).name+" "+PLAYER.get(i).achive );
        }

    }
    public void hands(int sıra,int counter){
        while(counter>0) {
            int index;
            int max = 0;
            int winner=0;
            int ilk=sıra;


            Scanner myObj = new Scanner(System.in);
            String typ="";

            for (int i = 0; i < 4; i++) {
                if(sıra!=ilk){
                    PLAYER.get(sıra).playableCards_SHOW(typ,max,this.koz);
                }else{
                PLAYER.get(sıra).showCards();}
                System.out.println();
                System.out.println("Oyniyacağınız kartın indexsini giriniz ");
                index = myObj.nextInt();

                if (PLAYER.get(sıra).cards.get(index).rank > max) {
                    max = PLAYER.get(sıra).cards.get(index).rank;
                    if(ilk==sıra){
                        typ=PLAYER.get(sıra).cards.get(index).type;
                    }
                    winner = sıra;

                }
                PLAYER.get(sıra).cards.remove(index);
                sıra++;
                if (sıra == 4) {
                    sıra = 0;
                }
            }
            PLAYER.get(winner).achiveInc();
            hands(winner,PLAYER.get(0).cards.size());

        }
        System.out.println("oyun bitti");
    }
    public void setkoz(){
        Scanner myObj = new Scanner(System.in);
        System.out.println(PLAYER.get(Starter_index).name+" KOZ BELİRLE");
        System.out.println("kupa,karo,sinek,maca dan birini yazınız");
        String koz=myObj.nextLine();
        this.koz=koz;
        for (int i=0;i<4;i++){
            PLAYER.get(i).setcarskoz(koz);
        }
    }
    }

