package concurrent;

import static java.lang.Thread.sleep;

public class RaceConditionExample {
    private volatile static int counter = 0; // Общая переменная для инкремента

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
        System.out.println("Final counter value: " + counter);
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // Инкрементируем общий счетчик
                counter++;
                System.out.println("Вижу значение: " + counter);
            }
        }
    }
}
