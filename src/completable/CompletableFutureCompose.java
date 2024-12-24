package completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCompose {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 5)
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result * 2)); // используется для объединения двух зависимых задач. Когда первая задача завершится, thenCompose() используется для запуска следующей задачи

        future.thenAccept(result -> System.out.println("Final Result: " + result)); // non-blocking
    }
}

