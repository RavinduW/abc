package com.test.abc.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "promotion")
public class PromotionEntity {
    private Integer promotionId;
    private String offer;
    private Collection<ProductEntity> productsByPromotionId;
    private SeasonEntity seasonBySeasonId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    @Basic
    @Column(name = "offer")
    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionEntity that = (PromotionEntity) o;
        return Objects.equals(promotionId, that.promotionId) &&
                Objects.equals(offer, that.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(promotionId, offer);
    }

    @OneToMany(mappedBy = "promotionByPromotionId")
    public Collection<ProductEntity> getProductsByPromotionId() {
        return productsByPromotionId;
    }

    public void setProductsByPromotionId(Collection<ProductEntity> productsByPromotionId) {
        this.productsByPromotionId = productsByPromotionId;
    }

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "season_id", nullable = false)
    public SeasonEntity getSeasonBySeasonId() {
        return seasonBySeasonId;
    }

    public void setSeasonBySeasonId(SeasonEntity seasonBySeasonId) {
        this.seasonBySeasonId = seasonBySeasonId;
    }
}
