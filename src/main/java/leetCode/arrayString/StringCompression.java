package leetCode.arrayString;

public class StringCompression {
    public int compress(char[] chars) {
        if(chars.length<=1){
            return chars.length;
        }

        char currentChar = '\u0000';
        int currentCount = 0;
        int currentIndex = -1;
        for (char ch : chars) {
            if (ch != currentChar) {
                if (currentChar != '\u0000') {
                    currentIndex = appendCharAndCount(currentChar, currentCount, chars, currentIndex);
                }
                currentChar = ch;
                currentCount = 1;

            } else {
                currentCount++;
            }
        }

        // append last character
        currentIndex = appendCharAndCount(currentChar, currentCount, chars, currentIndex);

        return ++currentIndex;
    }

    private int appendCharAndCount(char ch, int count, char[] input, Integer currentIndex){
        input[++currentIndex] = ch;
        if(count > 1){
            String countStr = String.valueOf(count);
            for(int i = 0; i< countStr.length(); i++){
                input[++currentIndex] = countStr.charAt(i);
            }
        }

        return currentIndex;
    }

    public static void main(String[] args){
        StringCompression sc = new StringCompression();
        char[] input = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(sc.compress(input));
    }
}
