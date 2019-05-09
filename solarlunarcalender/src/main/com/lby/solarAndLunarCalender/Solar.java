package com.lby.solarAndLunarCalender;

/**
 * 公历类
 */
public class Solar {
	public int solarDay;// 日
	public int solarMonth;// 月
	public int solarYear;// 年

	public Solar() {
	}

	public Solar(int solarYear, int solarMonth, int solarDay) {
		this.solarDay = solarDay;
		this.solarMonth = solarMonth;
		this.solarYear = solarYear;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != Solar.class)
			return false;
		Solar target = (Solar)(obj);
		return target.solarYear == solarYear
				&& target.solarMonth == solarMonth
				&& target.solarDay == solarDay;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Solar Date: ");
		sb.append(solarYear);
		sb.append("-");
		if (0 < solarMonth){
			if (solarMonth < 10){
				sb.append(0);
			}
		}
		sb.append(solarMonth);
		sb.append("-");
		if (0 < solarDay){
			if (solarDay < 10){
				sb.append(0);
			}
		}
		sb.append(solarDay);
		String s = sb.toString();
		sb = null;
		return s;
	}
}
