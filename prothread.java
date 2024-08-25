class  MyRunnable implements Runnable {
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("Count Thread" + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class prothread {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}