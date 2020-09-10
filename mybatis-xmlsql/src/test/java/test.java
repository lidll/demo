import com.noah.demo.XmlSqlApplication;
import com.noah.demo.domain.User;
import com.noah.demo.service.PeopleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName test
 * @Description TODO
 * @Author noah
 * @Date 2020-05-03 23:17
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = XmlSqlApplication.class)
public class test {

    @Autowired
    private PeopleService peopleService;

    @Test
    public void testConfig(){
        User yangzheng = peopleService.getUserByName("yangzheng");
        System.out.println(yangzheng);
    }
}
