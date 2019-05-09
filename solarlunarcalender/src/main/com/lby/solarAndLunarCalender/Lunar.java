package com.lby.solarAndLunarCalender;

/**
 * 农历类
 */
public class Lunar {
	public boolean isleap;// 是否闰月
	public int lunarDay;// 日
	public int lunarMonth;// 月
	public int lunarYear;// 年

	public Lunar() {
	}

	public Lunar(boolean isleap, int lunarDay, int lunarMonth, int lunarYear) {
		this.isleap = isleap;
		this.lunarDay = lunarDay;
		this.lunarMonth = lunarMonth;
		this.lunarYear = lunarYear;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != Lunar.class)
			return false;
		if (obj.hashCode() == hashCode())
			return true;
		Lunar target = (Lunar) (obj);
		return target.lunarYear == lunarYear
				&& target.lunarMonth == lunarMonth
				&& target.lunarDay == lunarDay;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Lunar Date: ");
		sb.append(lunarYear);
		sb.append("-");
		if (0 < lunarMonth){
			if (lunarMonth < 10){
				sb.append(0);
			}
		}
		sb.append(lunarMonth);
		sb.append("-");
		if (0 < lunarDay){
			if (lunarDay < 10){
				sb.append(0);
			}
		}
		sb.append(lunarDay);
		String s = sb.toString();
		sb = null;
		return s;
	}
}
