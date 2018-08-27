package com.lxisoft.wayout.service;

import com.lxisoft.wayout.domain.*;


/** importing requierd classes**/

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import java.util.*;
import org.apache.log4j.Logger;

/**
*@author sooraj pn
*     
**/

public interface AdminService
{


	/**
	*
	*@param user
	*method to promote user as given role
	*
	**/

	public void promoteUser(User user);

}
