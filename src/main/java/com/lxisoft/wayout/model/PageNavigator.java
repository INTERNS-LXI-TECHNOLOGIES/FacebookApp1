package com.lxisoft.wayout.model;

import com.lxisoft.wayout.web.*;
import java.util.*;
import java.io.*;

public class PageNavigator
{
	
	private static int lastPageNo,currentPageNo=1;
	//public Set<SecurityQuestion> securityQuestions;

	public static int getLastPageNo()
	{

		/*int size=(ContactController.getContactSet()).size();
		if(size%5==0)
			return (size/5);
		else
			return (size/5)+1;*/
			return 1;// just for checking
	
	}
	public static int getCurrentPageNo()
	{

		return currentPageNo;

	}
	public static void setCurrentPageNo(int pageNo)
	{

		currentPageNo=pageNo;

	}	
/*	public void setSecurityQuestions(Set<SecurityQuestions> securityQuestions){
		this.securityQuestions=securityQuestions;
	}
	public Set<SecurityQuestions> getSecurityQuestions()
		return securityQuestions;
	}*/

}