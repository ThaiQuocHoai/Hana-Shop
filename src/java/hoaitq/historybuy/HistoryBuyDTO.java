/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.historybuy;

import java.io.Serializable;

/**
 *
 * @author QH
 */
public class HistoryBuyDTO implements Serializable{
    private String nameCus;
    private String address;
    private String phoneNum;
    private String nameFood;
    private int quantity;
    private String date;

    public HistoryBuyDTO() {
    }

    public HistoryBuyDTO(String nameCus, String address, String phoneNum, String nameFood, int quantity, String date) {
        this.nameCus = nameCus;
        this.address = address;
        this.phoneNum = phoneNum;
        this.nameFood = nameFood;
        this.quantity = quantity;
        this.date = date;
    }

    /**
     * @return the nameCus
     */
    public String getNameCus() {
        return nameCus;
    }

    /**
     * @param nameCus the nameCus to set
     */
    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum the phoneNum to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * @return the nameFood
     */
    public String getNameFood() {
        return nameFood;
    }

    /**
     * @param nameFood the nameFood to set
     */
    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    
    
    
}
