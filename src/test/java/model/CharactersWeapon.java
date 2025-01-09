package model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CharactersWeapon {

    @JsonProperty("damage_min")
    Integer damageMin;

    @JsonProperty("damage_max")
    Integer damageMax;

    @JsonProperty("critical_chance")
    Double criticalChance;

    public Integer getDamageMin() {
        return damageMin;
    }

    public Integer getDamageMax() {
        return damageMax;
    }

    public Double getCriticalChance() {
        return criticalChance;
    }
}
