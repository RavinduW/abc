package com.test.abc.dto;

public class Product {

    private String productId;
    private String name;
    private String price;
    private String expiredDate;
    private String isGovernmentTaxEnabled;
    private String governmentTax;

    private Promotion promotion;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }


    public String getIsGovernmentTaxEnabled() {
        return isGovernmentTaxEnabled;
    }

    public void setIsGovernmentTaxEnabled(String isGovernmentTaxEnabled) {
        this.isGovernmentTaxEnabled = isGovernmentTaxEnabled;
    }

    public String getGovernmentTax() {
        return governmentTax;
    }

    public void setGovernmentTax(String governmentTax) {
        this.governmentTax = governmentTax;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
