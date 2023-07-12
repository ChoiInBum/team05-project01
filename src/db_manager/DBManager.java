package db_manager;

import java.util.ArrayList;

import db_dto.NewStDTO;

public interface DBManager {
	public void display();
	public int insert(String id, String name, int kor, int eng, int math);
	public ArrayList<NewStDTO> getlist();
	public NewStDTO search(String id);
}