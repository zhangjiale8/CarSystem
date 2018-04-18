package cn.car.manage.beans.orm.customer.address;
/**
 * @Description:城市名称信息类
 * @author
 * @date 2018年3月10日
 */
public class CityName {

	private int cityID;
	
	//城市名称
	private String cityName;
	
	//字母缩写
	private int spellID;

	public CityName() {
		super();
	}

	public CityName(int cityID, String cityName, int spellID) {
		super();
		this.cityID = cityID;
		this.cityName = cityName;
		this.spellID = spellID;
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getSpellID() {
		return spellID;
	}

	public void setSpellID(int spellID) {
		this.spellID = spellID;
	}

	@Override
	public String toString() {
		return "City [cityID=" + cityID + ", cityName=" + cityName + ", spellID=" + spellID + "]";
	}
	
	
}
