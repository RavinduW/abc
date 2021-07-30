package com.test.abc.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class ProductEntity {
    private Integer productId;
    private String productName;
    private String price;
    private String expiredDate;
    private String gvtTaxEnabled;
    private String gvtTax;
    private PromotionEntity promotionByPromotionId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "expired_date")
    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Basic
    @Column(name = "gvt_tax_enabled")
    public String getGvtTaxEnabled() {
        return gvtTaxEnabled;
    }

    public void setGvtTaxEnabled(String gvtTaxEnabled) {
        this.gvtTaxEnabled = gvtTaxEnabled;
    }

    @Basic
    @Column(name = "gvt_tax")
    public String getGvtTax() {
        return gvtTax;
    }

    public void setGvtTax(String gvtTax) {
        this.gvtTax = gvtTax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(expiredDate, that.expiredDate) &&
                Objects.equals(gvtTaxEnabled, that.gvtTaxEnabled) &&
                Objects.equals(gvtTax, that.gvtTax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price, expiredDate, gvtTaxEnabled, gvtTax);
    }

    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id")
    public PromotionEntity getPromotionByPromotionId() {
        return promotionByPromotionId;
    }

    public void setPromotionByPromotionId(PromotionEntity promotionByPromotionId) {
        this.promotionByPromotionId = promotionByPromotionId;
    }
}
