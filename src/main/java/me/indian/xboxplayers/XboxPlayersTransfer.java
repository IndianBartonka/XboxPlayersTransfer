package me.indian.xboxplayers;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import me.indian.xboxplayers.listeners.XboxPlayer;

public class XboxPlayersTransfer extends PluginBase {

    private static XboxPlayersTransfer instance;

    public static XboxPlayersTransfer getInstance(){
        return instance;
    }


    public void onEnable(){
        instance = this;

        saveDefaultConfig();

        PluginManager pm = getServer().getPluginManager();

        new XboxPlayer();
        pm.registerEvents(new XboxPlayer() ,this );


    }




}