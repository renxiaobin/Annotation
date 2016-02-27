package com.rxb.ann2;

/**
 * Created by rxb14 on 2016/2/26.
 */
@Table("user")
public class Filter {

    @Column("id")
    int id;

    @Column("age")
    int age;

    @Column("user_name")
    String userName;

    @Column("address")
    String address;

    @Column("email")
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
