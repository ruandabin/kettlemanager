package zjhc.com.entity;

import java.util.List;

/***
 * jquery datatable 返回对象
 * @author rdb
 *
 */
public class DataTable {

	private Integer draw;//请求次数
	private Integer recordsTotal;//总记录数
	private Integer recordsFiltered;//过滤后的记录数
	private List data;//数据
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
}
