package com.brickcat.moudle;

import javax.persistence.*;

/**
 * Created by Seven on 17/3/29.
 */
@Entity
@Table(name = "_deparment")
public class Deparment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Deparment(){

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
