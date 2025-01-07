package org.hhlaowang.papiAnalysis;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PapiExplain extends PlaceholderExpansion {
    static public Map<Player, Boolean>playerResourceStatus = new HashMap<>();
    @Override
    public @NotNull String getIdentifier() {
        return "papianalysis";
    }
    @Override
    public @NotNull String getAuthor() {
        return "hhlaowang";
    }
    @Override
    public @NotNull String getVersion() {
        return "V1.0";
    }
    // 在线模式
    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        // 定义正则表达式模式
        Pattern pattern = Pattern.compile("\\{(.*?)\\}\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(params);
        if (matcher.matches()) {
            // 提取第一个括号内的内容（String1）
            String string1 = "%" + matcher.group(1) + "%";          // 参数1存放目标占位符
            // 提取第二个括号内的内容（String2）
            String string2 = "%" + matcher.group(2)  + "%";          // 参数2存放目标玩家的占位符
            String playerString = PlaceholderAPI.setPlaceholders(player, string2);
            Player playerDest = Bukkit.getPlayer(playerString);
            if(playerDest != null) {
                return PlaceholderAPI.setPlaceholders(playerDest, string1);
            }else{
                return "PlayerNull";
            }
        } else {
            return "FormatError";
        }
    }
    // 离线模式
    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        // 定义正则表达式模式
        Pattern pattern = Pattern.compile("\\{(.*?)\\}\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(params);
        if (matcher.matches()) {
            // 提取第一个括号内的内容（String1）
            String string1 = "%" + matcher.group(1) + "%";          // 参数1存放目标占位符
            // 提取第二个括号内的内容（String2）
            String string2 = "%" + matcher.group(2)  + "%";          // 参数2存放目标玩家的占位符
            String playerString = PlaceholderAPI.setPlaceholders(player, string2);
            OfflinePlayer playerDest = Bukkit.getOfflinePlayer(playerString);
            if(playerDest != null) {
                return PlaceholderAPI.setPlaceholders(playerDest, string1);
            }else{
                return "PlayerNull";
            }
        } else {
            return "FormatError";
        }
    }
}
