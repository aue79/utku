public class Cards {
    int rank;
    String type;
    String name;
public Cards(int rank,String type,String name){
    this.rank=rank;
    this.name=name;
    this.type=type;
}
public void setRank(){
    this.rank=this.rank*14;
}
}
