import org.junit.Test;

/**
 * @ClassName test
 * @Description TODO
 * @Author noah
 * @Date 2019-11-04 14:42
 * @Version 1.0
 **/

public class test {
    String a = "a";

    boolean b;

    @Test
    public void test(){
        String a = "AB123";
        String b = "ab123";
        String c = "123123";
        String regex = "^[A-Z][A-Z].*";
        System.out.println(a.matches(regex));
        System.out.println(b.matches(regex));
        System.out.println(c.matches(regex));
    }

    @Test
    public void test2(){
        String a = "a1";
        System.out.println(a);
        System.out.println(this.a);
    }

    @Test
    public void test3(){
        System.out.println(b);
    }

    @Test
    public void test4(){

    }
}
