package jojoe77777.FormAPI.FormAPI;

import org.bukkit.plugin.java.JavaPlugin;

public class FormAPI extends JavaPlugin {

    /**
     * Create a custom form (inventory) with a callback.
     *
     * @param callback Callback function for form response
     * @return CustomForm instance
     */
    public CustomForm createCustomForm(FormCallback callback) {
        return new CustomForm(callback);
    }

    /**
     * Create a simple form (inventory) with a callback.
     *
     * @param callback Callback function for form response
     * @return SimpleForm instance
     */
    public SimpleForm createSimpleForm(FormCallback callback) {
        return new SimpleForm(callback);
    }

    /**
     * Create a modal form (inventory) with a callback.
     *
     * @param callback Callback function for form response
     * @return ModalForm instance
     */
    public ModalForm createModalForm(FormCallback callback) {
        return new ModalForm(callback);
    }
}