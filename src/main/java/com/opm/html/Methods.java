package com.opm.html;

import com.opm.database.Project;

public class Methods {
	public static String errorMessage(String message)
	{
		return "<div class=\"alert alert-danger\">"+message+"</div>";
	}
	public static String successMessage(String message)
	{
		return "<div class=\"alert alert-success\">"+message+"</div>";
	}
	
	public static String jsAlert(String message)
	{
		return "<script> window.alert("+message+") </script>";
	}
	
	public static String getProjectPanel(Project project,int i)
	{
		String view = "<div id=\"accordion\" style=\"float: left; width: 100%;\">\r\n" + 
				"  <div style=\"border-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px; border :1px solid #ddd;  background-color: #f5f5f5;padding: 5px; margin-top: 10px; width: 100%;\"><h3 style=\"margin:3px;\">Section 1 <button type=\"submit\" class=\"btn btn-default\" style=\"border: 0px;\r\n" + 
				"    border-radius: 4px;\r\n" + 
				"    -webkit-font-smoothing: antialiased;\r\n" + 
				"    font-weight: bold;\r\n" + 
				"    padding: 4px;\r\n" + 
				"    margin-right: 10px;\r\n" + 
				"    vertical-align: middle;\r\n" + 
				"    text-align: center;\r\n" + 
				"    background-color: #3367d6;\r\n" + 
				"    color: rgb(255, 255, 255);\r\n" + 
				"    width: auto;\r\n" + 
				"    float: right;\">More Info</button>\r\n" + 
				"    <button type=\"submit\" class=\"btn btn-default\" style=\"border: 0px;\r\n" + 
				"    border-radius: 4px;\r\n" + 
				"    -webkit-font-smoothing: antialiased;\r\n" + 
				"    font-weight: bold;\r\n" + 
				"    padding: 4px;\r\n" + 
				"    margin-right: 10px;\r\n" + 
				"    vertical-align: middle;\r\n" + 
				"    text-align: center;\r\n" + 
				"    background-color: rgb(230, 0, 35);\r\n" + 
				"    color: rgb(255, 255, 255);\r\n" + 
				"    width: auto;\r\n" + 
				"    float: right;\">Delete</button></h3></div>\r\n" + 
				"  <div style=\"border-radius: 5px; border-top-right-radius: 0px; border-top-left-radius: 0px; border-bottom:1px solid #ddd; border-right:1px solid #ddd; border-left:1px solid #ddd; padding: 5px;display: block;/* height: 108px; */\">\r\n" + 
				"    <p>Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.\r\n" + 
				"\r\n" + 
				"    </p>\r\n" + 
				"  \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				" \r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"    .ui-accordion-content\r\n" + 
				"    {\r\n" + 
				"      height: auto;\r\n" + 
				"    }\r\n" + 
				"  </style>\r\n" + 
				"";
		return view;
	}
}
