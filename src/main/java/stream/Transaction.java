package stream;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Transaction implements Comparable<Transaction>{
    private long creationTime;
    private long value;

    public Transaction (long value){
        this.value = value;
        this.creationTime = System.currentTimeMillis();
    }

    public int compareTo(Transaction other){
        if(this == other){
            return 0;
        }

        return Long.compare(this.creationTime, other.getCreationTime());
    }
}
