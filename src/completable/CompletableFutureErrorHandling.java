package completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureErrorHandling {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Something went wrong!");
            return 42;
        });

        future.exceptionally(ex -> {
            System.out.println("Caught exception: " + ex.getMessage());
            return -1;
        }).thenAccept(result -> System.out.println("Result: " + result)); // принимает результат CompletableFuture и выполняет действие, не возвращая нового значения
    }
}

