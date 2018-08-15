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
	*method to promote user as given role
	*@param user
	*
	**/

	public void promoteUser(User user);

}
