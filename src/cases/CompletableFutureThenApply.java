package cases;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureThenApply {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(result -> result + ", World!"); // используется для обработки результата CompletableFuture и возвращает новый CompletableFuture с преобразованным результатом

        future.thenAccept(result -> System.out.println("Transformed Result: " + result));
    }
}

