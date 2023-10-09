package com.kickball.common.exception;


public class UsernameAlreadyExistsException extends RuntimeException{
	public UsernameAlreadyExistsException() {
		super("이미 회원가입 되어 있습니다.");
	}
}
