package org.bildit.dao;

import java.util.ArrayList;

public interface WordsDaoInteface {

	public void addWord(String word);
	
	public void deleteWord(String word);
	
	public ArrayList<String> getWords();

	public String getWord(); 
}
