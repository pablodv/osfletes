package com.osfletes.web.dto;

public class ProviderAnnounceFilterDTO extends GenericFilterDTO {

	private Long providerId;
	private Integer stateId;

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public void setStateId(int stateId) {
			this.stateId =	stateId;
	}

	public Integer getStateId() {
		return stateId;
	}
	
	

}
