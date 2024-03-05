package org.example;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        ReservationSystem.run();
    }

class ReservationSystem {
    static Scanner scanner = new Scanner(System.in);

    static void PrintNumber(){
        System.out.println("스터디룸 예약 프로그램입니다.\n");
        System.out.println("----- 작업 -----\n");
        System.out.println("1. 스터디룸 예약");
        System.out.println("2. 예약 현황 조희");
        System.out.println("3. 문의 남기기");
        System.out.println("4. 문의 리스트 보기");
        System.out.println("5. 프로그램 종료\n");
        System.out.print("작업을 선택하세요: ");
    }

    public static void run(){
        int select;
        while(true) {
            PrintNumber();
            select = scanner.nextInt();
            if (select == 1){
                // 스터디룸 예약
            } else if (select == 2) {
                // 예약 현황 조회
            } else if (select == 3) {
                // 문의 남기기
            } else if (select == 4) {
                // 문의 리스트 보기
            } else if (select == 5) {
                // 프로그램 종료
            } else {
                // 예외
            }

        }
    }
}

}