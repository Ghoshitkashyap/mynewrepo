import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class singleThreadExecutor1 implements Runnable {
    private int id;
    public void run(){
        System.out.println("task"+id+"starting");
        for(int i=10;i>=0;i--){
            System.out.println(id+"tick"+i);
            try{
                Thread.sleep(1000);

            }
            catch (InterruptedException e){
                e.printStackTrace();

            }
        }
    }
    public singleThreadExecutor1() {
        this.id = ++count;
    }
}
public class SingleExecutorDemo {

    public static void main(String[] args) {
        System.out.println("main thread starts here");
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        for(int i=0;i<3;i++){
            executorService.execute(new singleThreadExecutor1());
        }
        executorService.shutdown();
        System.out.println("main ends here");
    }}

