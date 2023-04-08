package second;

public class SevenColumnPrimes extends Thread {
    private int prime;
    private SevenColumnPrimes next;
    private int column;

    SevenColumnPrimes(int prime, int columns) {
        super("Primer-" + prime);
        this.prime = prime;
        this.column = columns;
        this.start();
    }


    public static void main(String args[]) {
        for(int j = 0; j<7; j++) {
            new Thread(new ColumnInitalizer(j), "column"+j).start();

        }
        System.out.println(currentThread() + " main beendet");
    }

    public void run() {
        System.out.println(" ".repeat(column * 7) + prime);
        while (true) {
            int n = receive();
            if (n == 0) {
                if (next != null) next.send(n);
                break;
            }
            if (n % prime != 0) {
                if (next != null) next.send(n);
                else next = new SevenColumnPrimes(n, column);
            }
        }

    }

    private int buffer = -1;

    synchronized void send(int i) {
        try {
            while (buffer >= 0) wait();
            buffer = i;
            notify();
        } catch (InterruptedException e) {
        }
    }

    synchronized int receive() {
        int result = 0;
        try {
            while ((result = buffer) < 0) wait();
            buffer = -1;
            notify();

        } catch (InterruptedException e) {
        }
        return result;
    }
}

