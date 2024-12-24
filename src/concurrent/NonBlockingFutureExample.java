package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NonBlockingFutureExample {
    public static void main(String[] args) {
        // Создаем пул потоков
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Создаем задачу, которая будет вычислять квадрат числа
        Callable<Integer> task = () -> {
            int number = 10;
            System.out.println("Calculating square of " + number);
            Thread.sleep(4000); // Симулируем длительную задачу
            return number * number;
        };

        // Отправляем задачу на выполнение и получаем Future
        Future<Integer> future = executor.submit(task);

        // Цикл для выполнения других операций, пока задача выполняется
        while (!future.isDone()) {
            System.out.println("Doing other work while waiting for the result...");
            try {
                // Симулируем другую работу
                Thread.sleep(500); // Задержка для имитации работы
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Получаем результат выполнения задачи
        try {
            Integer result = future.get();
            System.out.println("The square is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Завершаем работу пула потоков
            executor.shutdown();
        }
    }
}
