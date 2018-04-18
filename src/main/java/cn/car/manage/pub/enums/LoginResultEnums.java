package cn.car.manage.pub.enums;

public enum LoginResultEnums {
  SUCCESS(0),NOUSER(1),DISABLED_STATE(2),NOPERMISSION(3),CANCEL(4);
  private int value;

public int getValue() {
	return value;
}

public void setValue(int value) {
	this.value = value;
}
private LoginResultEnums(int value){
	this.value =value;
}
}
