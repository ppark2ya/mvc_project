package test.board.dto;

public class BoardDto {
<<<<<<< HEAD
	private int board_num;		// 글번호
	private String writer;	// 작성자
	private String title;	// 글제목
	private String category;
	private String content;	// 글내용
	private String regdate;	// 작성일
=======
	private int board_num;
	private String cust_id;
	private String title;
	private String category;
	private String content;
	private String regdate;
>>>>>>> branch 'master' of https://github.com/ppark2ya/mvc_project.git
	
	private int startRowNum; // 시작 row 번호
	private int endRowNum;	 // 끝 row 번호
	private int prevNum;	// 이전 글의 글 번호
	private int nextNum;	// 다음 글의 글 번호

	// 디폴트 생성자
	public BoardDto(){}

	public BoardDto(int board_num, String writer, String title, String category, String content, String regdate,
			int startRowNum, int endRowNum, int prevNum, int nextNum) {
		super();
		this.board_num = board_num;
		this.writer = writer;
		this.title = title;
		this.category = category;
		this.content = content;
		this.regdate = regdate;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	

	
}
