package com.rxb.ann;

/**
 * Created by rxb14 on 2016/2/26.
 */
@Table("department")
public class Filter2 {
    @Column("id")
    int id;

    @Column("amount")
    int amount;

    @Column("name")
    String name;

    @Column("address")
    String address;

    @Column("lead")
    String lead;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }
}
