import com.noah.demo.JpaApplication;
import com.noah.demo.entity.Person;
import com.noah.demo.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName JpaTest
 * @Description TODO
 * @Author noah
 * @Date 2019-10-14 18:01
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class JpaTest {

    @Autowired
    private PersonRepository repository;

    @Test
    public void conditionQueryTest(){
        List<Person> byAgeGreaterThan = repository.findByAgeGreaterThan(1);
    }

    @Test
    public void saveTest(){
        Person zhengge = new Person("zhengge", 20);
        repository.save(zhengge);
        Person zhengge1 = repository.findByName("zhengge");
        System.out.println(zhengge1.toString());
    }
}
