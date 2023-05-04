package com.food.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
public boolean idValidation(int id)
{
	if(id>0)
		return true;
	else
	return false;
}
public boolean nameValidation(String name)
{
	Pattern p=Pattern.compile("[a-zA-Z]+");
	Matcher m=p.matcher(name);
	boolean nm=m.matches();
	if(nm&&name!=null)
	return true;
	else
	return false;
	
}
public boolean passwordValidation(String password)
{
	Pattern p=Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
	Matcher m=p.matcher(password);
	boolean pw=m.matches();
	if(pw)
		return true;
	else
		return false;	
}
public boolean menuIdValidation(int menuId)
{
	if(menuId>100)
		return true;
	else
	return false;
	
}
public boolean emailValidation(String email)
{
	Pattern p=Pattern.compile("^(.+)@(.+)$");
	Matcher m=p.matcher(email);
	boolean mail=m.matches();
	if(mail &&email!=null)
		return true;
		else
			return false;
					}
public boolean phoneNumberValidation(String phoneNumber)
{
	Pattern p=Pattern.compile("(0/91)?[7-9][0-9]{9}");
    Matcher m=p.matcher(phoneNumber);
    boolean phn=m.matches();
    if(phn)
       return true;
    else
    	return false; 
}
public boolean numberValidation(int quantity)
{
	if(quantity>0)
		return true;
	else
		return false;
}
}
