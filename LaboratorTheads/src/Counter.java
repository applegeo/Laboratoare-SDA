public class Counter {
    int start;
    int last;
    public Counter (int s,int l) {
        this.start=s;
        this.last=l;
    }
   synchronized public int incCounter() {
        if(start>=last)
            return -1;
        return start++;
    }
    public int startCounter() {
        return start;
    }
}
