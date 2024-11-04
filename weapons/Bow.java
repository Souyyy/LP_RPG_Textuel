package weapons;

public class Bow extends Weapon {

    private static final double DAMAGE = 15;
    private static final double PRICE = 10;
    private static final String NAME = "Bow";

    private static final double MONSTER_DAMAGE_RATIO = 0.9;
    private static final double OBSTACLE_DAMAGE_RATIO = 1.1;
    private static final double BOSS_DAMAGE_RATIO = 4;

    public Bow() {
        super(DAMAGE, PRICE, NAME, MONSTER_DAMAGE_RATIO, OBSTACLE_DAMAGE_RATIO, BOSS_DAMAGE_RATIO);
    }

    public String asciiArt() {
        return """
                   (
                    \\
                     )
                ##-------->
                     )
                    /
                   (
                """;
    }
}
