package jojoe77777.FormAPI.Form;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import java.util.function.BiConsumer;

public abstract class Form implements InventoryHolder {

    private final BiConsumer<Player, Object> callback;
    private final Inventory inventory;

    /**
     * @param title Title of the inventory (form)
     * @param size Size of the inventory (form)
     * @param callback Callable function to handle form response
     */
    public Form(String title, int size, BiConsumer<Player, Object> callback) {
        this.callback = callback;
        this.inventory = Bukkit.createInventory(this, size, title);
    }

    /**
     * Open the form (inventory) for the player.
     *
     * @param player Player to open the form for
     */
    public void sendToPlayer(Player player) {
        player.openInventory(inventory);
    }

    /**
     * Handle the response from the player.
     *
     * @param player Player who responded
     * @param data Response data
     */
    public void handleResponse(Player player, Object data) {
        processData(data);
        if (callback != null) {
            callback.accept(player, data);
        }
    }

    /**
     * Process the data from the form response.
     *
     * @param data Data to process
     */
    public void processData(Object data) {
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}