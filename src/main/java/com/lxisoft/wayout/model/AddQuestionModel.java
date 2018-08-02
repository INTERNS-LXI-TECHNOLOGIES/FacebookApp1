package com.lxisoft.wayout.model;

import java.util.*;
import java.util.logging.*;
import com.lxisoft.wayout.web.*;

/**
* This class is for control Hall
*
* @author neeraja
*
* @version 1.0
*/
public class AddQuestionModel
{


	private String question;
	private String imageUrl;
	private Long id;
	private int noOfOptions;
	private String [] options;
	private String answer;


	public void setQuestion(String question){
		this.question=question;
	}
	public String getQuestion(){
		return question;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl=imageUrl;
	}
	public String getImageUrl(){
		return imageUrl;
	}

	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}

	public void setNoOfOption(int noOfOptions){
		this.noOfOptions=noOfOptions;
	}
	public int getNoOfOption(){
		return noOfOptions;
	}

	public void setOptions(String[] options){
		this.options=options;
	}
	public String[] getOptions(){
		return options;
	}

	public void setAnswer(String answer){
		this.answer=answer;
	}
	public String getAnswer(){
		return answer;
	}

	public void setOptionsOf(String opt , int i){
		options[i]=opt;
	}




}