package com.opm.ajax;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;
import com.opm.database.Project;
import com.opm.jasonView.Views;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	String msg;
	
	@JsonView(Views.Public.class)
	String code;
	
	@JsonView(Views.Public.class)
	String result;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	//getters and setters
	 
}