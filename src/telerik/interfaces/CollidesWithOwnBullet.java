package telerik.interfaces;

import telerik.entities.flying_objects.FriendlyBullet;

public interface CollidesWithOwnBullet extends Collidable {
    public void addToCollidableWithOwnBullet();
    public void onCollideWithBullet(FriendlyBullet bullet);

}