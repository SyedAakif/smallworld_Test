package com.smallworld.data;

public class Transaction {
    // Represent your transaction data here.
	private Integer mtn;
	private Integer amount;
	private String senderFullName;
	private String senderAge;
	private String beneficiaryFullName;
	private Integer beneficiaryAge;
	private Integer issueId;
	private Boolean issueSolved;
	private String issueMessage;
	
	public Integer getMtn() {
		return mtn;
	}
	public void setMtn(Integer mtn) {
		this.mtn = mtn;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getSenderFullName() {
		return senderFullName;
	}
	public void setSenderFullName(String senderFullName) {
		this.senderFullName = senderFullName;
	}
	public String getSenderAge() {
		return senderAge;
	}
	public void setSenderAge(String senderAge) {
		this.senderAge = senderAge;
	}
	public String getBeneficiaryFullName() {
		return beneficiaryFullName;
	}
	public void setBeneficiaryFullName(String beneficiaryFullName) {
		this.beneficiaryFullName = beneficiaryFullName;
	}
	public Integer getBeneficiaryAge() {
		return beneficiaryAge;
	}
	public void setBeneficiaryAge(Integer beneficiaryAge) {
		this.beneficiaryAge = beneficiaryAge;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public Boolean getIssueSolved() {
		return issueSolved;
	}
	public void setIssueSolved(Boolean issueSolved) {
		this.issueSolved = issueSolved;
	}
	public String getIssueMessage() {
		return issueMessage;
	}
	public void setIssueMessage(String issueMessage) {
		this.issueMessage = issueMessage;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (beneficiaryAge == null) {
			if (other.beneficiaryAge != null)
				return false;
		} else if (!beneficiaryAge.equals(other.beneficiaryAge))
			return false;
		if (beneficiaryFullName == null) {
			if (other.beneficiaryFullName != null)
				return false;
		} else if (!beneficiaryFullName.equals(other.beneficiaryFullName))
			return false;
		if (issueId == null) {
			if (other.issueId != null)
				return false;
		} else if (!issueId.equals(other.issueId))
			return false;
		if (issueMessage == null) {
			if (other.issueMessage != null)
				return false;
		} else if (!issueMessage.equals(other.issueMessage))
			return false;
		if (issueSolved == null) {
			if (other.issueSolved != null)
				return false;
		} else if (!issueSolved.equals(other.issueSolved))
			return false;
		if (mtn == null) {
			if (other.mtn != null)
				return false;
		} else if (!mtn.equals(other.mtn))
			return false;
		if (senderAge == null) {
			if (other.senderAge != null)
				return false;
		} else if (!senderAge.equals(other.senderAge))
			return false;
		if (senderFullName == null) {
			if (other.senderFullName != null)
				return false;
		} else if (!senderFullName.equals(other.senderFullName))
			return false;
		return true;
	}

	
}
