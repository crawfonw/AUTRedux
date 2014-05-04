package com.presidentnick.aut.items;

public class ItemGem extends MetaItem {

	public static String[] itemNames = new String[] { "gem.amethyst", "gem.malachite" };
	public static String[] textureNames = new String[] { "amethyst", "malachite" };
	
	public ItemGem() {
		super(itemNames, textureNames, "gem");
	}
	
}
