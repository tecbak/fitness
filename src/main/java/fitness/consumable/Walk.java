package fitness.consumable;

import java.time.LocalDateTime;

public final class Walk implements Consumable {
    private final int steps;
    private final LocalDateTime dateTime;

    public Walk(int steps, LocalDateTime dateTime) {
        this.steps = steps;
        this.dateTime = dateTime;
    }

    @Override
    public int volume() {
        return steps;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
