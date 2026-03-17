# Dungeon_Game

**Dungeon_Game** is a simple dungeon crawler game written in **Java**.

This project is created for learning purposes and is currently under development.  
I use it to improve my skills in:

- Game design and logic
- Object-oriented programming (OOP)
- Java development
- English communication (documentation & code)

---

## Project Goals

- Practice Java programming through a console-based RPG game
- Learn how to structure and manage game systems (combat, inventory, items)
- Improve problem-solving and software design skills
- Improve English skills through writing code and documentation

---

## Project Status

This project is in **early development** stage.  
Some features are complete, and others are planned for the future.

---

## Features

- ✅ Player & Enemy system
- ✅ Item and Backpack (inventory)
- ✅ Combat system (attack, shield, potion)
- ⏳ Chest system (random item drop)
- ⏳ Dungeon exploration
- ⏳ Game saving/loading
- ⏳ GUI version (planned)

---

## Project Structure

```text
src/
└── test/
    ├── Entity/         # Player, Enemy, and other game entities
    ├── Inventory/      # Item, Backpack, and inventory-related classes
    ├── Interface/
    │   └── Action/     # Interfaces for player actions (AddItem, Potion, etc.)
    ├── Enum/           # Enum definitions like InventoryType
    └── Main.java       # Entry point of the game
```

## How to Run

1. Make sure you have Java installed
2. Compile the project:

```bash
javac -d bin src/test/Main.java 
```

## Run the project:

```bash
java -cp bin test.Main
```
