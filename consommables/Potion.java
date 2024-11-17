package consommables;

public class Potion {
    private final int soin;

    public Potion() {
        // La potion soigne 10 HP
        this.soin = 10; 
    }

    public int getSoin() {
        return soin;
    }

    @Override
    public String toString() {
        return "Potion de soin (+10HP)";
    }
}