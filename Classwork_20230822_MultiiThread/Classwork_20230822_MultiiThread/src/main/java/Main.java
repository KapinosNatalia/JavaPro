public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter(1, 2500);
        Counter c2 = new Counter(2501, 5000);
        Counter c3 = new Counter(5001, 7500);
        Counter c4 = new Counter(7501, 10000);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        int sum = c1.sum + c2.sum + c3.sum + c4.sum;
        System.out.println(sum);
    }

}

class Counter implements Runnable {
    private int start;
    private int end;
    int sum;

    public Counter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
    }


}
