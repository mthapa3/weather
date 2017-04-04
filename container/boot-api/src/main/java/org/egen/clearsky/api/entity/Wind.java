package org.egen.clearsky.api.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Wind {

	private String speed;
	private String degree;

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", degree=" + degree + "]";
	}
}
