package Usecase;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8ForEach {
    public static void main(String[] args) {
        Map<String,Integer> p = new HashMap<>();
        p.put("A",123);
        p.put("B",1234);
        p.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
        Stream.of(1,3,5,6).mapToInt(i->i.intValue()).sorted().forEach(System.out::println);
        System.out.println(Stream.of("I","AM","GIA").filter(i->i.equals("AMA")).findAny().orElse("No Found"));
        List<String> items = Arrays.asList("apple", "apple", "banana","apple", "orange", "banana", "papaya");

        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        Map<String,Integer> map = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue)->oldValue,LinkedHashMap::new));
        map.forEach((k,v)-> System.out.println(k+":::"+v));
    }
}
