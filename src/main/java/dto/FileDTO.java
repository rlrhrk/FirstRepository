package dto;

import java.io.File;

public class FileDTO {
	private String path;
	private String fileName;
	private String type;
	private int bno;
	private int order;
	
	public FileDTO() {
	}
	
	public FileDTO(String path, String fileName, String type, int bno, int order) {
		super();
		this.path = path;
		this.fileName = fileName;
		this.type = type;
		this.bno = bno;
		this.order = order;
	}


	public FileDTO(File file, int bno, int order) {
		this.path = file.getAbsolutePath();//현재 파일경로가 나옴 파일명만 제외하고
		this.fileName = file.getName();
		//파일 확장자 뽑는부분
		switch(fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase()) { //substring은 문자를 쪼개주는거
																				//toLowerCase()는 문자를 다 소문자로 바꿔주는거
		case "png":
		case "bmp":
		case "gif":
		case "jpg":
			this.type = "image";
			break;
		default:
			this.type = "normal";
	}
		this.bno = bno;
		this.order = order;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		//setPath에도 아래 내용을 집어넣어줘야함 그래야 인식을 하려나..
		File file = new File(path);
		this.fileName = file.getName();
		switch(fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase()) { 
		case "png":
		case "bmp":
		case "gif":
		case "jpg":
			this.type = "image";
			break;
		default:
			this.type = "normal";
		}
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "FileDTO [path=" + path + ", fileName=" + fileName + ", type=" + type + ", bno=" + bno + ", order="
				+ order + "]";
	}
	
}
