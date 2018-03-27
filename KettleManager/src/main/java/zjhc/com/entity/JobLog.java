package zjhc.com.entity;

public class JobLog {

	private Integer id;
	private String jobName;
	private String srcType;
	private String jobDesc;
	private String batchDate;
	private String startTime;
	private String endTime;
	private String Status;
	private String sucessFlag;
	private String errLink;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getSrcType() {
		return srcType;
	}
	public void setSrcType(String srcType) {
		this.srcType = srcType;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getSucessFlag() {
		return sucessFlag;
	}
	public void setSucessFlag(String sucessFlag) {
		this.sucessFlag = sucessFlag;
	}
	public String getErrLink() {
		return errLink;
	}
	public void setErrLink(String errLink) {
		this.errLink = errLink;
	}
}
