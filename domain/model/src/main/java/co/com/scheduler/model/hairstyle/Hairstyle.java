package co.com.scheduler.model.hairstyle;

import java.util.UUID;

public class Hairstyle {
    
    private UUID id;
    private String name;

    public Hairstyle() {}

    public UUID getId() {
        return id;
    }

    public Hairstyle(UUID id, String name) {
        this.id = id;
        this.name = name;
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
}
