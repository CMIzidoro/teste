package com.mainservice.models;

public class MutualFund {

	private int mfId;
	private String mfDesc;
	private double mfNAV;
	private double mfGainPer;
	private String mfType;
	//private String mfPlan;
	public MutualFund() {}
	
	public int getMfId() {
		return mfId;
	}
	public MutualFund(int mfId, String mfDesc, double mfNAV, double mfGainPer, String mfType) {
		super();
		this.mfId = mfId;
		this.mfDesc = mfDesc;
		this.mfNAV = mfNAV;
		this.mfGainPer = mfGainPer;
		this.mfType = mfType;
	}
	public void setMfId(int mfId) {
		this.mfId = mfId;
	}
	public String getMfDesc() {
		return mfDesc;
	}
	public void setMfDesc(String mfDesc) {
		this.mfDesc = mfDesc;
	}
	public double getMfNAV() {
		return mfNAV;
	}
	public void setMfNAV(double mfNAV) {
		this.mfNAV = mfNAV;
	}
	public double getMfGainPer() {
		return mfGainPer;
	}
	public void setMfGainPer(float mfGainPer) {
		this.mfGainPer = mfGainPer;
	}
	public String getMfType() {
		return mfType;
	}
	public void setMfType(String mfType) {
		this.mfType = mfType;
	}
	
}
