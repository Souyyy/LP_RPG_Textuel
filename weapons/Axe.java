package weapons;

public class Axe extends Weapon {

    private static final double DAMAGE = 100;
    private static final double PRICE = 10;
    private static final String NAME = "Axe";

    private static final double MONSTER_DAMAGE_RATIO = 0.8;
    private static final double OBSTACLE_DAMAGE_RATIO = 1.2;
    private static final double BOSS_DAMAGE_RATIO = 4;

    public Axe() {
        super(DAMAGE, PRICE, NAME, MONSTER_DAMAGE_RATIO, OBSTACLE_DAMAGE_RATIO, BOSS_DAMAGE_RATIO);
    }

    public String asciiArt() {
        return "    /'-./\\_\n"
                + "   :    ||,>\n"
                + "    \\.-'||\n"
                + "        ||\n"
                + "        ||\n"
                + "        ||  \n";
    }

}
