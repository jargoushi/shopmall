import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/12 20:48
 * @Description:
 */
public class JedisTest {

    private static JedisPool pool = null;

    static {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(50);
        config.setMinIdle(10);

        pool = new JedisPool(config, "localhost", 6379);
    }

    @Test
    public void StringTest() {

        // 1. 创建jedis对象
//        Jedis jedis = new Jedis("localhost", 6379);
        Jedis jedis = pool.getResource();
        // 2. 存取数据
//        jedis.set("name", "张三");
//
//        String s = jedis.get("name");
//        System.out.println(s);

//        jedis.mset("name", "李四", "age", "18");


//        jedis.incr("age");

        List<String> mget = jedis.mget("name", "age");

        for (String s : mget) {
            System.out.println(s);
        }


        jedis.close();
    }




    @Test
    public void HashTest() {

        Jedis jedis = pool.getResource();

        jedis.hset("user_1", "name", "张三");


    }

    @Test
    public void ListTest() {


    }

    @Test
    public void SetTest() {


    }

}
