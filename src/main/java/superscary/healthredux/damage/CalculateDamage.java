package superscary.healthredux.damage;

public class CalculateDamage
{

    public static double forPart (Damageable damageable)
    {
        return 1 * damageable.getMultiplier();
    }

    public static boolean shouldBleed (Damageable damageable, double amount)
    {
        return false;
    }

}
