package jojoe77777.FormAPI.SimpleForm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleForm extends Form {

    private String title;
    private String content;
    private final List<Button> buttons = new ArrayList<>();
    private final Map<Integer, String> labelMap = new HashMap<>();

    public SimpleForm(FormCallback callback) {
        super("Simple Form", 9 * 3, callback);
        this.title = "";
        this.content = "";
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

    public void addButton(String text, int imageType, String imagePath, String label) {
        this.buttons.add(new Button(text, imageType, imagePath));
        this.labelMap.put(this.buttons.size() - 1, label != null ? label : String.valueOf(this.buttons.size() - 1));
    }

    @Override
    public void processData(Object data) {

        Integer index = (Integer) data;
        String label = this.labelMap.get(index);
    }

    @Override
    public void sendToPlayer(Player player) {
        Inventory inventory = Bukkit.createInventory(new FormHolder(this), getSize(), this.title);

        for (int i = 0; i < this.buttons.size(); i++) {
            Button button = this.buttons.get(i);
            ItemStack item = new ItemStack(/* item type */);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(button.text);
            List<String> lore = new ArrayList<>();
            lore.add(button.imagePath);
            meta.setLore(lore);
            item.setItemMeta(meta);
            inventory.setItem(i, item);
        }

        player.openInventory(inventory);
    }

    private static class Button {
        private final String text;
        private final int imageType;
        private final String imagePath;

        public Button(String text, int imageType, String imagePath) {
            this.text = text;
            this.imageType = imageType;
            this.imagePath = imagePath;
        }
    }

    private static class FormHolder implements InventoryHolder {
        private final SimpleForm form;

        public FormHolder(SimpleForm form) {
            this.form = form;
        }

        @Override
        public Inventory getInventory() {
            return null;
        }
    }
}