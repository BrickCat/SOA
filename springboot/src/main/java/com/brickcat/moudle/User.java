package com.brickcat.moudle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Seven on 17/3/29.
 */
@Entity//实体类
@Table(name = "_user")//对应的数据库表明
public class User {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")//格式化显示时间
    private Date createdate;
    @ManyToOne//多对一
    @JoinColumn(name = "did")//关联的字段
    @JsonBackReference//防止对象递归引用
    private Deparment deparment;
    @ManyToMany(cascade = {},fetch = FetchType.EAGER)//多对多
    /*
    * 1.cascade 默认值：CascadeType 的空数组。 默认情况下，不会将任何持续性操作层叠到关联的目标
    * 2.fetch 默认值：FetchType.EAGER.默认情况下， 持续性提供程序使用获取类型 EAGER：这将要求持续性提供程序运行时必须迫切获取数据.
    * */
    @JoinTable(name = "user_role",//关联的表
    joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    /*
    * 1.joinColumns是主操作表的中间表列，而inverseJoinColumns是副操作表的中间表列
    * */
    private List<Role> roles;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setDeparment(Deparment deparment) {
        this.deparment = deparment;
    }

    public Deparment getDeparment() {
        return deparment;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
