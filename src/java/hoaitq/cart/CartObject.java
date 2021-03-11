/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author QH
 */
public class CartObject implements Serializable {

    private Map<String, CartDTO> cart;

    public Map<String, CartDTO> getCart() {
        return cart;
    }

    public void addItem(String id, int quantity, String name, float price, String image) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        CartDTO dto = null;
        if (this.cart.containsKey(id)) {
            quantity += this.cart.get(id).getQuantity();
            dto = this.cart.get(id);
            dto.setQuantity(quantity);
        } else {
            dto = new CartDTO(id, name, image, price, quantity);
        }
        this.cart.put(id, dto);

    }

    public void removeItem(String id) {
        if (this.cart == null) {
            return;
        }

        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
            if (this.cart.isEmpty()) {
                this.cart = null;
            }
        }
    }
}
