This branch is for 1.21.11.

# No Combat Elytra

Prevents players from using their elytra to flee in the middle of combat in Minecraft.

This server-side mod adds a peice of custom data to every player that tracks how long since they have been attacked by another player. This counter will go up indefinately and will be set to 0 when attacked by another player. If a player's counter is below the configureted cooldown, it will remove any elytra from their chest armor slot and place it in an empty space in their inventory. If there is no space for the elytra, it will be dropped on the ground. Enchantments, damage, and other data will be preserved when this happens.

Configurations:
- Enable/disable mod: useful for disabling/enabling without reloading server
- Cooldown: amount of ticks that must pass since being hit by a player before they can use their elytra
- Enable message: enables an actionbar message showing a custom message that may include the time remaining
- Message: custom message to show during cooldown
  - Use `%T` to express amount of ticks left in cooldown
  - Use `%S` to express amount of seconds left in cooldown (rounded ticks/20)
Configuration powered by FigManager 2.2 embedded
