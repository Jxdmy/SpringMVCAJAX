package online.qsx.dto;

public class Province {
	private String provinceId;
	private String provinceName;
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Province(String provinceId, String provinceName) {
		super();
		this.provinceId = provinceId;
		this.provinceName = provinceName;
	}
	public Province() {
		super();
	}
	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", provinceName=" + provinceName + "]";
	}
	
}
