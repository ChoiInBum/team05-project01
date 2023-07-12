package db_student;

import java.util.ArrayList;

import db_dto.NewStDTO;

public interface DBStudent {
	public void display();
	public boolean login(String id);
	public NewStDTO search(String id);
	public ArrayList<NewStDTO> getList();
}
