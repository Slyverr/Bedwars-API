package com.slyvr.api.team;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;

import java.util.HashMap;
import java.util.Map;

public enum Team {

    RED("Red", ChatColor.RED, DyeColor.RED),
    BLUE("Blue", ChatColor.BLUE, DyeColor.BLUE),
    GREEN("Green", ChatColor.GREEN, DyeColor.LIME),
    YELLOW("Yellow", ChatColor.YELLOW, DyeColor.YELLOW),
    AQUA("Aqua", ChatColor.AQUA, DyeColor.CYAN),
    WHITE("White", ChatColor.WHITE, DyeColor.WHITE),
    PINK("Pink", ChatColor.LIGHT_PURPLE, DyeColor.PINK),
    GRAY("Gray", ChatColor.DARK_GRAY, DyeColor.GRAY);

    private static final Map<DyeColor, Team> BY_DYE = new HashMap<>();
    private static final Map<String, Team> BY_NAME = new HashMap<>();

    static {
        for (Team team : values()) {
            Team.BY_NAME.put(team.team.toLowerCase(), team);
            Team.BY_DYE.put(team.color, team);
        }

    }

    private final ChatColor chatcolor;
    private final DyeColor color;
    private final String team;

    Team(String team, ChatColor chatcolor, DyeColor color) {
        this.team = team;
        this.chatcolor = chatcolor;
        this.color = color;
    }

    public static Team getByColor(DyeColor color) {
        return Team.BY_DYE.get(color);
    }

    public static Team getByName(String name) {
        return name != null ? Team.BY_NAME.get(name.toLowerCase()) : null;
    }

    public ChatColor getChatColor() {
        return this.chatcolor;
    }

    public DyeColor getDyeColor() {
        return this.color;
    }

    public String getColoredString() {
        return this.chatcolor + this.team;
    }

    public String getPrefix() {
        return this.chatcolor + "[" + name() + "]";
    }

    public String getColoredChar() {
        return this.chatcolor + Character.toString(this.team.charAt(0));
    }

    public String getColoredChar(int index) {
        if (index >= 0 && index < this.team.length())
            return this.chatcolor + Character.toString(this.team.charAt(index));

        return null;
    }

    public String getScoreboardText() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.chatcolor);
        builder.append(this.team.charAt(0));
        builder.append(ChatColor.RESET);
        builder.append(" ");
        builder.append(this.team);
        builder.append(":");

        return builder.toString();
    }

    @Override
    public String toString() {
        return this.team;
    }

}