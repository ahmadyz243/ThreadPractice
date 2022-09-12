import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        int selection;
        while (true){
            System.out.println("1. intSleep:");
            System.out.println("2. checking Account:");
            System.out.println("3. exit");
            selection = s.nextInt();
            if(selection == 1){
                first();
            } else if (selection == 2) {
                second();
                Thread.sleep(3000);
            }else break;
        }
    }







    private static void second() {
        final CheckingAccount ca = new CheckingAccount(100);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                for(int i = 0; i < 10; i++){
                    System.out.println(name + " withdraws $10: " + ca.withdraw(10));
                }
            }
        };
        Thread thdHusband = new Thread(r);
        thdHusband.setName("Husband");
        Thread thdWife = new Thread(r);
        thdWife.setName("Wife");
        thdHusband.start();
        thdWife.start();
    }


    private static void first() throws InterruptedException {
        BackGroundThread bgt = new BackGroundThread();
        System.out.println(bgt.getName() + "started...");
        bgt.start();
        Thread.sleep(3000);
        bgt.interrupt();
        System.out.println(bgt.getName() + " thread interrupted by " + Thread.currentThread().getName());
    }
}
