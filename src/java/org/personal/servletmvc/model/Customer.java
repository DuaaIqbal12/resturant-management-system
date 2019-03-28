package org.personal.servletmvc.model;

public class Customer {
    
    private int customer_id;
    
    private String name;
    
    private int phone_no;
    
    private int table_no;

    public int getId() {
        return customer_id;
    }

    public void setId(int id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPhone() {
        return phone_no;
    }

    public void setPhone(int phone_no) {
        this.phone_no = phone_no;
    }

    public int getTable() {
        return table_no;
    }

    public void setTable(int table_no) {
        this.table_no = table_no;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + customer_id + ", name=" + name + ", phone_no=" + phone_no + ", table_no=" + table_no + '}';
    }
}   