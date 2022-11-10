package com.mainservice.models;

import java.util.List;

public class UserOutput {
	private User user;
	private Portfolio portfolio;
	private List<MutualFund> mfList;
	public UserOutput(User user, Portfolio portfolio, List<MutualFund> mfList) {
		super();
		this.user = user;
		this.portfolio = portfolio;
		this.mfList = mfList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	public List<MutualFund> getMfList() {
		return mfList;
	}
	public void setMfList(List<MutualFund> mfList) {
		this.mfList = mfList;
	}
	
}
