package cases;

import java.util.concurrent.CompletableFuture;


public class ApiSimulation {
    public static void main(String[] args) {
        CompletableFuture<String> apiCall1 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Result from API 1";
        });

        CompletableFuture<String> apiCall2 = CompletableFuture.supplyAsync(() -> {
            sleep(1500);
            return "Result from API 2";
        });

        apiCall1.thenCombine(apiCall2, (result1, result2) -> result1 + " & " + result2)
                .thenAccept(finalResult -> System.out.println("Combined API Result: " + finalResult)).join();
    }

    private static void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) {}
    }
}

