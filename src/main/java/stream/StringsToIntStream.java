package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringsToIntStream {
    public Stream<Integer> convertToIntStream(String input) {
        return input.lines().mapToInt(Integer::valueOf).boxed();
    }

    public long totalIntegersInStream(String input) {
        return convertToIntStream(input).count();
    }

    public Stream<Integer> highestIntegersInStream(String input) {
        return convertToIntStream(input).sorted(Comparator.reverseOrder()).limit(3);
    }

    public Stream<Integer> convertToDistinctIntStream(String input) {
        return convertToIntStream(input).distinct();
    }


    public long sumOfIntegersInStream(String input) {
        return input.lines().mapToInt(Integer::valueOf)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::valueOf)
                .sum();
    }


    private static IntStream getSumForDoubleLinesSeparate(String input) {
        String[] blocks = input.split("\\n\\n");
        return Arrays.stream(blocks).mapToInt(StringsToIntStream::sum);
    }

    private static int sum(String input) {
        return input.lines().mapToInt(Integer::parseInt).sum();
    }

    public static void main(String[] args) {
        StringsToIntStream test = new StringsToIntStream();
        String input = "1000\n" + "2000\n" + "3000";
        System.out.println(test.totalIntegersInStream(input));
        System.out.println(test.highestIntegersInStream(input));
    }

}