package superscary.healthredux.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import superscary.healthredux.config.CommonConfig;
import superscary.healthredux.damage.Bleeds;
import superscary.healthredux.damage.CalculateDamage;
import superscary.healthredux.damage.Damageable;

public class ReduxEntity extends Player implements Bleeds
{

    private double playerHealth = CommonConfig.defaultPlayerHealth;

    private double bloodAmount = CommonConfig.defaultPlayerBloodAmount;
    private boolean isBleeding = false;

    public ReduxEntity (Entity entity)
    {
        super(entity.level(), entity.blockPosition(), entity.yRotO, entity.getServer().getSingleplayerProfile());
    }

    @Override
    public boolean isSpectator ()
    {
        return false;
    }

    @Override
    public boolean isCreative ()
    {
        return false;
    }

    @Override
    public boolean isBleeding ()
    {
        return isBleeding;
    }

    @Override
    public boolean canBleed ()
    {
        return true;
    }

    @Override
    public double maxBloodAmount ()
    {
        return CommonConfig.defaultPlayerBloodAmount;
    }

    @Override
    public double currentBloodAmount ()
    {
        return bloodAmount;
    }

    @Override
    public void damage (Damageable part)
    {
        playerHealth -= CalculateDamage.forPart(part);
    }

    @Override
    public void heal (double amount)
    {
        playerHealth = Math.min(playerHealth + amount, CommonConfig.defaultPlayerHealth);
    }

    @Override
    public void drain (double amount)
    {
        bloodAmount -= amount;
    }

    @Override
    public void replenish (double amount)
    {
        bloodAmount = Math.min(bloodAmount + amount, CommonConfig.defaultPlayerBloodAmount);
    }
}
