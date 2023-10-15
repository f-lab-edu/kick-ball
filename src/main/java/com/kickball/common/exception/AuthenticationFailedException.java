package com.kickball.common.exception;

public class AuthenticationFailedException extends RuntimeException{

	public AuthenticationFailedException() {
		super("아이디 또는 패스워드가 정확하지 않습니다.");
	}
}
