package cn.car.manage.util.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 *
 * @Description: 前端Datatables插件参数对象
 * @User: 
 * @Date: 2015年7月25日 下午10:50:35
 */
public class DataTable {
	
	private int start;//iDisplayStart
	
	private int length;//iDisplayLength
	
	private int sEcho;//dataTable原始返回的参数
	
	private List<String> columns;//当前表格的所有列
	
	private List<Boolean> columnSortabled;//标识每列是否可排序
	
	private String sortConlum;//当前排序的列
	
	private String sortDir;//当前排序列的排序方式
	
	private String sort;	//组合排序条件
	
	/**
	 * 自定义参数
	 */
	private Map<String, Object> parameters = new HashMap<String, Object>();
	
	
	public DataTable(HashMap<String, Object> params){
		this.init(params);
	}
	
	public DataTable(HttpServletRequest request){
		HashMap<String, Object> params = RequestUtil.parametersConvertToMap(request);
		this.init(params);
	}
	
	@SuppressWarnings("unchecked")
	public void init(HashMap<String, Object> map){
		if(null != map){
			columns = new ArrayList<String>();
			
			columnSortabled = new ArrayList<Boolean>();
			
			String[] columnName = map.get("sColumns").toString().split(",");
			
			//每页显示的记录数
			this.length = Integer.parseInt(map.get("iDisplayLength").toString());
			//当前页开始的记录
			this.start = Integer.parseInt(map.get("iDisplayStart").toString());
			this.start = (this.start / this.length) + 1;
			
			
			//dataTable原路返回
			this.sEcho = Integer.parseInt(map.get("sEcho").toString());
			
			//当前表格共有多少列
			int columnLength = Integer.parseInt(map.get("iColumns").toString());
			
			for(int i=0;i<columnLength;i++){
				
				boolean sortAbled = Boolean.parseBoolean(map.get("bSortable_"+i).toString());
				
				//每列的名称
				if(sortAbled && i < columnName.length){
					
					this.columns.add(columnName[i]);
					
				}else{
					
					this.columns.add("");
					
				}
				//每列是否可排序
				this.columnSortabled.add(sortAbled);
				
			}
			//sortDir = map.get("sSortDir_0").toString();
			sortDir = map.getOrDefault("sSortDir_0", "").toString();
			if(!sortDir.isEmpty()){
				int sortIndex = Integer.parseInt(map.get("iSortCol_0").toString());
				
				sortConlum = this.columns.get(sortIndex);
				
				if(sortConlum != null && sortDir == null){
					sort = sortConlum + " asc";
				}else if(sortConlum != null && sortDir != null){
					sort = sortConlum + " " + sortDir;
				}else{
					sort = null;
				}
			}
			//解析自定义参数
			String paramStr = map.getOrDefault("parameters", "").toString();
			if(!paramStr.isEmpty()){
				//List<Map<String, Object>> list = (List<Map<String, Object>>) AliJsonUtil.fromJsonArray(paramStr, parameters.getClass());
				parameters = AliJsonUtil.fromJson(paramStr, parameters.getClass());
				if(parameters == null ){
					parameters = new HashMap<String, Object>();
				}
			}
			
		}
		
	}
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getsEcho() {
		return sEcho;
	}

	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public List<Boolean> getColumnSortabled() {
		return columnSortabled;
	}

	public void setColumnSortabled(List<Boolean> columnSortabled) {
		this.columnSortabled = columnSortabled;
	}

	public String getSortConlum() {
		return sortConlum;
	}

	public void setSortConlum(String sortConlum) {
		this.sortConlum = sortConlum;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(HashMap<String, Object> parameters) {
		this.parameters = parameters;
	}

	/**
	 *
	 * @param start
	 * @param length
	 * @param sEcho
	 * @param columns
	 * @param columnSortabled
	 * @param sortConlum
	 * @param sortDir
	 */
	public DataTable(int start, int length, int sEcho, List<String> columns,
			List<Boolean> columnSortabled, String sortConlum,
			String sortDir) {
		super();
		this.start = start;
		this.length = length;
		this.sEcho = sEcho;
		this.columns = columns;
		this.columnSortabled = columnSortabled;
		this.sortConlum = sortConlum;
		this.sortDir = sortDir;
	}

	public DataTable() {
		super();
	}
	
	@Override
	public String toString() {
		return "DataTable [start=" + start + ", length=" + length + ", sEcho="
				+ sEcho + ", columns=" + columns + ", columnSortabled="
				+ columnSortabled + ", sortConlum=" + sortConlum + ", sortDir="
				+ sortDir + "]";
	}

}