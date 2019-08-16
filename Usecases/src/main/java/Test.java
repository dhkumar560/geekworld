import org.apache.commons.lang3.reflect.ConstructorUtils;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.function.BiFunction;


public class Test<T>  {
    public static void main(String[] args) {
        Random r = new Random();
        r.ints().limit(15).sorted().forEach(System.out::print);

//        Stream.iterate(new long[]{ 1, 1 }, p->new long[]{ p[1], p[0]+p[1] })
//                .limit(9).forEach(p->System.out.println(p[0]));
//        Test t= new Test();
//        Task task=(Task)t.newInstance.apply(Task.class,convert("name","uuid",new Long(0),"description","team","assignee",true,true));
//        System.out.println(task.getAssignee());
    }



    public static final Object[] convert(Object ...args){
        return args;

    }

    private final BiFunction<Class<T>, Object[],T> newInstance = (classToInstantiate, args) -> {
        try {
            return ConstructorUtils.invokeConstructor(classToInstantiate, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };
}
