package com.slyvr.api.prestige;

import com.google.common.base.Preconditions;
import com.slyvr.api.level.BedwarsLevel;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Prestige {

    public static final Prestige DEFAULT = new Prestige("Stone Prestige", ChatColor.GRAY + "Stone Prestige", ChatColor.GRAY + "[****✫]",
            ChatColor.GRAY + "****✫", 1, 99);
    private static final Map<Integer, Prestige> BY_START_LEVEL = new HashMap<>();
    private static final Map<Integer, Prestige> BY_END_LEVEL = new HashMap<>();
    private static final Map<String, Prestige> BY_NAME = new HashMap<>();
    private final String name;
    private final String display;

    private final String chatFormat;
    private final String boardFormat;

    private final int start;
    private final int end;

    public Prestige(String name, String displayName, String chatFormat, String boardFormat, int start, int end) {
        Preconditions.checkNotNull(name, "Prestige name cannot be null!");
        Preconditions.checkNotNull(chatFormat, "Prestige chat format cannot be null!");
        Preconditions.checkNotNull(boardFormat, "Prestige scoreboard format cannot be null!");

        Preconditions.checkArgument(start >= 0, "Prestige start level must be positif!");
        Preconditions.checkArgument(end >= 0, "Prestige end level must be positif!");
        Preconditions.checkArgument(end >= start, "Prestige end level must be greater than or equals to start level!");

        this.name = name;
        this.display = displayName;

        this.chatFormat = chatFormat;
        this.boardFormat = boardFormat;

        this.start = start;
        this.end = end;
    }

    public static String format(String format, BedwarsLevel level) {
        return format(format, String.valueOf(level.getLevel()));
    }

    private static String format(String format, String lvl) {
        StringBuilder builder = new StringBuilder(format);

        int index = 0;
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) != '*')
                continue;

            if (index < lvl.length())
                builder.setCharAt(i, lvl.charAt(index++));
            else
                builder.deleteCharAt(i--);
        }

        return format(builder.toString());
    }

    public static Prestige getByName(String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }

    public static Prestige getByStartLevel(int level) {
        return BY_START_LEVEL.get(level);
    }

    public static Prestige getByEndLevel(int level) {
        return BY_END_LEVEL.get(level);
    }

    public static Prestige getByLevel(int level) {
        for (Prestige prestige : BY_NAME.values()) {
            if (level >= prestige.start && level <= prestige.end)
                return prestige;
        }

        return null;
    }

    public static boolean registerPrestige(Prestige prestige) {
        if (prestige == null)
            return false;

        String name = prestige.name.toLowerCase();
        if (BY_NAME.containsKey(name) || BY_START_LEVEL.containsKey(prestige.start) || BY_END_LEVEL.containsKey(prestige.end))
            return false;

        BY_NAME.put(name, prestige);
        BY_START_LEVEL.put(prestige.start, prestige);
        BY_END_LEVEL.put(prestige.end, prestige);

        return true;
    }

    public static boolean isRegistered(Prestige prestige) {
        if (prestige == null)
            return false;

        return BY_NAME.containsKey(prestige.name) || BY_START_LEVEL.containsKey(prestige.start) || BY_END_LEVEL.containsKey(prestige.end);
    }

    private static String format(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.display;
    }

    public String getChatFormat() {
        return this.chatFormat;
    }

    public String getScoreboardFormat() {
        return this.boardFormat;
    }

    public int getStartLevel() {
        return this.start;
    }

    public int getEndLevel() {
        return this.end;
    }

    public String formatToChat(BedwarsLevel level) {
        return level != null ? format(this.chatFormat, level) : null;
    }

    public String formatToScoreboard(BedwarsLevel level) {
        return level != null ? format(this.boardFormat, level) : null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.chatFormat, this.boardFormat, this.end, this.start);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Prestige))
            return false;

        Prestige other = (Prestige) obj;
        if ((this.start != other.start) || (this.end != other.end) || !this.name.equalsIgnoreCase(other.name))
            return false;

        return this.chatFormat.equalsIgnoreCase(other.chatFormat) && this.boardFormat.equalsIgnoreCase(other.boardFormat);
    }

}