package jojoe77777.FormAPI.ModalForm;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ModalForm extends Form {

    private String title;
    private String content;
    private String button1;
    private String button2;

    public ModalForm(FormCallback callback) {
        super("Modal Form", 9 * 3, callback);
        this.title = "";
        this.content = "";
        this.button1 = "";
        this.button2 = "";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setButton1(String text) {
        this.button1 = text;
    }

    public String getButton1() {
        return this.button1;
    }

    public void setButton2(String text) {
        this.button2 = text;
    }

    public String getButton2() {
        return this.button2;
    }

    @Override
    public void processData(Object data) {
    }

    @Override
    public void sendToPlayer(Player player) {

        super.sendToPlayer(player);
        Inventory inventory = getInventory();
        ItemStack itemStack1 = new ItemStack(/* item type for button 1 */);
        ItemMeta meta1 = itemStack1.getItemMeta();
        meta1.setDisplayName(this.button1);
        itemStack1.setItemMeta(meta1);
        inventory.setItem(0, itemStack1); // Set button 1
        ItemStack itemStack2 = new ItemStack(/* item type for button 2 */);
        ItemMeta meta2 = itemStack2.getItemMeta();
        meta2.setDisplayName(this.button2);
        itemStack2.setItemMeta(meta2);
        inventory.setItem(1, itemStack2);
        player.openInventory(inventory);
    }
}