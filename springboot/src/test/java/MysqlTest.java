import com.brickcat.moudle.Deparment;
import com.brickcat.moudle.Role;
import com.brickcat.moudle.User;
import com.brickcat.repository.DepartmentRepository;
import com.brickcat.repository.RoleRepostiory;
import com.brickcat.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;


import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;

/**
 * Created by mzk on 2017/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
@ImportResource({"classpath:application.yml"})
public class MysqlTest {
    private static Logger logger = (Logger) LoggerFactory.getLogger(MysqlTest.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    RoleRepostiory roleRepostiory;
    @Before
    public  void initData(){
        userRepository.deleteAll();
        roleRepostiory.deleteAll();
        departmentRepository.deleteAll();
        Deparment deparment = new Deparment();
        deparment.setName("开发部");
        departmentRepository.save(deparment);
        //断言，既传入的对象不能为空，为空则抛出异常，message：异常信息
        Assert.notNull(deparment.getId(),"");
        Role role = new Role();
        role.setName("admin");
        roleRepostiory.save(role);
        Assert.notNull(role.getId(),"");
        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDeparment(deparment);
        List<Role> roles = roleRepostiory.findAll();
        Assert.notNull(roles,"");
        user.setRoles(roles);
        userRepository.save(user);
        Assert.notNull(user.getId(),"");

    }
    @Test
    public void findpage(){
        Pageable  pageable = new PageRequest(0,10,new Sort(Sort.Direction.ASC,"id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.notNull(page,"");
        for(User user : page.getContent()){
            logger.info("====user====user name:{},department name{},role name{}",user.getName(),user.getDeparment().getName(),user.getRoles().get(0).getName());
        }
    }
}
