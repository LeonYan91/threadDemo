package com.yanliang.entity;

/**
 * @author yanliang
 * @ClassName Person
 * @Description
 * @Date 2016/5/20
 */
public class Person {

    private String name;

    private Integer id;

    private String identityId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", identityId='" + identityId + '\'' +
                '}';
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }
}
