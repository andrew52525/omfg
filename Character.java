/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Unchained
 * 2016-11-22
 */

public abstract class Character {
    protected int health;
    protected int strength;
    protected int defense;
    protected double attack;
    protected double stealth;

    protected int damage_dealt;
    protected int moves;
    protected int coins = 0;

    public Character() {
        health = 200;
        strength = 100;
        defense = 100;
        attack = 0.6;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public void lowerHP(int h) {
        health -= h;
    }

    public int attack(Character c) {
        int damage = (int) ((strength * attack) - c.getDefense());
        if ( damage < 0 ) {
            damage = 0;
        }

        if ( damage > c.getHealth() ) {
            damage = c.getHealth();
        }

        moves++;
        damage_dealt += damage;
        c.lowerHP(damage);
	coins += damage_dealt;
	if(!c.isAlive()){
	    coins += 100;
	}
        return damage;
    }

    public abstract void specialize();

    public abstract void normalize();

    public abstract String about();
}

