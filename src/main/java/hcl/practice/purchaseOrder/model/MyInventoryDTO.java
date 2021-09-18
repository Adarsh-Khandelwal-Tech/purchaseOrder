package hcl.practice.purchaseOrder.model;

import javax.persistence.Column;

public class MyInventoryDTO {

	
	private String productName;
	

	private Integer totalUnits;


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Integer getTotalUnits() {
		return totalUnits;
	}


	public void setTotalUnits(Integer totalUnits) {
		this.totalUnits = totalUnits;
	}
	
	
	
}
