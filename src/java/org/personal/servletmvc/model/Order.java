package org.personal.servletmvc.model;

public class Order {
    
    private int id;
    
    private String dishName;
    
    private int price;
    
    private int quantity;
    
    private String category;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", dishName=" + dishName + ", price=" + price + ", quantity=" + quantity + ", category=" + category +'}';
    }
}