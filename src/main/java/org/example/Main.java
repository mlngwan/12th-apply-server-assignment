package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        ReservationSystem.run();
    }

    static class ReservationSystem {
        static Scanner scanner = new Scanner(System.in);
        static String[] studyRoomName = {"A", "B", "C"};
        static String[][] studyRoom = new String[12][3];
        static List<String> QnA = new ArrayList<>();

    public static void run(){
        System.out.println("스터디룸 예약 프로그램입니다.");
        firstStatus();

        while(true) {
            showNumber();
            int select = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch(select){
                case 1:
                    reserveRoom();
                    break;
                case 2:
                    checkRoom();
                    break;
                case 3:
                    makeQnA();
                    break;
                case 4:
                    showQnA();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다...");
                    return;
                default:
                    System.out.println("숫자를 다시 입력해주세요.");
            }
        }
    }

    static void showNumber(){
        System.out.println("----- 작업 -----\n");
        System.out.println("1. 스터디룸 예약");
        System.out.println("2. 예약 현황 조희");
        System.out.println("3. 문의 남기기");
        System.out.println("4. 문의 리스트 보기");
        System.out.println("5. 프로그램 종료\n");
        System.out.print("작업을 선택하세요: ");
    }

    static void firstStatus() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                studyRoom[i][j] = String.valueOf('X');
            }
        }
    }

    static void checkRoom(){
        System.out.println("----- 예약 현황 -----");
        System.out.println("| A | B | C |");
        for (int i = 0; i < 3; i++){
            System.out.print("오전 " + (i + 10) + "시| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(studyRoom[i][j] + " | ");
            }
            System.out.println();
        }

        for(int j = 3; j < studyRoom.length; j++){
            System.out.print("오후 0" + (j - 2) + "시| ");
            for (int k = 0; k < 3; k++) {
                System.out.print(studyRoom[j][k] + " | ");
            }
            System.out.println();
        }
    }

    public static void reserveRoom(){
        System.out.println("----- 스터디룸 예약 -----");
        System.out.print("예약할 스터디룸: ");
        String userRoom = scanner.nextLine();

        boolean roomExist = false;
        for (String room : studyRoomName) {
            if (userRoom.equals(room)) {
                roomExist = true;
                break;
            }
        }
        if(roomExist) {
            System.out.print("사용 시작 시간: ");
            int userStartTime = scanner.nextInt();

            if (userStartTime > 9 && userStartTime < 22) {
                System.out.print("사용 종료 시간: ");
                int userEndTime = scanner.nextInt();

                if (userEndTime > 10 && userEndTime < 23 && userStartTime < userEndTime) {
                    boolean reserveValidation = true;
                    for (int i = userStartTime - 10; i < userEndTime - 10; i++){
                        if(!studyRoom[i][userRoom.charAt(0) - 'A'].equals("X")){
                            reserveValidation = false;
                            break;
                        }
                    }
                    if (reserveValidation) {
                        System.out.println();
                        System.out.println("예약이 완료되었습니다!");
                        System.out.println();

                        for (int i = userStartTime - 10; i < userEndTime - 10; i++){
                            studyRoom[i][userRoom.charAt(0) - 'A'] = "O";
                        }
                    }

                    else {
                        System.out.println();
                       System.out.println("스터디룸" + userRoom + "는 해당시간에 이미 예약되어 있습니다.");
                       System.out.println("예약에 실패횄습니다.");
                        System.out.println();
                    }

                } else {
                    System.out.println();
                    System.out.println("종료시간을 다시 확인해주세요!");
                    System.out.println("예약에 실패횄습니다.");
                    System.out.println();
                }

            } else{
                System.out.println();
                System.out.println("시작시간을 다시 확인해주세요!");
                System.out.println("예약에 실패횄습니다.");
                System.out.println();
            }

        } else {
            System.out.println();
            System.out.println("스터디룸" + userRoom + "는 존재하지 않습니다.");
            System.out.println("예약에 실패했습니다.");
            System.out.println();
        }
    }
        static void makeQnA(){
            System.out.println("----- 문의 남기기 -----");
            System.out.print("문의 아이디: ");
            String qnAID = scanner.nextLine();

            System.out.print("문의 내용: ");
            String qnAContent = scanner.nextLine();

            QnA.add(qnAID + ": " + qnAContent);
            System.out.println();
            System.out.println("문의가 저장되었습니다!");
            System.out.println();
        }

        static void showQnA(){
            System.out.println("----- 문의 리스트 보기 -----");
            for (String show : QnA) {
                String[] splits = show.split(": ");
                System.out.println("문의 아이디: " + splits[0]);
                System.out.println("문의 내용: " + splits[1]);
                System.out.println();
            }
        }
        }
    }

