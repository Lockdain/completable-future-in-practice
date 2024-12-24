package completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> { // используется для асинхронного выполнения задачи, возвращающей результат. Задача выполняется в фоновом потоке
            try {
                Thread.sleep(1000); // Имитация долгой операции
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Hello, World!";
        });

        // Блокируем основной поток до завершения
        future.thenAccept(result -> System.out.println("Result: " + result)).join(); // почему ничего не видим в результате?
    }
}

