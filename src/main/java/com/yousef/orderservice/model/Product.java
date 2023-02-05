package com.yousef.orderservice.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    private Integer quantityOnHand;

    public Set<Category> getCategories() {
        return categories;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (getProductStatus() != product.getProductStatus()) return false;
        if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null)
            return false;
        if (getCategories() != null ? !getCategories().equals(product.getCategories()) : product.getCategories() != null)
            return false;
        return getQuantityOnHand() != null ? getQuantityOnHand().equals(product.getQuantityOnHand()) : product.getQuantityOnHand() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getProductStatus() != null ? getProductStatus().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getCategories() != null ? getCategories().hashCode() : 0);
        result = 31 * result + (getQuantityOnHand() != null ? getQuantityOnHand().hashCode() : 0);
        return result;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

}
