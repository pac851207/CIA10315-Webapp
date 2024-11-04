package com.petSitterServiceItem.model;

public class PetSitterServiceItemVO implements java.io.Serializable{
	private Integer svcId;
	private String svcDescr;
	private String svcName;

	public PetSitterServiceItemVO() {
		super();
	}
	
	public PetSitterServiceItemVO(Integer svcId, String svcDescr, String svcName) {
		super();
		this.svcId = svcId;
		this.svcDescr = svcDescr;
		this.svcName = svcName;
	}

	public Integer getSvcId() {
		return svcId;
	}

	public void setSvcId(Integer svcId) {
		this.svcId = svcId;
	}

	public String getSvcDescr() {
		return svcDescr;
	}

	public void setSvcDescr(String svcDescr) {
		this.svcDescr = svcDescr;
	}

	public String getSvcName() {
		return svcName;
	}

	public void setSvcName(String svcName) {
		this.svcName = svcName;
	}

	@Override
	public String toString() {
		return "PetSitterServiceItemVO [svcId=" + svcId + ", svcDescr=" + svcDescr + ", svcName=" + svcName + "]";
	}

	
	

}
