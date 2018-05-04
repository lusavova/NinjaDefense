package telerik.interfaces;

import telerik.Bound;

public interface Collidable {
    public void onCollide();
    public Bound getBounds();
}
