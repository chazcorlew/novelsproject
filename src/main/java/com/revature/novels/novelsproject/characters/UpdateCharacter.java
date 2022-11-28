package com.revature.novels.novelsproject.characters;

import java.util.Objects;

public class UpdateCharacter {

    public String charId;

    public String fullName;

    public boolean mainProtagonist;

    public boolean adaptedForAnime;




    public UpdateCharacter(){
        super ();
    }


    public UpdateCharacter (String charId, String fullName, boolean mainProtagonist, boolean adaptedForAnime){
        this.charId = charId;
        this.fullName = fullName;
        this.mainProtagonist = mainProtagonist;
        this.adaptedForAnime = adaptedForAnime;


    }

    public String getCharId() {
        return charId;
    }

    public void setCharId(String charId) {
        this.charId = charId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isMainProtagonist() {
        return mainProtagonist;
    }

    public void setMainProtagonist(boolean mainProtagonist) {
        this.mainProtagonist = mainProtagonist;
    }

    public boolean isAdaptedForAnime() {
        return adaptedForAnime;
    }

    public void setAdaptedForAnime(boolean adaptedForAnime) {
        this.adaptedForAnime = adaptedForAnime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateCharacter)) return false;
        UpdateCharacter that = (UpdateCharacter) o;
        return isMainProtagonist() == that.isMainProtagonist() && isAdaptedForAnime() == that.isAdaptedForAnime() && getCharId().equals(that.getCharId()) && getFullName().equals(that.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharId(), getFullName(), isMainProtagonist(), isAdaptedForAnime());
    }

    @Override
    public String toString() {
        return "UpdateCharacter{" +
                "charId='" + charId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mainProtagonist=" + mainProtagonist +
                ", adaptedForAnime=" + adaptedForAnime +
                '}';
    }
}
