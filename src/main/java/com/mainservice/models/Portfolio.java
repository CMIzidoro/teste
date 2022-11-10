package com.mainservice.models;

import java.util.List;

public class Portfolio {
	private int pfId;
	private List<String> holdingList;
	private double totalInvested;
	private double totalGain;
	private int userId;
	public Portfolio() {}
	public Portfolio(int pfId, List<String> holdingList, double totalInvested, double totalGain, int userId) {
		super();
		this.pfId = pfId;
		this.holdingList = holdingList;
		this.totalInvested = totalInvested;
		this.totalGain = totalGain;
		this.userId = userId;
	}
	public int getPfId() {
		return pfId;
	}
	public void setPfId(int pfId) {
		this.pfId = pfId;
	}
	public List<String> getHoldingList() {
		return holdingList;
	}
	public void setHoldingList(List<String> holdingList) {
		this.holdingList = holdingList;
	}
	public double getTotalInvested() {
		return totalInvested;
	}
	public void setTotalInvested(double totalInvested) {
		this.totalInvested = totalInvested;
	}
	public double getTotalGain() {
		return totalGain;
	}
	public void setTotalGain(double totalGain) {
		this.totalGain = totalGain;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
