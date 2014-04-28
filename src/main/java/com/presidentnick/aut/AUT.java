package com.presidentnick.aut;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.presidentnick.aut.achievements.AUTAchievements;
import com.presidentnick.aut.common.ContentRegistry;
import com.presidentnick.aut.lib.ModInfo;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ID, version = ModInfo.VERSION)
public class AUT
{
    
    public static final Logger logger = LogManager.getLogger("AlmostUselessTools");
    
    @Instance("AUT")
    public static AUT instance;
    
    public static ContentRegistry content;
    
    public AUT() {
    	
    	logger.info("Hooray, we're doing something!");
    	
    }
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
    	
    	content = new ContentRegistry();
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		AUTAchievements.init();
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
    	
    }
}
