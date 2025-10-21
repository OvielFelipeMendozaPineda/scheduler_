package co.com.scheduler.model.event;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Event {

    private LocalDate date;
    private UUID outfitId;
    private UUID hairstyleId;
    private List<Dancer> Dancers;

    public Event() {}

    public Event(LocalDate date, UUID outfitId, UUID hairstyleId, List<Dancer> dancers) {
        this.date = date;
        this.outfitId = outfitId;
        this.hairstyleId = hairstyleId;
        Dancers = dancers;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public List<Dancer> getDancers() {
        return Dancers;
    }

    public void setDancers(List<Dancer> dancers) {
        Dancers = dancers;
    }
}
