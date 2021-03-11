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
public class tblFoodError implements Serializable{
    private String idFoodError;
    private String nameFoodError;
    private String imageError;
    private String descriptionError;
    private String priceError;
    private String quantityError;
    private String categoryIDError;
    private String createDateError;
    private String invalidDateError;
    private String isDeleteError;

    /**
     * @return the idFoodError
     */
    public String getIdFoodError() {
        return idFoodError;
    }

    /**
     * @param idFoodError the idFoodError to set
     */
    public void setIdFoodError(String idFoodError) {
        this.idFoodError = idFoodError;
    }

    /**
     * @return the nameFoodError
     */
    public String getNameFoodError() {
        return nameFoodError;
    }

    /**
     * @param nameFoodError the nameFoodError to set
     */
    public void setNameFoodError(String nameFoodError) {
        this.nameFoodError = nameFoodError;
    }

    /**
     * @return the imageError
     */
    public String getImageError() {
        return imageError;
    }

    /**
     * @param imageError the imageError to set
     */
    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    /**
     * @return the descriptionError
     */
    public String getDescriptionError() {
        return descriptionError;
    }

    /**
     * @param descriptionError the descriptionError to set
     */
    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    /**
     * @return the priceError
     */
    public String getPriceError() {
        return priceError;
    }

    /**
     * @param priceError the priceError to set
     */
    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    /**
     * @return the quantityError
     */
    public String getQuantityError() {
        return quantityError;
    }

    /**
     * @param quantityError the quantityError to set
     */
    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    /**
     * @return the categoryIDError
     */
    public String getCategoryIDError() {
        return categoryIDError;
    }

    /**
     * @param categoryIDError the categoryIDError to set
     */
    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }

    /**
     * @return the createDateError
     */
    public String getCreateDateError() {
        return createDateError;
    }

    /**
     * @param createDateError the createDateError to set
     */
    public void setCreateDateError(String createDateError) {
        this.createDateError = createDateError;
    }

    /**
     * @return the invalidDateError
     */
    public String getInvalidDateError() {
        return invalidDateError;
    }

    /**
     * @param invalidDateError the invalidDateError to set
     */
    public void setInvalidDateError(String invalidDateError) {
        this.invalidDateError = invalidDateError;
    }

    /**
     * @return the isDeleteError
     */
    public String getIsDeleteError() {
        return isDeleteError;
    }

    /**
     * @param isDeleteError the isDeleteError to set
     */
    public void setIsDeleteError(String isDeleteError) {
        this.isDeleteError = isDeleteError;
    }

    public tblFoodError() {
    }

    public tblFoodError(String idFoodError, String nameFoodError, String imageError, String descriptionError, String priceError, String quantityError, String categoryIDError, String createDateError, String invalidDateError, String isDeleteError) {
        this.idFoodError = idFoodError;
        this.nameFoodError = nameFoodError;
        this.imageError = imageError;
        this.descriptionError = descriptionError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.categoryIDError = categoryIDError;
        this.createDateError = createDateError;
        this.invalidDateError = invalidDateError;
        this.isDeleteError = isDeleteError;
    }
    
    
    
}
