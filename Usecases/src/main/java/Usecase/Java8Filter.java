package Usecase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Filter {

    public static void main(String[] args) {
        Map<String, String> map1= new HashMap<>();
        Map<String, String> map2= new HashMap<>();
        Map<String, String> map3= new HashMap<>();
        Map<String, String> map4= new HashMap<>();

        map1.put("A","1");
        map1.put("B","2");

        map2.put("C","3");
        map2.put("D","4");

        map3.put("E","5");
        map3.put("F","6");

        map4.put("G","7");
        map4.put("H","8");

        List<Map<String,String>> list = new ArrayList<>();

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);


        List<String> ress = list.stream().flatMap(
                x -> x.values().
                        stream()).
                filter(y -> !y.equalsIgnoreCase("3")).
                collect(Collectors.toList());

        System.out.println(ress);
          /*List<List<String>> res = list.stream().map(
            map -> map.values().stream()
                    .filter(x -> !x.equalsIgnoreCase("5"))
                    .collect(Collectors.toList())

    ).collect(Collectors.toList());

    List<String> res1 = res.stream().flatMap(e -> e.stream()).collect(Collectors.toList());

    System.out.println(String.join(",", res1));
*/
    }
}
