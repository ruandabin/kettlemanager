package zjhc.com.entity;

import java.util.List;

/***
 * jquery datatable ���ض���
 * @author rdb
 *
 */
public class DataTable {

	private Integer draw;//�������
	private Integer recordsTotal;//�ܼ�¼��
	private Integer recordsFiltered;//���˺�ļ�¼��
	private List data;//����
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
