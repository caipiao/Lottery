package com.jeecms.common.security.rememberme;

import com.jeecms.common.security.AuthenticationException;

@SuppressWarnings("serial")
public class RememberMeAuthenticationException extends AuthenticationException {
	public RememberMeAuthenticationException() {
	}

	public RememberMeAuthenticationException(String msg) {
		super(msg);
	}
}
