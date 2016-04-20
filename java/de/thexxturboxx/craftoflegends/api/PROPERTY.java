package de.thexxturboxx.craftoflegends.api;

public enum PROPERTY {
	ABILITY_POWER("Ability Power"),
	ARMOR("Armor"),
	ARMOR_PENETRATION("Armor Penetration"),
	ATTACK_DAMAGE("Attack Damage"),
	ATTACK_SPEED("Attack Speed"),
	COOLDOWN("Cooldown Reduction"),
	CRIT_CHANCE("Crit Chance"),
	GOLD_PER_SEC("Gold per 10 Seconds"),
	HEALTH("Health"),
	HEALTH_REGEN("Life Regeneration per 5 Seconds"),
	LIFE_ON_HIT("Life on Hit"),
	LIFE_STEAL("Life Steal"),
	MAGIC_RESIST("Magic Resistance"),
	MAGIC_PENETRATION("Magic Penetration"),
	MANA("Mana"),
	MANA_REGEN("Mana Regeneration per 5 Seconds"),
	MOVEMENT("Movement Speed");
	
	private final String realName;
	
	PROPERTY(String rN) {
		this.realName = rN;
	}
	
	public String realName() {
		return realName;
	}
	
}
