package me.indian.xboxplayers.listeners;


import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.Config;
import me.indian.xboxplayers.XboxPlayersTransfer;

import java.net.InetSocketAddress;

public class XboxPlayer implements Listener {

    private static XboxPlayersTransfer plugin = XboxPlayersTransfer.getInstance();


    @EventHandler
    public void xboxTransfer(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Config conf = plugin.getConfig();

            if (p.getLoginChainData().getXUID() != null) {
                String ip = conf.getString("transfer.ip");
                int port = conf.getInt("transfer.port");
                try {
                    transfer(p, ip, port);
                    plugin.getLogger().info("§aTransfering player §e" + p.getDisplayName() + "§ato proxy" );
                } catch (NullPointerException ex) {
                    System.out.println("Can't transfer player " + p.getDisplayName());
            }
        }
    }


    public void transfer(Player p, String address, int port) {
        InetSocketAddress addr = new InetSocketAddress(address, port);
        p.transfer(addr);
    }

}