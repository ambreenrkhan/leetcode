package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtil {
    public Map<String,Integer> convertToIncrementalIndexMap(List<String> values){
        AtomicInteger integer = new AtomicInteger();
        return values.stream().collect(Collectors.toMap(s->s,s->integer.incrementAndGet()));
    }

    public List<String> filteredSorted(List<String> values){
        return values.stream().filter(value -> value.startsWith("B")).distinct().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public Map<String,String> splitStringAndConvertToMap(List<String> values){
        return values.stream().filter(value -> value.length()>5).distinct().collect(Collectors.toMap(value -> value.substring(0,2), value->value.substring(2)));
    }

    public Map<String,String> splitStringAndFunctionIdentityToMap(List<String> values){
        return values.stream().filter(value -> value.length()>5).distinct().collect(Collectors.toMap(value -> value.substring(0,2), Function.identity(), (first,second)->second));
    }


    public List<Transaction> mapToObject(List<String> values){
        return values.stream().mapToLong(Long::valueOf).boxed().map(Transaction::new).collect(Collectors.toList());
    }


    public static void main(String args[]){
        StreamUtil streamUtil = new StreamUtil();
        System.out.println(streamUtil.convertToIncrementalIndexMap(Arrays.asList("Hello", "How","Bye","bye")));
        System.out.println(streamUtil.filteredSorted(Arrays.asList("Hello", "How","Bye","Bye","wewe","Banana", "Ballon")));
        System.out.println(streamUtil.splitStringAndConvertToMap(Arrays.asList("HELLOWHOWAREYOU","BYEBYE","MOVB","LALALALALALA","2")));
        System.out.println(streamUtil.splitStringAndFunctionIdentityToMap(Arrays.asList("HELLOWHOWAREYOU","BYEBYE","MOVB","LALALALALALA","LALALALAL")));
        System.out.println(streamUtil.mapToObject(Arrays.asList("2323232","34444","33333")));

    }
}
