package com.example.Collectors;

import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {

        String paragraph = "java is powerful and java is fast";

        Map<String, Integer> wordCount =
            Arrays.stream(paragraph.split("\\s+"))
                  .collect(Collectors.toMap(
                      word -> word,     
                      word -> 1,         
                      Integer::sum      
                  ));

        System.out.println(wordCount);
    }
}

