package com.brickcat.learn.moudle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by mzk on 2017/3/30.
 */
@Component//把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
public class LearnProperties {
    //通过@Value("${属性名}")注解来加载对应的配置属性
    @Value("${com.brick.name}")
    private String name;
    @Value("${com.brick.title}")
    private String title;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
