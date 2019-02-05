package com.opm.html;

public class Methods {
	public static String errorMessage(String message)
	{
		return "<div class=\"alert alert-danger\">"+message+"</div>";
	}
	public static String successMessage(String message)
	{
		return "<div class=\"alert alert-success\">"+message+"</div>";
	}
}
