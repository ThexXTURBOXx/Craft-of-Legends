package de.thexxturboxx.craftoflegends.api;

public enum PROPERTY {
	ABILITY_POWER("Ability Power"),
	ARMOR("Armor"),
	ATTACK_DAMAGE("Attack Damage"),
	COOLDOWN("Cooldown Reduction"),
	CRIT_CHANCE("Crit Chance"),
	GOLD_PER_SEC("Gold per 10 Seconds"),
	LIFE("Health"),
	LIFE_REGEN("Life Regeneration per 5 Seconds"),
	LIFE_STEAL("Life Steal"),
	MAGIC_RESIST("Magic Resistance"),
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
