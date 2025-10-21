package co.com.scheduler.model.outfit;

import java.util.UUID;

public class Outfit {
    
    private UUID id;
    private string name;

    public Outfit(){}

    public UUID getId() {
        return id;
    }

    public Outfit(UUID id, string name) {
        this.id = id;
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }
}
