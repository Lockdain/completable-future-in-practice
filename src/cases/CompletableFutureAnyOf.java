package cases;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureAnyOf {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            return "Result from Task 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Result from Task 2";
        });

        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2);

        anyOfFuture.thenAccept(result -> System.out.println("First completed task result: " + result)).join();
    }

    private static void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) {}
    }
}

