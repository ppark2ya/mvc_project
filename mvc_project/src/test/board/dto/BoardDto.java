package test.board.dto;

public class BoardDto {
	private int num;
	private String id;
	private String category;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	
	public BoardDto(){}

	public BoardDto(int num, String id, String category, String title, String writer, String content, String regdate) {
		super();
		this.num = num;
		this.id = id;
		this.category = category;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory(){
		return category;
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
