package dev.mzcy.itembuilder.impl.nbt;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Ideally this wouldn't need to be a util, but because of the LegacyNbt it makes it easier. Legacy.
 * Will use the PDC wrapper if version is higher than 1.14
 */
public final class ItemNbt {

    private static final NbtWrapper nbt = selectNbt();

    /**
     * Sets an NBT tag to the an {@link ItemStack}.
     *
     * @param itemStack The current {@link ItemStack} to be set.
     * @param key       The NBT key to use.
     * @param value     The tag value to set.
     * @return An {@link ItemStack} that has NBT set.
     */
    public static ItemStack setString(@NotNull final ItemStack itemStack, @NotNull final String key, @NotNull final String value) {
        return nbt.setString(itemStack, key, value);
    }

    /**
     * Gets the NBT tag based on a given key.
     *
     * @param itemStack The {@link ItemStack} to get from.
     * @param key       The key to look for.
     * @return The tag that was stored in the {@link ItemStack}.
     */
    public static String getString(@NotNull final ItemStack itemStack, @NotNull final String key) {
        return nbt.getString(itemStack, key);
    }

    /**
     * Sets a boolean to the {@link ItemStack}.
     * Mainly used for setting an item to be unbreakable on older versions.
     *
     * @param itemStack The {@link ItemStack} to set the boolean to.
     * @param key       The key to use.
     * @param value     The boolean value.
     * @return An {@link ItemStack} with a boolean value set.
     */
    public static ItemStack setBoolean(@NotNull final ItemStack itemStack, @NotNull final String key, final boolean value) {
        return nbt.setBoolean(itemStack, key, value);
    }

    /**
     * Removes a tag from an {@link ItemStack}.
     *
     * @param itemStack The current {@link ItemStack} to be removed.
     * @param key       The NBT key to remove.
     * @return An {@link ItemStack} that has the tag removed.
     */
    public static ItemStack removeTag(@NotNull final ItemStack itemStack, @NotNull final String key) {
        return nbt.removeTag(itemStack, key);
    }

    private static NbtWrapper selectNbt() {
        return new Pdc();
    }

}