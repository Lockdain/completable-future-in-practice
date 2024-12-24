package completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureAllOf {
    public static void main(String[] args) {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println("Task 1 completed");
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
            System.out.println("Task 2 completed");
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2); // позволяет запускать несколько задач параллельно и ждать их завершения

        allFutures.thenRun(() -> System.out.println("All tasks completed")).join(); // non-blocking
    }
}

