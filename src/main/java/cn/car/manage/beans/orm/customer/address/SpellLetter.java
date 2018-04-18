package cn.car.manage.beans.orm.customer.address;
/**
 * @Description:英文字母类
 * @author 
 * @date 2018年3月10日
 */
public class SpellLetter {

	private int spellD;
	
	private String spellLetter;

	public SpellLetter(int spellD, String spellLetter) {
		super();
		this.spellD = spellD;
		this.spellLetter = spellLetter;
	}

	public SpellLetter() {
		super();
	}

	public int getSpellD() {
		return spellD;
	}

	public void setSpellD(int spellD) {
		this.spellD = spellD;
	}

	public String getSpellLetter() {
		return spellLetter;
	}

	public void setSpellLetter(String spellLetter) {
		this.spellLetter = spellLetter;
	}

	@Override
	public String toString() {
		return "SpellLetter [spellD=" + spellD + ", spellLetter=" + spellLetter + "]";
	}
	
	
}
