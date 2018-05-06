package telerik.interfaces;

import telerik.system.Bound;

public interface Collidable {
    public void onCollide();
    public Bound getBounds();
}
