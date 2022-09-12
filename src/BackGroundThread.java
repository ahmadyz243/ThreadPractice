public class BackGroundThread extends Thread{
    @Override
    public void run() {
        while (true){
            try{
                System.out.println("Hello");
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println("background thread interrupted...");
                break;
            }
        }
    }
}
