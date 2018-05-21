package org.bildit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface WordsDaoInteface {

	public void addWord(String word) throws SQLException;
	
	public void deleteWord(String word) throws SQLException;
	
	public ArrayList<String> getWords() throws SQLException; 
}
