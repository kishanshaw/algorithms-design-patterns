package threads;

public class DiningPhilosophers implements Runnable {
    Object leftFork, rightFork;

    public DiningPhilosophers(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                logState(System.nanoTime() + " thinking");
                synchronized (leftFork) {
                    logState(System.nanoTime() + " picked-up leftFork");
                    synchronized (rightFork) {
                        logState(System.nanoTime() + " picked-up rightFork");
                        logState(System.nanoTime() + " put-down rightFork");
                    }
                    logState(System.nanoTime() + " put-down leftFork");
                }
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

    }

    private void logState(String s) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " at time " + s);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    private void executeDiningProblem() {
        final DiningPhilosophers[] philosophers = new DiningPhilosophers[5];
        Object[] forks = new Object[philosophers.length];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }
        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            if (i == philosophers.length - 1) {
                philosophers[i] = new DiningPhilosophers(rightFork, leftFork);
            } else {
                philosophers[i] = new DiningPhilosophers(leftFork, rightFork);
            }

            Thread t
                    = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
