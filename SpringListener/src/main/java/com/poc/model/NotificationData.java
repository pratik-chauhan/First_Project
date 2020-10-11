package com.poc.model;

public class NotificationData {

    private long id;
    private String createdBy;
    private String notificationType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

    

}
