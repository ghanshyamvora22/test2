package com.example.capoli_vaadin;

public class BusinessForm  {
	
	private String businessName;
	private String businessEmail;
	private String businessAddressId;	
	private String businessID;	
	private String businessPhoneNo;
	private String businessWebURL;
	private String memberid;
	
	
	public String getBusinessWebURL() {
		return businessWebURL;
	}
	public void setBusinessWebURL(String businessWebURL) {
		this.businessWebURL = businessWebURL;
	}
	
	public String getBusinessAddressId() {
		return businessAddressId;
	}
	public void setBusinessAddressId(String businessAddressId) {
		this.businessAddressId = businessAddressId;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getBusinessPhoneNo() {
		return businessPhoneNo;
	}
	public void setBusinessPhoneNo(String businessPhoneNo) {
		this.businessPhoneNo = businessPhoneNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	private String memberId;
	
	public String getBusinessID() {
		return businessID;
	}
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessEmail() {
		return businessEmail;
	}
	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}
	
}
