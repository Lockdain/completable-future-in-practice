package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) {
        // Создаем пул потоков
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Создаем задачу, которая будет вычислять квадрат числа
        Callable<Integer> task = () -> {
            int number = 10;
            System.out.println("Calculating square of " + number);
            Thread.sleep(2000); // Симулируем длительную задачу
            return number * number;
        };

        // Отправляем задачу на выполнение и получаем Future
        Future<Integer> future = executor.submit(task);

        // В другом потоке выполняем другие операции
        System.out.println("Doing other work while waiting for the result...");

        try {
            // Получаем результат выполнения задачи (это блокирующий вызов)
            Integer result = future.get();
            System.out.println("The square is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Завершаем работу пула потоков
            executor.shutdown();
        }
    }
}
