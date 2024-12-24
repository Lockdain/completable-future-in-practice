package completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCombine {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, Integer::sum); // используется для объединения результатов двух независимых задач. Он запускает обе задачи параллельно и комбинирует их результаты

        combinedFuture.thenAccept(result -> System.out.println("Combined Result: " + result));
    }
}

