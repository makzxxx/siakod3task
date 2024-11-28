package packageTask;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int numOperations = 10000;
        int maxPriority = 1000;
        Random random = new Random();

        // Тест для бинарной кучи
        PriorityQueueHeap heapQueue = new PriorityQueueHeap(numOperations);
        long startInsert = System.currentTimeMillis();

        for (int i = 0; i < numOperations; i++) {
            int value = random.nextInt(numOperations);
            int priority = random.nextInt(maxPriority);
            heapQueue.insert(value, priority);
        }
        long endInsert = System.currentTimeMillis();
        System.out.println("Вставка заяяла времени: " + (endInsert - startInsert) + "мс.");

        long startExtact = System.currentTimeMillis();
        for (int i = 0; i < numOperations; i++) {
            heapQueue.extractMax();
        }

        long endExtact = System.currentTimeMillis();
        System.out.println("Извлечение заняло времени: " + (endExtact - startExtact) + "мс.");



        PriorityQueueLinkedList listQueue = new PriorityQueueLinkedList();
        long startInsert1 = System.currentTimeMillis();

        for (int i = 0; i < numOperations; i++) {
            int value = random.nextInt(numOperations);
            int priority = random.nextInt(maxPriority);
            listQueue.insert(value, priority);
        }
        long endInsert1 = System.currentTimeMillis();
        System.out.println("Вставка заяяла времени(LL): " + (endInsert1 - startInsert1) + "мс.");

        long startEXtract1 = System.currentTimeMillis();
        for (int i = 0; i < numOperations; i++) {
            listQueue.extractMax();
        }

        long endEXtract1 = System.currentTimeMillis();
        System.out.println("Извлечение заняло времени(LL): " + (endEXtract1 - startEXtract1) + "мс.");
    }
}
