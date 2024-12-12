public class Suma extends Thread{
    int suma=0;
    Counter counter;
    public Suma(Counter counter) {
        this.suma=0;
        this.counter=counter;
    }
    @Override
    public void run() {
        while(true)
        {
            if(counter.incCounter()==-1)
                break;
            suma=suma+counter.startCounter();
            counter.incCounter();
        }
    }
    public int getSuma() {
        return suma;
    }
}
