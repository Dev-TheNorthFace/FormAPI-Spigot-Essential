package jojoe77777.FormAPI.FormListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class FormListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (inventory.getHolder() instanceof Form) {
            Form form = (Form) inventory.getHolder();
            event.setCancelled(true);
            form.handleResponse((Player) event.getWhoClicked(), null);
        }
    }
}