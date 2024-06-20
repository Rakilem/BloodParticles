package com.rakilem.bloodparticles;

import cn.nukkit.event.Listener;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.level.particle.RedstoneParticle;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.Player;

public class BloodParticles extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("BloodParticles ha sido habilitado");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("BloodParticles ha sido deshabilitado");
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            spawnRedstoneParticles(player);
        }
    }

    private void spawnRedstoneParticles(Player player) {
        double x = player.getX();
        double y = player.getY() + 1.5; // Ajustado para estar más arriba del jugador
        double z = player.getZ();

        for (int i = 0; i < 20; i++) { // Aumentado a 20 partículas
            double offsetX = (Math.random() - 0.5) * 2;
            double offsetY = (Math.random() - 0.5) * 2;
            double offsetZ = (Math.random() - 0.5) * 2;
            player.getLevel().addParticle(new RedstoneParticle(player.add(offsetX, offsetY, offsetZ)));
        }
    }
}
