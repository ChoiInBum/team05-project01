package db_student;

import java.util.ArrayList;
import java.util.Scanner;

import db_dao.NewStDAO;
import db_dto.NewStDTO;

public class DBStudentImpl implements DBStudent {
	NewStDAO dao;
	
	public DBStudentImpl() {
		dao = new NewStDAO();
	}
	
	public void display() {
		Scanner sc = new Scanner(System.in);
		String id, name;
		int num;
		
		while(true) {
			System.out.println("1. 내 성적");
			System.out.println("2. 전체 성적");
			System.out.println("3. 뒤로가기");
			System.out.print(">> ");
			num = sc.nextInt();
			System.out.println();
			switch(num) {			
			case 1:
				
				System.out.print("학생 id : ");
				id = sc.next();
				NewStDTO dto = search(id);
				
				if(dto == null) {
					System.out.println("존재하지 않는 학생입니다");
				} else {
					System.out.println();
					System.out.println("id : "+dto.getId());
					System.out.println("name : "+dto.getName());
					System.out.println("kor : "+dto.getKor());
					System.out.println("eng : "+dto.getEng());
					System.out.println("math : "+dto.getMath());
					System.out.println("sum : "+dto.getSum());
					System.out.println("avg : "+dto.getAvg());
					System.out.println();
				}
				
				break;
			case 2:
				System.out.print("학생 id : ");				
				id = sc.next();
				NewStDTO dto2 = search(id);
				
				if(dto2 == null) {
					System.out.println("존재하지 않는 회원입니다.");
				} else {
					ArrayList<NewStDTO> list = getList();
					System.out.println();
					System.out.println("----------------------- 회원 정보 -----------------------");
					System.out.println("id\tname\tkor\teng\tmath\tsum\tavg");
					System.out.println("------------------------------------------------------");
					
					for(NewStDTO d : list) {
						System.out.print(d.getId()+"\t");
						System.out.print(d.getName()+"\t");
						System.out.print(d.getKor()+"\t");
						System.out.print(d.getEng()+"\t");
						System.out.print(d.getMath()+"\t");
						System.out.print(d.getSum()+"\t");
						System.out.println(d.getAvg());
					}
					
					System.out.println();
				}
				
				break;
			case 3:
				return;
			}			
		}
	}
	
	@Override
	public boolean login(String id) {
		NewStDTO dto = new NewStDTO();
		dto.setId(id);
		return dao.login(id);
	}		
	
	@Override
	public NewStDTO search(String id) {
		NewStDTO dto = dao.search(id);
		return dto;
	}
	
	@Override
	public ArrayList<NewStDTO> getList() {
		ArrayList<NewStDTO> list = dao.getList();
		return list;
	}

}