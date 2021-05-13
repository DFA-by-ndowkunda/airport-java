package airport;

public class Airport {
    int maxCapacity;

    public Airport(){
        this.maxCapacity = 99;
    }
    public String isFull(int capacity){
        String full = "airport full";
        String notFull = "airport not full";
        if(capacity>this.maxCapacity){
            return full;
        }else{
            return notFull;
        }
    }
}
