package online.qsx.dto;

public class District {
	private String districtId;
	private String districtName;
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public District(String districtId, String districtName) {
		super();
		this.districtId = districtId;
		this.districtName = districtName;
	}
	public District() {
		super();
	}
	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", districtName=" + districtName + "]";
	}
	
	
}
