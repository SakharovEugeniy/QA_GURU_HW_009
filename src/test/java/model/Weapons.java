package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weapons {

    @JsonProperty("Name")
    String name;

    @JsonProperty("ID")
    Integer id;

    @JsonProperty("W_Type")
    String weaponsType;

    @JsonProperty("chance_to_drop")
    Double chanceToDrop;

    @JsonProperty("characters_weapon")
    CharactersWeapon charactersWeapon;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getWeaponsType() {
        return weaponsType;
    }

    public Double getChanceToDrop() {
        return chanceToDrop;
    }

    public CharactersWeapon getCharactersWeapon() {
        return charactersWeapon;
    }
}

