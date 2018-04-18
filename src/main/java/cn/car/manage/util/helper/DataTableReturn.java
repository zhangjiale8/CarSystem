package cn.car.manage.util.helper;

import java.util.List;

import com.google.gson.Gson;


public class DataTableReturn<T> {
	
	private int sEcho;//原始返回参数
	
	private long iTotalRecords;//数据过滤前记录总数
	
	private long iTotalDisplayRecords;//数据过滤后记录总数
	
	private List<T> aaData;//数据
	
	
	public int getsEcho() {
		return sEcho;
	}

	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}

	public long getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<T> getAaData() {
		return aaData;
	}

	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}

	public DataTableReturn(int sEcho, long iTotalRecords,long iTotalDisplayRecords, List<T> aaData) {
		super();
		this.sEcho = sEcho;
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.aaData = aaData;
	}

	public DataTableReturn() {
		super();
	}

	@Override
	public String toString() {
		return "DataTable_Return [sEcho=" + sEcho + ", iTotalRecords="
				+ iTotalRecords + ", iTotalDisplayRecords="
				+ iTotalDisplayRecords + ", aaData=" + aaData + "]";
	}
	
	public String toJSON(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("{");
		buffer.append("\"sEcho\":");
		buffer.append(this.sEcho);
		buffer.append(",");
		buffer.append("\"iTotalRecords\":");
		buffer.append(this.iTotalRecords);
		buffer.append(",");
		buffer.append("\"iTotalDisplayRecords\":");
		buffer.append(this.iTotalDisplayRecords);
		buffer.append(",");
		buffer.append("\"aaData\":");
		
		if(null == this.aaData){
			buffer.append("[]");
		}else{
			buffer.append(new Gson().toJson(this.aaData));
		}
		
		buffer.append("}");
		
		return buffer.toString();
		
	}
	
}
