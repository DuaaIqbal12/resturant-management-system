package org.personal.servletmvc.model;

public class Menu {
    
    private int menu_id;
    
    private String dishItem;
        
    private int price;
    
    private String type;

    private String image;
    
    public int getId() {
        return menu_id;
    }

    public void setId(int id) {
        this.menu_id = menu_id;
    }

    public String getDishItem() {
        return dishItem;
    }

    public void setDishItem(String dishItem) {
        this.dishItem = dishItem;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + menu_id + ", dishItem=" + dishItem + ", price=" + price + ", type=" + type + '}';
    }
}