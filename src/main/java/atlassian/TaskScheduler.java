package atlassian;

import lombok.SneakyThrows;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * A consumer can schedule a request to https://testservice.com/api/items/_create to be executed on upcoming Sunday at 1am. So on upcoming Sunday at 1am the scheduling system must execute the HTTP request.
 *
 * Requirements:
 * - Provide an interface for scheduling HTTP requests at a specified time.
 * - Execute an HTTP request at specified time.
 * - Initial release expects 10 scheduling requests per minute.
 */
public class TaskScheduler {
        private ExecutorService priorityJobPoolExecutor;
        private ExecutorService priorityJobScheduler
                = Executors.newSingleThreadExecutor();
        private PriorityBlockingQueue<Job> priorityQueue;

        public TaskScheduler(Integer poolSize, Integer queueSize) {
            priorityJobPoolExecutor = Executors.newFixedThreadPool(poolSize);
            priorityQueue = new PriorityBlockingQueue<Job>(
                    queueSize,
                    Comparator.comparing(Job::getJobPriority));
            priorityJobScheduler.execute(() -> {
                while (true) {
                    try {
                        priorityJobPoolExecutor.execute(priorityQueue.take());
                    } catch (InterruptedException e) {
                        // exception needs special handling
                        break;
                    }
                }
            });
        }

        public void scheduleJob(Job job) {
            priorityQueue.add(job);
        }


        // standard setters and getters

    public class Job implements Runnable {
        private String jobName;
        private JobPriority jobPriority;

        @Override
        @SneakyThrows
        public void run() {
            System.out.println("Job:" + jobName +
                    " Priority:" + jobPriority);
            Thread.sleep(1000); // to simulate actual execution time
        }

        // standard setters and getters
        JobPriority getJobPriority(){
            return jobPriority;
        }
    }

    public enum JobPriority {
        HIGH,
        MEDIUM,
        LOW
    }
}
