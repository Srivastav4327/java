import java.util.Random;

public class RandomNumberGenerator implements Runnable {
    private int threadId;
    private int numberOfIntegers;

    public RandomNumberGenerator(int threadId, int numberOfIntegers) {
        this.threadId = threadId;
        this.numberOfIntegers = numberOfIntegers;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadId + " started generating random integers:");
        Random random = new Random();

        for (int i = 0; i < numberOfIntegers; i++) {
            int randomNumber = random.nextInt(100); // Generate random integer between 0 and 99
            System.out.println("Thread " + threadId + ": " + randomNumber);

            try {
                Thread.sleep(100); // Sleep for 100 milliseconds between generating integers
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread " + threadId + " finished generating random integers.");
    }

    public static void main(String[] args) {
        int numberOfThreads = 5;
        int numberOfIntegersPerThread = 10;

        for (int i = 1; i <= numberOfThreads; i++) {
            RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(i, numberOfIntegersPerThread);
            Thread thread = new Thread(randomNumberGenerator);
            thread.start();
        }
    }
}