import com.noah.demo.MybatisMultApplication;
import com.noah.demo.db1.service.UserService;
import com.noah.demo.db2.service.SalaryService;
import com.noah.demo.domain.Salary;
import com.noah.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName test
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 10:34
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisMultApplication.class)
public class test {

    @Autowired
    private UserService userService;

    @Autowired
    private SalaryService salaryService;

    @Test
    public void testUser(){
        User yangzheng = userService.findUserByName("yangzheng");
        System.out.println(yangzheng.toString());
    }

    @Test
    public void testSalary(){
        Salary byUserId = salaryService.findByUserId(123L);
        System.out.println(byUserId);
    }
}
