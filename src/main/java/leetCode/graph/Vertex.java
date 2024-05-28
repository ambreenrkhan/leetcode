package leetCode.graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Vertex<T> {
    private T value;

    public Vertex(T value){
        this.value = value;
    }

}
