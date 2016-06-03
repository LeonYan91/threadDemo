
import com.yanliang.repository.PersonMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanliang
 * @ClassName Application
 * @Description
 * @Date 2016/5/19
 */
@EnableAutoConfiguration
@RestController
public class Application {

    @Autowired
    PersonMapper personMapper;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class,args);

//        String[] beanNames = context.getBeanDefinitionNames();
//
//        Arrays.sort(beanNames);
//
//        for(String beanName : beanNames){
//
//            System.out.println(beanName);
//        }

//        SQL sql = new Application.MySql(new Application());

    }

    @RequestMapping("/")
    public String home(){
        System.out.println(personMapper.selectPerson(1L));
        return "home";
    }


}
