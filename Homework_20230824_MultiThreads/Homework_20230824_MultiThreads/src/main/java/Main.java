public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(100);
        Consumer consumer = new Consumer(warehouse);
        Producer producer = new Producer(warehouse);

        Thread tProducer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer.produceItems(25);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread tProducer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer.produceItems(50);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread tProducer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer.produceItems(75);
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread tConsumer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer.consumeItems(25);
            }
        });
        Thread tConsumer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer.consumeItems(50);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread tConsumer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer.consumeItems(75);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tProducer1.start();
        tProducer2.start();
        tProducer3.start();
        tConsumer1.start();
        tConsumer2.start();
        tConsumer3.start();
    }
}
