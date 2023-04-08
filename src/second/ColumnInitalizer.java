package second;

public class ColumnInitalizer implements Runnable {
    private final int column;

    public ColumnInitalizer(int column){
        this.column = column;
    }

    @Override
    public void run() {
        SevenColumnPrimes first = new SevenColumnPrimes(2, column);
        for (int i = 3; i <= 7351; first.send(i++)) ;
        first.send(0);
    }
}
