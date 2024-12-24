package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private static AtomicInteger counter = new AtomicInteger(0); // Используем AtomicInteger

    public static void main(String[] args) {
        // Создаем два потока, которые будут инкрементировать переменную counter
        Thread thread1 = new Thread(new IncrementTask());
        Thread thread2 = new Thread(new IncrementTask());

        // Запускаем оба потока
        thread1.start();
        thread2.start();

        // Ждем завершения обоих потоков
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Выводим финальное значение counter
        System.out.println("Final counter value: " + counter.get());
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter.incrementAndGet(); // Атомарный инкремент
                System.out.println("Вижу значение: " + counter);
            }
        }
    }
}
