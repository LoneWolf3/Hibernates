package com.sac.compositekey;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class EmployeeId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="company_id")
	private String companyId;
	
	@Column(name="employee_id")
	private String employeeId;
	
	public EmployeeId(String cid,String eid){
		this.companyId=cid;
		this.employeeId=eid;
	}
	public String getcompanyId() {
		return companyId;
	}

	public void setcompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getemployeeId() {
		return employeeId;
	}

	public void setemployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}