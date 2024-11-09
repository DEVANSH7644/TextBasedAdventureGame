package com.user.model;

public class Player {
    private int id;
    private String name;
    private int health;
    private String location;
    private String inventory;

    // Constructors
    public Player() {}

    public Player(String name, int health, String location, String inventory) {
        this.name = name;
        this.health = health;
        this.location = location;
        this.inventory = inventory;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getInventory() { return inventory; }
    public void setInventory(String inventory) { this.inventory = inventory; }

}
