package com.pactera.backend.common;

/**
 * 
 * @ClassName: ResultCode
 * @author Holly.Y.Yin
 * @date 2021/06/1
 *
 */
public enum ResultCode {

	SUCCESS("0", "SUCCESS"),

	FAILED("1", "FAILED"),

	SYS_ERROR("2", "SYS_ERROR");

	private String val;
	private String msg;

	ResultCode(String status, String msg) {
		this.val = status;
		this.msg = msg;
	}

	public String val() {
		return val;
	}

	public String msg() {
		return msg;
	}

}
