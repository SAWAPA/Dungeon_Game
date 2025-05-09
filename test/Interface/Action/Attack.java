package test.Interface.Action;

import test.Inventory.Item;

@FunctionalInterface

public interface Attack {
    public int itemBuffDamage(Item item);
}
