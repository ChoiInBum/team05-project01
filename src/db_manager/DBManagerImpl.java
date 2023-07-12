package db_manager;

import java.util.ArrayList;
import java.util.Scanner;

import db_dao.NewStDAO;
import db_dto.NewStDTO;

public class DBManagerImpl implements DBManager {
	String id, name;
	int kor, eng, math;
	NewStDAO dao;
	
	public DBManagerImpl() {
		dao = new NewStDAO();
	}

	public void display() {
		Scanner input = new Scanner(System.in);
		int num;

		System.out.println("1. 성적 조회");
		System.out.println("2. 성적 추가");
		System.out.println("3. 성적 수정");
		System.out.println("4. 성적 삭제");
		System.out.print(">> ");
		num = input.nextInt();
		System.out.println();
		
		switch(num) {
		case 1: 
			ArrayList<NewStDTO> list = getlist();
			System.out.println("----------------------- 성적 정보 -----------------------");
			System.out.println("id\tname\tkor\teng\tmath\tsum\tavg");
			System.out.println("------------------------------------------------------");
			for(NewStDTO d : list) {
				System.out.print(d.getId()+"\t");
				System.out.print(d.getName()+"\t");
				System.out.print(d.getKor()+"\t");
				System.out.print(d.getEng()+"\t");
				System.out.print(d.getMath()+"\t");
				System.out.print(d.getSum()+"\t");
				System.out.println(d.getAvg()+"\t");
			}
			System.out.println();
			break;
		case 2: 
			while(true) {
				System.out.print("id 입력 : ");
				id = input.next();
				NewStDTO d = search(id);
				
				if(d == null) {
					break;
				}
				
				System.out.println("존재하는 학생입니다");
			}
			System.out.print("학생명 입력 : ");
			name = input.next();
			System.out.print("국어 점수 입력 : ");
			kor = input.nextInt();
			System.out.print("영어 점수 입력 : ");
			eng = input.nextInt();
			System.out.print("수학 점수 입력 : ");
			math = input.nextInt();

			int re = insert(id, name, kor, eng, math);
			
			if(re == 1) {
				System.out.println("추가하였습니다.");
			} else {
				System.out.println("있는 정보입니다.");
			}
			
			break;
		case 3: 
			while(true) {
				System.out.print("학생 id : ");
				id = input.next();
				NewStDTO d1 = search(id);
				
				if(d1 != null) {
					break;
				}
				
				System.out.println("존재하지 않는 학생입니다");
			}
			
			System.out.print("수정할 국어 점수 : ");
			kor = input.nextInt();
			System.out.print("수정할 영어 점수 : ");
			eng = input.nextInt();
			System.out.print("수정할 수학 점수 : ");
			math = input.nextInt();

			NewStDTO d1 = new NewStDTO(id, kor, eng, math);
			int re1 = modify(d1);
			
			if(re1 == 1) {
				System.out.println("수정하였습니다.");
				System.out.println();
			} else {
				System.out.println("문제발생");
				System.out.println();
			}
			
			break;
		case 4: 
			System.out.print("삭제할 id : ");
			id = input.next();
			int result = delete(id);

			if(result == 1) {
				System.out.println("삭제하였습니다.");
				System.out.println();
			} else {
				System.out.println("문제발생");
				System.out.println();
			}
			
			break;
		}
	}

	public int modify(NewStDTO d1) {
		return dao.modify(d1);
	}

	public int delete(String id) {
		return dao.delete(id);
	}
	
	public int insert(String id, String name, int kor, int eng, int math) {
		NewStDTO dto = new NewStDTO();
		
		dto.setId(id);
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMath(math);
		return dao.insert(dto);
	}
	
	public ArrayList<NewStDTO> getlist() {
		ArrayList<NewStDTO> list = dao.getList();
		return list;
	}
	
	public NewStDTO search(String id) {
		NewStDTO dto = dao.search(id);
		return dto;
	}
}
