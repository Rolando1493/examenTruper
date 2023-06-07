package com.rolando.truper.examentruper.bean;

import java.util.Date;

public class Response {
	
	private Date fecha;
	
	private String message;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
