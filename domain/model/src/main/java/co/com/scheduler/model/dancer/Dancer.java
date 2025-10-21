package co.com.scheduler.model.dancer;

import java.util.UUID;

public class Dancer {
    
    private UUID id;
    private String name; 
    private String lastName; 
    private UUID outfitId; 
    private UUID hairstyleId;

    public Dancer() {}

    public Dancer(UUID id, String name, String lastName, UUID outfitId, UUID hairstyleId) {
        
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.outfitId = outfitId;
        this.hairstyleId = hairstyleId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getOutfitId() {
        return outfitId;
    }

    public void setOutfitId(UUID outfitId) {
        this.outfitId = outfitId;
    }

    public UUID getHairstyleId() {
        return hairstyleId;
    }

    public void setHairstyleId(UUID hairstyleId) {
        this.hairstyleId = hairstyleId;
    }
}
