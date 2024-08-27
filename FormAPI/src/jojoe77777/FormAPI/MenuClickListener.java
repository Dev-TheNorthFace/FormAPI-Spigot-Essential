package jojoe77777.FormAPI.MenuClickListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MenuClickListener implements Listener {

    private final CustomMenu customMenu;

    public MenuClickListener(CustomMenu customMenu) {
        this.customMenu = customMenu;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (inventory.equals(customMenu.getInventory())) {
            event.setCancelled(true);
            customMenu.handleClick(event.getSlot(), (Player) event.getWhoClicked());
        }
    }
}