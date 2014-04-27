package com.presidentnick.aut.achievements;

/*
 * Snagged from Tinkers' Construct Repo
 * https://github.com/SlimeKnights/TinkersConstruct/blob/master/src/main/java/tconstruct/achievements/TAchievements.java
 */

import java.util.HashMap;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AUTAchievements {

	public static HashMap<String, Achievement> achievements = new HashMap<String, Achievement>();
	
	public static AchievementPage achievementPage = null;
	
	public static void init() {
		Achievement[] achs = new Achievement[achievements.values().size()];

        for (int i = 0; i < achs.length; i++)
        {
            achs[i] = (Achievement) achievements.values().toArray()[i];
        }

        achievementPage = new AchievementPage("AUT", achs);

        AchievementPage.registerAchievementPage(achievementPage);
	}
	
}
