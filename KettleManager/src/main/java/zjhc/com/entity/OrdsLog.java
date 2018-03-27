package zjhc.com.entity;

import java.util.Date;

public class OrdsLog {
	
	private String request_ip;
	private Date request_date;
    private String request_way;
    private String request_url;
    private String response_result;
    private String response_time;
    private String insert_date;
    private String ords_ip;
    private String url_type;
	public String getRequest_ip() {
		return request_ip;
	}
	public void setRequest_ip(String request_ip) {
		this.request_ip = request_ip;
	}
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}
	public String getRequest_way() {
		return request_way;
	}
	public void setRequest_way(String request_way) {
		this.request_way = request_way;
	}
	public String getRequest_url() {
		return request_url;
	}
	public void setRequest_url(String request_url) {
		this.request_url = request_url;
	}
	public String getResponse_result() {
		return response_result;
	}
	public void setResponse_result(String response_result) {
		this.response_result = response_result;
	}
	public String getResponse_time() {
		return response_time;
	}
	public void setResponse_time(String response_time) {
		this.response_time = response_time;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getOrds_ip() {
		return ords_ip;
	}
	public void setOrds_ip(String ords_ip) {
		this.ords_ip = ords_ip;
	}
	public String getUrl_type() {
		return url_type;
	}
	public void setUrl_type(String url_type) {
		this.url_type = url_type;
	}
}
