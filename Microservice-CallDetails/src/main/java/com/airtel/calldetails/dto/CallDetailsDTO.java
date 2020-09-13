package com.airtel.calldetails.dto;

import java.util.Date;

public class CallDetailsDTO {

	private Long callId;
	private Long calledBy;
	private Long calledTo;
	private Date calledOn;
	private Integer duration;
	public Long getCallId() {
		return callId;
	}
	public void setCallId(Long callId) {
		this.callId = callId;
	}
	public Long getCalledBy() {
		return calledBy;
	}
	public void setCalledBy(Long calledBy) {
		this.calledBy = calledBy;
	}
	public Long getCalledTo() {
		return calledTo;
	}
	public void setCalledTo(Long calledTo) {
		this.calledTo = calledTo;
	}
	public Date getCalledOn() {
		return calledOn;
	}
	public void setCalledOn(Date calledOn) {
		this.calledOn = calledOn;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
}
