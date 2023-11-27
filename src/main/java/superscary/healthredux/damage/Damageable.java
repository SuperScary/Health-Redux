package superscary.healthredux.damage;

public enum Damageable
{

    ARM (1d),
    HEAD (3d),
    TORSO (2d),
    LEG (1.5d),
    FOOT (1d),
    HAND (1.2d);

    double multiplier;
    Damageable (double multiplier)
    {
        this.multiplier = multiplier;
    }

    public double getMultiplier ()
    {
        return multiplier;
    }

}
