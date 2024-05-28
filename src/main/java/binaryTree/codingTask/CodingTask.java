package binaryTree.codingTask;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CodingTask {
    public static String getTestString(){
        log.info("Printing Test String");
        return "Hello World";
    }

    public static void main(String args[]) {
        System.out.println(getTestString());
    }

}
