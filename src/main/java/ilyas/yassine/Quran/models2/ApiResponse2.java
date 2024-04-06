package ilyas.yassine.Quran.models2;

import java.util.List;

public class ApiResponse2 {
	private int code;
    private String status;
    private List<Data2> Data ;
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
	public List<Data2> getData() {
		return Data;
	}
	public void setData(List<Data2> data) {
		Data = data;
	} 
    
}
