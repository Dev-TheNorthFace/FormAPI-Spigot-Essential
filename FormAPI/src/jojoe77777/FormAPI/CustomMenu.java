package jojoe77777.FormAPI.CustomMenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomMenu {

    private final String title;
    private final Inventory inventory;
    private final Map<Integer, String> labelMap = new HashMap<>();
    private final Map<String, Runnable> actions = new HashMap<>();

    public CustomMenu(String title, int size) {
        this.title = title;
        this.inventory = Bukkit.createInventory(null, size, title);
    }

    public void setTitle(String title) {
    }

    public String getTitle() {
        return this.title;
    }

    public void addLabel(String text, String label) {
        addItem(createItem(Material.PAPER, text), label);
    }

    public void addToggle(String text, boolean defaultValue, String label) {
        String toggleText = text + (defaultValue ? " [ON]" : " [OFF]");
        addItem(createItem(Material.LEVER, toggleText), label);
    }

    public void addSlider(String text, int min, int max, int step, int defaultValue, String label) {
        String sliderText = text + " (" + min + " - " + max + ", step: " + step + ", default: " + defaultValue + ")";
        addItem(createItem(Material.IRON_SWORD, sliderText), label);
    }

    public void addStepSlider(String text, List<String> steps, int defaultIndex, String label) {
        String stepSliderText = text + " (steps: " + steps.size() + ", default: " + steps.get(defaultIndex) + ")";
        addItem(createItem(Material.COMPASS, stepSliderText), label);
    }

    public void addDropdown(String text, List<String> options, int defaultIndex, String label) {
        String dropdownText = text + " (options: " + options.size() + ", default: " + options.get(defaultIndex) + ")";
        addItem(createItem(Material.BOOK, dropdownText), label);
    }

    public void addInput(String text, String placeholder, String defaultValue, String label) {
        String inputText = text + " (placeholder: " + placeholder + ", default: " + defaultValue + ")";
        addItem(createItem(Material.BOOK_AND_QUILL, inputText), label);
    }

    private ItemStack createItem(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            item.setItemMeta(meta);
        }
        return item;
    }

    private void addItem(ItemStack item, String label) {
        int slot = inventory.firstEmpty();
        if (slot != -1) {
            inventory.setItem(slot, item);
            labelMap.put(slot, label);
        }
    }

    public void openMenu(Player player) {
        player.openInventory(inventory);
    }

    public void handleClick(int slot, Player player) {
        String label = labelMap.get(slot);
        if (label != null && actions.containsKey(label)) {
            actions.get(label).run();
        }
    }

    public void addAction(String label, Runnable action) {
        actions.put(label, action);
    }
}