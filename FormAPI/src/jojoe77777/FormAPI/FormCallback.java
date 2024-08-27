package jojoe77777.FormAPI.FormCallback;

import org.bukkit.entity.Player;

@FunctionalInterface
public interface FormCallback {
    void onFormSubmit(Player player, Object data);
}