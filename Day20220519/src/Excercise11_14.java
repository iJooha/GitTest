import java.io.*;
import java.util.*;

public class Excercise11_14
{

static ArrayList record = new ArrayList(); // 성적데이터를 저장할 공간
static Scanner s = new Scanner(System.in);

public static void main(String args[]) {
	while(true) {
		switch(displayMenu()) {
		case 1: 
			inputrecord();
			break;
		case 2 :
			displayRecord();
		case 3 :
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			
		}
	}//while(true)
}
//menu를 보여주는 메서드

static int displayMenu() {
	System.out.println("*************************************************");
	System.out.println("*             성적 관리 프로그램                     *");
	System.out.println("*************************************************");
	System.out.println();
	System.out.println(" 1. 학생 성적 입력하기 ");
	System.out.println();
	System.out.println(" 2. 학생 성적 보기 ");
	System.out.println();
	System.out.println(" 3. 프로그램 종료 ");
	System.out.println();
	System.out.print("원하는 메뉴를 선택하세요 (1~3) : ");
	
	int menu = 0;
	
	try {
		menu = s.nextInt();
	
	System.out.println(menu);
	
	if(1<=menu && menu<=3) {
	
	}else {
		throw new Exception();
	}
	} catch(Exception e) {
	System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요.");
	System.out.print("원하는 메뉴를 선택하세요 (1~3) : ");
}
	
	return menu;
}
static void inputrecord() {
	System.out.println("1. 학생 성적 입력하기 ");
	System.out.println("'이름, 반, 번호, 국어성적, 영어성적, 수학성적'의 순서로 공백없이 입력하세요");
	System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");
	
while(true) {
	System.out.print(">>");

try {
	String input = s.nextLine();
	
	if(!input.equalsIgnoreCase("q")) {
		Scanner s2 = new Scanner(input).useDelimiter(",");
		record.add(new Student (s2.next(), s2.nextInt(), 
				s2.nextInt(),s2.nextInt(), s2.nextInt(),s2.nextLine()));
	}else {
		return;
	}
} catch(Exception e) {
	System.out.println("입력 오류 입니다. '이름, 반, 번호, 국어성적, 영어성적, 수학성적'의 순서로 공백없이 입력하세요.");
}
}
}
static void displayRecord() {
	int koreanTotal = 0;
	int englishTotal = 0;
	int mathTotal = 0;
	int total = 0;
	
	int length = record.size();
	
	if(length>0) {
		System.out.println();
		System.out.println(" 이름 반 번호 국어 영어 수학 총점 평균 전교등수 반등수");
	
		System.out.println("==================================================");
		
		for(int i =0; i<length; i++) {
			Student student = (Student)record.get(i);
			System.out.println(student);
			koreanTotal +=student.kor;
			mathTotal +=student.math;
			englishTotal +=student.eng;
			total +=student.total;
			
		}
		System.out.println("===================================================");
		System.out.println("총점 : " + koreanTotal+" "+englishTotal+" "+
		                   mathTotal+" " +total);
		System.out.println();
		
}else {
	System.out.println("================================================");
	System.out.println("데이터가 없습니다.");
	System.out.println("================================================");
}
}
}
	
	
