package Usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {
    public static void main(String[] args) {
//       int a= Stream.of(9,99,999,9999).mapToInt(i->i.intValue()).sum();
//        System.out.println(a);
//        Stream.of("my","name","khan").map(String::length).filter(i->i>2).collect(Collectors.toList()).forEach(System.out::println);
//        int result=Stream.of(1,3,44,54,23).reduce(1,Integer::max);
        Stream.iterate(1,n->n*10).limit(5).forEach(System.out::println);
//        System.out.println(result);
        long t1, t2;
        List<Employee> eList = new ArrayList<Employee>();
        for(int i=0; i<100; i++) {
            eList.add(new Employee("A", 20000));
            eList.add(new Employee("B", 3000));
            eList.add(new Employee("C", 15002));
            eList.add(new Employee("D", 7856));
            eList.add(new Employee("E", 200));
            eList.add(new Employee("F", 50000));
        }

        /***** Here We Are Creating A 'Sequential Stream' & Displaying The Result *****/
        t1 = System.currentTimeMillis();
        System.out.println("Sequential Stream Count?= " + eList.stream().filter(e -> e.getSalary() > 150).count());

        t2 = System.currentTimeMillis();
        System.out.println("Sequential Stream Time Taken?= " + (t2-t1) + "\n");

        /***** Here We Are Creating A 'Parallel Stream' & Displaying The Result *****/
        t1 = System.currentTimeMillis();
        System.out.println("Parallel Stream Count?= " + eList.parallelStream().filter(e -> e.getSalary() > 150).count());

        t2 = System.currentTimeMillis();
        System.out.println("Parallel Stream Time Taken?= " + (t2-t1));

    }
}

class Employee {
    String name;
    int salary;
    Employee(String name,int salary){
        this.name=name;
        this.salary=salary;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
