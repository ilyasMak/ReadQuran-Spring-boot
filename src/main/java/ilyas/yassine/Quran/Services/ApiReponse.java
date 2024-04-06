package ilyas.yassine.Quran.Services;

import java.util.List;

import ilyas.yassine.Quran.models.Data;

class ApiResponse {
    private int code;
    private String status;
    private Data data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	


}
