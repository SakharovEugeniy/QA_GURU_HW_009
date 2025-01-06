package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public  class Weapons {

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

    public Weapons(String name, Integer id, String weaponsType, Double chanceToDrop, CharactersWeapon charactersWeapon) {
        this.name = name;
        this.id = id;
        this.weaponsType = weaponsType;
        this.chanceToDrop = chanceToDrop;
        this.charactersWeapon = charactersWeapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeaponsType() {
        return weaponsType;
    }

    public void setWeaponsType(String weaponsType) {
        this.weaponsType = weaponsType;
    }

    public Double getChanceToDrop() {
        return chanceToDrop;
    }

    public void setChanceToDrop(Double chanceToDrop) {
        this.chanceToDrop = chanceToDrop;
    }

    public CharactersWeapon getCharactersWeapon() {
        return charactersWeapon;
    }

    public void setCharactersWeapon(CharactersWeapon charactersWeapon) {
        this.charactersWeapon = charactersWeapon;
    }
}

