package com.haier.hevwms.remoting.rf.domain.order;

public class WmsRefTgPlanlistIn {
	private Long rowId;
	private String trip;
	private String tripDate;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

}
