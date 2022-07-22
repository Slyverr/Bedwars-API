package com.slyvr.api.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.NumberConversions;

public class LocationUtils {

    public static String serialize(Location loc, boolean yawpitch) {
        if (loc == null)
            return null;

        StringBuilder builder = new StringBuilder(loc.getWorld().getName())
                .append(':')
                .append(loc.getX())
                .append(':')
                .append(loc.getY())
                .append(':')
                .append(loc.getZ());

        if (yawpitch)
            builder.append(':').append(loc.getYaw()).append(':').append(loc.getPitch());

        return builder.toString();
    }

    // private static String format(double num, int limit) {
    // StringBuilder builder = new StringBuilder();
    // String s = Double.toString(num);
    //
    // boolean isAfterPoint = false;
    //
    // int afterPoint = 0;
    // for (int i = 0; i < s.length(); i++) {
    // char c = s.charAt(i);
    //
    // builder.append(c);
    //
    // if (c == '.') {
    // isAfterPoint = true;
    // continue;
    // }
    //
    // if (isAfterPoint && ++afterPoint == limit)
    // return builder.toString();
    // }
    //
    // return builder.toString();
    // }

    public static Location deserialize(String location) {
        if (location == null)
            return null;

        String[] values = location.split(":");
        if (values.length < 4)
            return null;

        World world = Bukkit.getWorld(values[0]);
        if (world == null)
            return null;

        double x = NumberConversions.toDouble(values[1]);
        double y = NumberConversions.toDouble(values[2]);
        double z = NumberConversions.toDouble(values[3]);
        float yaw = values.length > 4 ? NumberConversions.toFloat(values[4]) : 0;
        float pitch = values.length > 5 ? NumberConversions.toFloat(values[5]) : 0;

        return new Location(world, x, y, z, yaw, pitch);
    }

}