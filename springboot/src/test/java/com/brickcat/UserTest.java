package com.brickcat;

import com.brickcat.user.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Seven on 17/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class UserTest {
    private MockMvc mvc;
    @Before
    public void SetUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    @Test
    public void testUserController() throws Exception{
        RequestBuilder request = null;

        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        request = MockMvcRequestBuilders.post("/users/").param("id","1").param("name","测试大师").param("age","20");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

        request = MockMvcRequestBuilders.put("/users/1").param("name","测试终极大师").param("age","23");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        request = MockMvcRequestBuilders.get("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":23}")));

        request = MockMvcRequestBuilders.delete("/users/1");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }
}
