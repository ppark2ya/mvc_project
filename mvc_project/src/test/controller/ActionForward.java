package test.controller;

public class ActionForward {
	// 이동 경로
	private String path;
	// 리다이렉트 이동 여부 (default value : false)
	private boolean isRedirect;

	// 생성자 1
	public ActionForward(String path) {
		super();
		this.path = path;
	}

	// 생성자 2
	public ActionForward(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
