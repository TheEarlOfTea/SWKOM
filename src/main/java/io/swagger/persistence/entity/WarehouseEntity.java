package io.swagger.persistence.entity;

import io.swagger.model.WarehouseNextHops;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class WarehouseEntity extends HopEntity{

    @NotNull(message = "level may not be null")
    @Min(value = 0, message = "level must be 0 or higher")
    private int level;
    @NotNull(message = "Next Hop list may not be null")
    private List<WarehouseNextHops> nextHops;

    @Override
    public String toString() {
        return "WarehouseEntity{" +
                "level=" + level +
                ", nextHops=" + nextHops +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<WarehouseNextHops> getNextHops() {
        return nextHops;
    }

    public void setNextHops(List<WarehouseNextHops> nextHops) {
        this.nextHops = nextHops;
    }
}
