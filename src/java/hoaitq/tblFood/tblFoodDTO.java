/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.tblFood;

import java.io.Serializable;

/**
 *
 * @author QH
 */
public class tblFoodDTO implements Serializable{
    private int idFood;
    private String nameFood;
    private String image;
    private String description;
    private float price;
    private int quantity;
    private int categoryID;
    private String createDate;
    private String invalidDate;
    private int isDelete;

    public tblFoodDTO() {
    }

    public tblFoodDTO(int idFood, String nameFood, String image, String description, float price, int quantity, int categoryID, String createDate, String invalidDate, int isDelete) {
        this.idFood = idFood;
        this.nameFood = nameFood;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.createDate = createDate;
        this.invalidDate = invalidDate;
        this.isDelete = isDelete;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(String invalidDate) {
        this.invalidDate = invalidDate;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    



    
}
