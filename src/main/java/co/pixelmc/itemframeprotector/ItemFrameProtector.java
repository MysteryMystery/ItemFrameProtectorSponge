package co.pixelmc.itemframeprotector;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.event.entity.CollideEntityEvent;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = ItemFrameProtector.ID, version = ItemFrameProtector.VERSION, description = ItemFrameProtector.DESCRIPTION, authors = {"Obeliskthegreat - Founder of PixelMC.co"})
public class ItemFrameProtector {
    public static final String ID = "itemframeprotector";
    public static final String VERSION = "1.0";
    public static final String DESCRIPTION = "Stop item frames being destroyed by projectiles!";
    
    private static ItemFrameProtector itemFrameProtector;
    public static ItemFrameProtector getInstance() {
        return itemFrameProtector;
    }
    private static void setInstance(ItemFrameProtector i){
        itemFrameProtector = i;
    }

    @Inject
    private Logger logger;
    @Inject
    private Game game;

    public Logger getLogger() {
        return logger;
    }

    public Game getGame() {
        return game;
    }

    @Listener
    public void onServerStarting(GameStartingServerEvent e){

    }

    @Listener
    public  void onServerStarted(GameStartedServerEvent e){

    }

    @Listener
    public void onEntityCollide(CollideEntityEvent event) {
        for(Entity entity : event.getEntities())
            if(entity instanceof ItemFrame) {
                event.setCancelled(true);
                break;
            }
    }

    @Listener
    public void onLeftClick(InteractEntityEvent.Primary e){
        if (e.getTargetEntity() instanceof ItemFrame)
            e.setCancelled(true);
    }
}
