package test.controller;

public class UserActionFactory {
	private static UserActionFactory factory;
	private UserActionFactory(){}
	// 자신의 참조값을 리턴해주는 메소드
	public static UserActionFactory getInstance(){
		if(factory == null)
			factory = new UserActionFactory();
		return factory;
	}
	
	// 인자로 전달되는 command 를 수행할 Action type 객체를 리턴해주는 메소드
	public Action action(String command){
		Action action = null;
		
		return action;
	}
}
