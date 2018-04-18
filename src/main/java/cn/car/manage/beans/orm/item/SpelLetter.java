package cn.car.manage.beans.orm.item;
/**
 * @Description:英文字母实体类
 * @author 李子辉
 *
 */
public class SpelLetter {

	private int spellID;
	
	private String spelLetter;

	public int getSpellID() {
		return spellID;
	}

	public void setSpellID(int spellID) {
		this.spellID = spellID;
	}

	public String getSpelLetter() {
		return spelLetter;
	}

	public void setSpelLetter(String spelLetter) {
		this.spelLetter = spelLetter;
	}

	@Override
	public String toString() {
		return "SpelLeter [spellID=" + spellID + ", spelLetter=" + spelLetter + "]";
	}
	
	
}
