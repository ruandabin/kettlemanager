package zjhc.com.entity;

public class Echarts {
	
	public Echarts(String[] yAxis, Long[] series) {
		super();
		this.yAxis = yAxis;
		this.series = series;
	}
	private String [] yAxis ; 
	private Long [] series;
	public String[] getyAxis() {
		return yAxis;
	}
	public void setyAxis(String[] yAxis) {
		this.yAxis = yAxis;
	}
	public Long[] getSeries() {
		return series;
	}
	public void setSeries(Long[] series) {
		this.series = series;
	}
	
}
