package com.app.enums;

import lombok.Getter;


@Getter
public enum PlanType {
	
	WEEKLY(7),MONTLY(30);
	
	private int duration;

	private PlanType(int duration) {
		this.duration = duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
