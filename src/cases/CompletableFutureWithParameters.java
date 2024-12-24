package cases;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureWithParameters {
    public static void main(String[] args) {
        int input = 5;

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> square(input));

        future.thenAccept(result -> System.out.println("Square of " + input + " is: " + result));
    }

    private static int square(int number) {
        return number * number;
    }
}

