package com.shenchao.domain.config.jpa.entity;

import javax.persistence.*;

/**
 * Created by shenchao on 2017/2/3.
 */
@Entity
@Table(name = "my_user", schema = "bos19", catalog = "")
public class MyUser {
    private Integer id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyUser myUser = (MyUser) o;

        if (id != null ? !id.equals(myUser.id) : myUser.id != null) return false;
        if (name != null ? !name.equals(myUser.name) : myUser.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
