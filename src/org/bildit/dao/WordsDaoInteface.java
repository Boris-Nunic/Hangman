package org.bildit.dao;

import java.util.ArrayList;

public interface WordsDaoInteface {

	public boolean addWord(String word);
	
	public boolean deleteWord(String word);
	
	public ArrayList<String> getWords();

	public String getWord(); 
}
