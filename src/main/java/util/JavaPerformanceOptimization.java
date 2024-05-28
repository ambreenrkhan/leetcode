package util;

import leetCode.TreeNode;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaPerformanceOptimization {
    public static void main(String[] args){

        //ConcurrentHashMap class is thread-safe i.e. multiple threads can operate on a single object without any complications.
        ConcurrentHashMap<String, String> new_chm = new ConcurrentHashMap<>();

        //Hashtable is synchronized and provides thread safety like concurrentHashMap but in the performance point of view,
        // Hashtable write operation uses map wide lock which means it locks the complete map object.

        ConcurrentHashMap<String,LongAdder> freqs = new ConcurrentHashMap<>();
       // freqs.computeIfAbsent(k -> new LongAdder()).increment();


        //The hashCode() method in Java works by generating an integer value that represents the memory address of the object. This value is used as the index number for the object in the hash-based collection.
        // A common algorithm is to start with some arbitrary number and to repeatedly multiply it with another (often a small prime) before adding a field’s hash:
        // good way to calculate the hash... for every field in equals method.. do below: it is actually doing below internally: int result = 1;
        //-	using a larger prime number as a multiplier. In hash functiins to reduce collisions
        //        for (Object element : a)
        //            result = 31 * result + (element == null ? 0 : element.hashCode());
        TreeNode node = new TreeNode();
        Objects.hash(node.left, node.right, node.val);


        //For current timestamp just use Instant.now(). No need to convert to milliseconds.
        //, if this is for measuring elapsed time, you may prefer the higher resolution of System.nanoTime().
        Instant.now(); // obtains current instance from System clock.
        System.nanoTime(); //current value of the running Java Virtual Machine's high-resolution time source, in nanoseconds

        // YOu can use Array.newInstance to initialize an array
        TreeNode[] treeNodes = (TreeNode[])Array.newInstance(TreeNode.class,20);
        List<TreeNode>[] treeNodesList = (List<TreeNode>[])Array.newInstance(List.class,30);

        // let's say you want to find the index where a particular key should be inserted in the list..
        // You could do something like below:
        String key = "key";
        int setIndex = Math.floorMod(key.hashCode(), treeNodesList.length);
        System.out.println(Math.floorMod(123, 50)); // this should print 23

        // USe below code to return a new object based upon enum
        Fruit1 apple = Fruit1.APPLE;
        apple.getTree();


        //ReentrantReadWriteLock, in reality, we wouldn’t use it to synchronize access to a HashMap.
        // Instead, we’d make use of the Collections class, which has a method that takes a Map and returns a thread-safe equivalent, as shown below:
        Map<String, String> transactionHistory = Collections.synchronizedMap(new HashMap<String, String>());
        /**
         * Internally, the atomic classes make heavy use of compare-and-swap (CAS), an atomic instruction directly
         * supported by most modern CPUs. Those instructions usually are much faster than synchronizing via locks.
         * So my advice is to prefer atomic classes over locks in case you just have to change a single mutable variable concurrently.
         * The method incrementAndGet() is an atomic operation so we can safely call this method from multiple threads.
         */

        AtomicInteger atomicInt = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
                .forEach(i -> executor.submit(atomicInt::incrementAndGet));
        executor.shutdown();;
        System.out.println(atomicInt.get());    // => 1000

        //The class LongAdder as an alternative to AtomicLong can be used to consecutively add values to a number.
        ExecutorService executor2 = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        try{
            executor2.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        List<Integer> list = new ArrayList<>();


        // Other tips:
        //While iterating through any collection get the size of the collection beforehand and never get it during iteration.
        //. Avoid Using String Objects For Concatenation.use StringBuilder or StringBuffer, the former is preferential over the latter since it has a performance advantage due to non-synchronized methods.
// . If possible, we can use primitive types instead of objects since data access from stack memory is faster than heap memory. So it is always beneficial to use int over Integer or double over Double.
        //Avoiding array initialization with 'new' (inefficient in older JVMs). USe build in Array new instance.
        //The comment suggests that adding int directly is preferable over using the Integer wrapper type. as unncessary objectcreation
        //Choose the right data structures for your specific use case. ArrayLists are efficient for random access, LinkedLists for frequent insertions/deletions, HashMaps for quick key-value lookups, etc.
   //Synchronization can lead to contention and performance bottlenecks. Minimize synchronized blocks or methods when not necessary. Consider using concurrent data structures from the `java.util.concurrent` package for multi-threaded scenarios.
//        //When creating collections like ArrayLists or HashMaps, provide an initial capacity that is reasonably close to the expected size to reduce the frequency of resizing, which can be expensive.
//
//int initialCapacity = 10000;
        //Collections.synchronizedList(unsafeList); has limitation all of its read and write methods (add, set, remove, iterator, etc) are synchronized on the list object itself.
        //e can use CopyOnWriteArrayList as a thread-safe alternative to ArrayList, and to take advantages of its new methods addIfAbsent() and addAllAbsent(), which are explained below.
        //  ConcurrentSkipListSet - to use when cocurrent, no duplicates and sorted
        // you could use parallel stream in java - partition a list into sublists
        //logger.debug("the value is: %d", x); is faster than logger.debug("the value is: " + x);
        //the StringTokenizer class to split the input string into words, which is much faster than using regular expressions.
        int batchSIze=3;


        /**
         * Lists.partition(list, batchSize)
         *                 .parallelStream()
         *                 .forEach(batch -> invokeList(batch));
         * List<Integer> list = Arrays.asList(1,26,17,18,19,20);
         *  list.stream().collect(toChunks(5))
         *               .parallelStream()
         *               .forEach(System.out::println);
         */
    }

    static <T> Stream<List<T>> partitionList(List<T> source, int batchSize) {
        if (batchSize <= 0) {
            throw new IllegalArgumentException(String.format("The batchSize cannot be smaller than 0. Actual value: %s", batchSize));
        }
        if (source.isEmpty()) {
            return Stream.empty();
        }
        int nrOfFullBatches = (source.size() - 1) / batchSize;
        return IntStream.rangeClosed(0, nrOfFullBatches)
                .mapToObj(batch -> {
                    int startIndex = batch * batchSize;
                    int endIndex = (batch == nrOfFullBatches) ? source.size() : (batch + 1) * batchSize;
                    return source.subList(startIndex, endIndex);
                });
    }

    public class BankAccountUsingSynchronized {

        private double balance;

        public synchronized void credit(double amount){
            balance = balance + amount;
        }

        public void debit(double amount){
            synchronized (this) {
                balance = balance - amount;
            }
        }

        public double getBalance(){
            return balance;
        }
    }


    public class BankAccountUsingLock {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        //So the read-lock can be held simultaneously by multiple threads as long as no threads hold the write-lock.
        // This can improve performance and throughput in case that reads are more frequent than writes.

        private volatile double balance;

        public void credit(double amount) {
            try {
                lock.writeLock().lock();
                balance = balance + amount;
            } finally {
                lock.writeLock().unlock();
            }
        }

        public void debit(double amount) {
            try {
                lock.writeLock().lock();
                balance = balance - amount;
            } finally {
                lock.writeLock().unlock();
            }

        }

        public double getBalance() {
           return balance;
        }
    }

    // use below to return something based on enum.
    enum Fruit1 {
        APPLE {
            public Tree getTree() { return new AppleTree(); }
        }, BANANA {
            public Tree getTree() { return new BananaTree(); }
        };

        public abstract Tree getTree();
    }

    private static interface Tree{

    }

    private static class AppleTree implements Tree{

    }

    private static class BananaTree implements Tree{

    }

    public int findMax(int[] arr) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        int chunkSize = arr.length / numThreads;
        int[] maxValues = new int[numThreads];
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? arr.length : (i + 1) * chunkSize;
            int finalI = i;
            threads[i] = new Thread(() -> {
                int max = 0;
                for (int j = start; j < end; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                    }
                }
                maxValues[finalI] = max;
            });
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                // handle exception
            }
        }

        int max = 0;
        for (int i = 0; i < numThreads; i++) {
            if (maxValues[i] > max) {
                max = maxValues[i];
            }
        }
        return max;
    }
}
