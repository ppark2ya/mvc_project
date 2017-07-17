package test.board.dto;

public class BoardDto {
	private int board_num;
	private String cust_id;
	private String title;
	private String category;
	private String content;
	private String regdate;
	
	public BoardDto(){}

	public BoardDto(int board_num, String cust_id, String title, String category, String content, String regdate) {
		super();
		this.board_num = board_num;
		this.cust_id = cust_id;
		this.title = title;
		this.category = category;
		this.content = content;
		this.regdate = regdate;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
