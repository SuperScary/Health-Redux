package superscary.healthredux.damage;

public interface Bleeds
{
    /**
     * If the current entity is bleeding.
     * @return
     */
    boolean isBleeding ();

    /**
     * If the current entity has blood.
     * @return
     */
    boolean canBleed ();

    /**
     * If the entity is hurt but not bleeding.
     * @return
     */
    boolean isHurt ();

    /**
     * The maximum amount of blood the entity can contain.
     * @return
     */
    double maxBloodAmount ();

    /**
     * The current amount of blood the entity contains.
     * @return
     */
    double currentBloodAmount ();

    /**
     * Fires when the entity takes damage.
     * @param amount The amount of damage the entity takes.
     */
    void damage (double amount);

    /**
     * Heals the entity.
     * @param amount The amount the entity should be healed by. Cannot overheal unless stated in config.
     */
    void heal (double amount);

    /**
     * Drains a set amount of blood. Can cause death by bleeding out.
     * @param amount The amount of blood to remove from the entity.
     */
    void drain (double amount);

    /**
     * Lets entity create more blood over time.
     * @param amount The amount of blood to be reintroduced to the entity. Cannot be higher than the maximum allowed by
     *               maxBloodAmount.
     */
    void replenish (double amount);

}
