package general;
class Task extends Thread {
    public void run() {
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println("Task: " + i);
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class AnotherTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println("AnotherTask: " + i);
            try {
                Thread.sleep(2000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Thread1 {

    public static void main(String[] args) {
        Thread anotherTask = new Thread(new AnotherTask());
        anotherTask.start();

        Task task = new Task();
        task.start();

        Thread yetAnotherTask = new Thread(new Runnable() {
            public void run() {
                for (int i = 0 ; i < 5 ; i++) {
                    System.out.println("YetAnotherTask: " + i);
                    try {
                        Thread.sleep(2000);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }); 
        yetAnotherTask.start();

        for (int i = 0 ; i < 5 ; i++) {
            System.out.println("Main: " + i);
            try {
                Thread.sleep(1500);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
