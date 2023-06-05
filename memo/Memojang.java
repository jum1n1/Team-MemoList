package problem.MemoList.memo;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class Memojang {
    static Scanner sc = new Scanner(System.in);
    private static MemoList memoList;

    public static void main(String[] args) {
        memoList = new MemoList();
        appInit();
    }


    static void appInit() {
        System.out.println("메모를하자.memo\n\n 1. 입력\n 2. 목록 보기\n 3. 수정\n 4. 삭제\n 5. 종료\n");
        selectMenu(sc.nextInt());
    }

    static void returnToAppInit(){
        System.out.println("아무키나 눌러 메뉴로 돌아가기.");
        sc.nextInt();
        appInit();
    }

    private static void selectMenu(int index){
        switch (index) {
            case 1 ->
                //입력
                    addMemo();
            case 2 ->
                //목록보기
                    showMemo();
            case 3 ->
                //수정
                    modifyMemo();
            case 4 ->
                //삭제
                    deleteMemo();
            case 5 ->
                //종료
                    sc.close();
            default -> {
                System.out.println("올바르지 않은 입력입니다.");
                appInit();
            }
        }
    }

    private static void addMemo(){
        memoList.addMemoList();
        appInit();
    }

    private static void showMemo(){
        if(memoList.memoArrayList.isEmpty()) {
            System.out.println("메모가 없습니다.");
        } else {
            memoList.showAllMemo();
        }
        returnToAppInit();
    }

    private static void modifyMemo(){
        Memo targetMemo = null;
        // 없으면 없다고, 있으면 글번호 받기
        if(memoList.memoArrayList.isEmpty()){
            System.out.println("메모가 없습니다.");
        }else {
            targetMemo = memoList.getMemo();
            // 비밀번호확인
            System.out.println("비밀번호를 입력해주세요.");
            String ans=sc.next();
            if(Objects.equals(targetMemo.getPassword(), ans)){
                System.out.println("새로운 내용을 입력하세요.");
                sc.nextLine();
                String newContent=sc.nextLine();
                memoList.modifyMemoOnList(targetMemo, newContent);
                targetMemo.resetTimestamp();
                System.out.println(targetMemo.getIndex()+"번 메모가 수정되었습니다.");// 비밀번호 확인 후 삭제.
                returnToAppInit();
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
                returnToAppInit();
            }
        }
    }

    private static void deleteMemo(){
        Memo targetMemo = null;
        // 없으면 없다고, 있으면 글번호 받기
        if(memoList.memoArrayList.isEmpty()){
            System.out.println("메모가 없습니다.");
        }else {
            targetMemo = memoList.getMemo();
        // 비밀번호확인
            System.out.println("비밀번호를 입력해주세요.");
            String ans=sc.next();
            if(Objects.equals(targetMemo.getPassword(), ans)){
                System.out.println(targetMemo.getIndex()+"번 메모가 삭제되었습니다.");// 비밀번호 확인 후 삭제.
                memoList.deleteMemoOnList(targetMemo);
                returnToAppInit();
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
                returnToAppInit();
            }
        }
    }
}