package db_dto;

public class NewStDTO {
	private String manager; 
	private String id;
	private String name;
	private int kor, eng, math, sum;
	private double avg;
		
	public NewStDTO(String id, String name, int kor, int eng, int math, int sum, double avg) {
		this.id = id; this.name = name; this.kor = kor; this.eng = eng; this.math = math;
		this.sum = sum; this.avg = avg;
	}
	
	public NewStDTO(String id, int kor, int eng, int math) {
		this.id = id; this.kor = kor; this.eng = eng; this.math = math;
	}
	
	public NewStDTO() { }
	
	public String getId() {
		return id; 
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public String getManager() {
		return manager;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}		
	
}
