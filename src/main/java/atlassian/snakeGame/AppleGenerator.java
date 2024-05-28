package atlassian.snakeGame;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class AppleGenerator{
    private AtomicBoolean mutex;

    private long generationTimeout = 1200000; // 20 minutes
    public AppleGenerator(AtomicBoolean mutex){
        this.mutex = mutex;
        // generate apple

    }

    public void generateApple(){
        // this would be invoked when the snake has eaten an apple so we would notify this class to generate a new apple at a random spot.
        synchronized (mutex){
            mutex.set(true);
            mutex.notifyAll();
        }
    }

    private void awaitAppleGeneration(){
        synchronized (mutex){
            try{
                awaitMutex();
            }catch(InterruptedException e){
                log.warn("Failed to generate apple ", e);
            }
        }
    }

    private void awaitMutex() throws InterruptedException{
        long start = System.currentTimeMillis();
        long remainingWait = generationTimeout;

        // while loop to prevent spurious wakeups
        while(!mutex.get()){
            log.info("Entering wait on mutex for Apple generation ...");
            mutex.wait(remainingWait);

            if(!mutex.get() && System.currentTimeMillis() - start > generationTimeout){
                log.warn("Did not receive any notification to generate apple within {} ms. ", generationTimeout);
                break;
            }else if(!mutex.get()){
                remainingWait = generationTimeout - System.currentTimeMillis();
                log.warn("Spurious wakeup has occurred during wait. reentering wait with remaining wait time {} ms.", remainingWait);
            }
        }

        log.info("Completed apple generation in {} ms.", System.currentTimeMillis()-start);
    }
}
