package zjhc.com.entity;
//tree node 
public class FileTree {
	private String id;
	private String text;
	private String iconCls;
	private String attributes; //自定义属性
	private String state;
	
	public FileTree(String id,String text,String iconCls,String attributes,String state){
		this.attributes = attributes;
		this.iconCls = iconCls;
		this.id = id;
		this.state = state;
		this.text = text;
	}
	
	public FileTree(){}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	
}
