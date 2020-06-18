package com.cts.postbook.modal;

public class Status {

	public Status() {
		super();
	}

	public Status(boolean queryStatus, String message) {
		super();
		this.queryStatus = queryStatus;
		this.message = message;
	}

	private boolean queryStatus;
	private String message;

	public boolean isQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(boolean queryStatus) {
		this.queryStatus = queryStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
