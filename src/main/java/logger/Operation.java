package logger;

import productApp.entities.Product;
import productApp.entities.User;

import java.util.HashMap;
import java.util.Map;

public class Operation {

    private User approvedBy;

    private Product product;

    private CRUD typeOp;


    public Operation(User approvedBy, Product product, CRUD crud) {
        this.approvedBy = approvedBy;
        this.product = product;
        this.typeOp = crud;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public CRUD getTypeOp() {
        return typeOp;
    }

    public Product getProduct() {
        return product;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTypeOp(CRUD typeOp) {
        this.typeOp = typeOp;
    }

    public Map<String, Object> toMap() {

        Map<String, Object> maps = new HashMap<>();

        maps.put("Approved By", getApprovedBy().getUserName() );
        maps.put("Product", getProduct().toMap() );
        maps.put("Operation Type", getTypeOp().toString() );

        return maps;
    }

}
