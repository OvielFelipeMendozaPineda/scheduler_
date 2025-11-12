package co.com.scheduler.model.outfit.model;

import java.util.UUID;

public class Outfit {

    private UUID id;
    private String name;

    public Outfit(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
    public Outfit() {}

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {this.id = id;}
    public void setName(String name) {this.name = name;}
}
