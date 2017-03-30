package com.brickcat;

import com.brickcat.learn.moudle.LearnProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by mzk on 2017/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class PropertiesTest {
    @Autowired
    private LearnProperties learnProperties;



    @Test
    public void Properties() throws Exception{
        Assert.assertEquals("搬砖猫",learnProperties.getName());
        Assert.assertEquals("程序员到架构师的搬砖之路",learnProperties.getTitle());
    }
}
