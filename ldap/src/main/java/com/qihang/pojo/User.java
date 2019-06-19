package com.qihang.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User implements Serializable{
    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String  id;

    private String name;

    private Integer age;

}
