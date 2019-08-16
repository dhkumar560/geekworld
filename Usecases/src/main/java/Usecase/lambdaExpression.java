package Usecase;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class lambdaExpression {
    public static void main(String[] args) {
//        Runnable r = ()->{
//            for(int i=0;i<10;i++){
//                System.out.println("child thread");
//            }
//        };
//        new Thread(r).start();
        Predicate<String> p1= s-> s.length()>5;
        Predicate<String> p2= s->s.length()<10;
        System.out.println(p1.or(p2).test("ABCDFG22222222"));
        Map<String,Integer> map =new HashMap<>();
        map.put("A",1234);
        map.put("B",2345);
        map.put("C",123);
        map.forEach((k,v)->{
            System.out.println(k+": :"+v);
        });

        String r =map.entrySet().stream().filter(p->p.getValue()>22).map(v->v.getValue().toString()).collect(Collectors.joining(","));
        System.out.println(r);
    }



}
