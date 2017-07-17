package test.controller;

import test.action.HomeAction;
import test.customer.action.DropoutAction;
import test.customer.action.ForgetPasswordFormAction;
import test.customer.action.MyPageAction;
import test.customer.action.ResetPasswordAction;
import test.customer.action.SigninAction;
import test.customer.action.SigninFormAction;
import test.customer.action.SignoutAction;
import test.customer.action.SignupAction;
import test.customer.action.SignupFormAction;
import test.customer.action.UpdateAction;
import test.customer.action.UpdateFormAction;
import test.board.action.BoardMainAction;
import test.board.action.DropoutAction;
import test.board.action.ViewContentAction;
import test.board.action.WriteAction;
import test.board.action.WriteFormAction;

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
		if(command.equals("/home")){
			action = new HomeAction();
		}else if(command.equals("/customer/signupform")){
			action = new SignupFormAction();
		}else if(command.equals("/customer/signup")){
			action = new SignupAction();
		}else if(command.equals("/customer/signinform")){
			action = new SigninFormAction();
		}else if(command.equals("/customer/signin")){
			action = new SigninAction();
		}else if(command.equals("/customer/signout")){
			action = new SignoutAction();
		}else if(command.equals("/customer/myPage")){
			action = new MyPageAction();
		}else if(command.equals("/customer/dropout")){
			action = new test.customer.action.DropoutAction();
		}else if(command.equals("/customer/updateform")){
			action = new UpdateFormAction();
		}else if(command.equals("/customer/update")){
			action = new UpdateAction();
		}else if(command.equals("/customer/forgetpasswordform")){
			action = new ForgetPasswordFormAction();
		}else if(command.equals("/customer/resetpassword")){
			action = new ResetPasswordAction();
		}else if(command.equals("/board/boardmain")){
			action = new BoardMainAction();
		}else if(command.equals("/board/writeform")){
			action = new WriteFormAction();
		}else if(command.equals("/board/write")){
			action = new WriteAction();
		}else if(command.equals("/board/viewcontent")){
			action = new ViewContentAction();
		}else if(command.equals("/board/updateform")){
			action = new test.board.action.UpdateFormAction();
		}else if(command.equals("/board/update")){
			action = new test.board.action.UpdateAction();
		}else if(command.equals("/board/delete")){
			action = new DropoutAction();
		}
		return action;
	}
}
