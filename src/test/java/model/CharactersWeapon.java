package model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CharactersWeapon {

    @JsonProperty("damage_min")
    Integer damageMin;

    @JsonProperty("damage_max")
    Integer damageMax;

    @JsonProperty("critical_chance")
    Double criticalChance;

    public CharactersWeapon() {

    }

    public CharactersWeapon(Integer damageMin, Integer damageMax, Double criticalChance) {
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.criticalChance = criticalChance;
    }

    public Integer getDamageMin() {
        return damageMin;
    }

    public void setDamageMin(Integer damageMin) {
        this.damageMin = damageMin;
    }

    public Integer getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(Integer damageMax) {
        this.damageMax = damageMax;
    }

    public Double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(Double criticalChance) {
        this.criticalChance = criticalChance;
    }
}
