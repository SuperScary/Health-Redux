package superscary.healthredux.damage;


import net.minecraft.world.entity.Entity;
import superscary.healthredux.entity.ReduxEntity;

public class Damager
{

    private Entity entity;

    public Damager (ReduxEntity entity)
    {
        this.entity = entity;
    }

    public void damage (ReduxEntity entity, Damageable damageable)
    {
        entity.damage(damageable);
    }

}
