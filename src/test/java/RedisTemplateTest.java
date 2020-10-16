import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/12 21:08
 * @Description:
 */
// 相当于ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
// 开spring ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-redis.xml")
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void stringTest() {

        ValueOperations operations = redisTemplate.opsForValue();

//        User user = new User("张三", 19, "男");
//        operations.set("user", user);
//
//        User user1 = (User) operations.get("user");
//
//        System.out.println(user1);
//
//        operations.set("count", 10);
//
//        int count = (Integer) operations.get("count");
//        System.out.println(count);

        operations.increment("count", 1);

        int count = (Integer) operations.get("count");
        System.out.println(count);
    }

    @Test
    public void mapTest() {

        HashOperations operations = redisTemplate.opsForHash();
        operations.put("user_2", "name", "李四");
    }

    @Test
    public void listTest() {

        ListOperations operations = redisTemplate.opsForList();
    }

    @Test
    public void setTest() {

        SetOperations operations = redisTemplate.opsForSet();
    }


}
