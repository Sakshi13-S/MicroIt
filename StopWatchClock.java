public class StopWatchClock {

    private long startTime = 0;
    private long elapsedTime = 0;
    private boolean isRunning = false;

    public void start() {
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
            System.out.println("Stopwatch started.");
        }
    }

    public void stop() {
        if (isRunning) {
            elapsedTime += (System.currentTimeMillis() - startTime);
            isRunning = false;
            System.out.println("Stopwatch stopped.");
        }
    }

    public void reset() {
        elapsedTime = 0;
        isRunning = false;
        System.out.println("Stopwatch reset.");
    }

    public long getElapsedTime() {
        if (isRunning) {
            return elapsedTime + (System.currentTimeMillis() - startTime);
        }
        return elapsedTime;
    }

    public void displayTime() {
        long totalMilliseconds = getElapsedTime();
        long seconds = (totalMilliseconds / 1000) % 60;
        long minutes = (totalMilliseconds / (1000 * 60)) % 60;
        long hours = totalMilliseconds / (1000 * 60 * 60);
        System.out.printf("Elapsed Time: %02d:%02d:%02d.%n", hours, minutes, seconds);

        // For a basic clock, you'd use java.time (requires import, so kept simple here)
        // In a real application, you'd format the current time nicely.
        long currentTimeMillis = System.currentTimeMillis();
        long currentSeconds = (currentTimeMillis / 1000) % 60;
        long currentMinutes = (currentTimeMillis / (1000 * 60)) % 60;
        long currentHours = (currentTimeMillis / (1000 * 60 * 60)) % 24; // Assuming 24-hour format
        System.out.printf("Current Time (Basic): %02d:%02d:%02d.%n", currentHours, currentMinutes, currentSeconds);
    }

    public static void main(String[] args) {
        StopWatchClock timer = new StopWatchClock();
        timer.start();
        try {
            Thread.sleep(5000); // Simulate some activity
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        timer.stop();
        timer.displayTime();
        timer.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        timer.stop();
        timer.displayTime();
        timer.reset();
        timer.displayTime();
    }
}