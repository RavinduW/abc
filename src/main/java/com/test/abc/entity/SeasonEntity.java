package com.test.abc.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "season")
public class SeasonEntity {
    private Integer seasonId;
    private String seasonName;
    private Collection<PromotionEntity> promotionsBySeasonId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id")
    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    @Basic
    @Column(name = "season_name")
    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeasonEntity that = (SeasonEntity) o;
        return Objects.equals(seasonId, that.seasonId) &&
                Objects.equals(seasonName, that.seasonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonId, seasonName);
    }

    @OneToMany(mappedBy = "seasonBySeasonId")
    public Collection<PromotionEntity> getPromotionsBySeasonId() {
        return promotionsBySeasonId;
    }

    public void setPromotionsBySeasonId(Collection<PromotionEntity> promotionsBySeasonId) {
        this.promotionsBySeasonId = promotionsBySeasonId;
    }
}
