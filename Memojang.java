import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.*;

public class Memojang {
    private static MemoList memoList = new MemoList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        do {
            System.out.println("1. 입력, 2. 목록 보기, 3. 수정, 4. 삭제, 5. 종료");
            System.out.print(">> ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    System.out.println(" < 메 모 장 > ");
                    System.out.println("");
                    System.out.println("이름을 입력해 주세요:");
                    System.out.print(">> ");
                    String userID = sc.nextLine();
                    System.out.println(" 비밀번호를 입력해 주세요: ");
                    System.out.print(">> ");
                    int userPassword = sc.nextInt();
                    sc.nextLine();
                    System.out.println("작성할 메모를 입력해 주세요: ");
                    System.out.print(">> ");
                    String content = sc.nextLine();
                    break;

                case 2:
                    showMemoList();
                    break;

                case 3:
                    System.out.println("["+ " 메모 수정 " +"]");
                    System.out.println("수정할 메모의 인덱스를 입력해 주세요:");
                    System.out.print(">> ");
                    int index = scanner.nextInt();
                    sc.nextLine();
                    System.out.println("비밀번호를 입력해 주세요:");
                    System.out.print(">> ");
                    String password = scanner.next();
                    System.out.println("새로운 내용을 입력해 주세요:");
                    System.out.print(">> ");
                    scanner.nextLine();
                    String newContent = scanner.nextLine();
                    memoList.modifyMemo(index, password, newContent);
                    break;

                case 4:
                    public static void delete() {
                    Scanner sc = new Scanner(System.in);

                    System.out.println("["+ " 메모 삭제 " +"]");
                    System.out.println("삭제할 메모의 인덱스를 입력해 주세요.");
                    int index = scanner.nextInt();
                    sc.next();

                    for (int i=0; i<memoList.size(); i++) {
                        if(memoList.get(i).getNumber().equals((number))) {
                            memoList.remove(i)
                        }
                    }

                    break;

                case 5:
                    isRunning = false;
                    break;

                default:
                    System.out.println("잘못된 선택입니다.");
                    break;
            }
        } while (isRunning);

        scanner.close();
        System.out.println("프로그램을 종료합니다.");
    }

    private static void createMemo(Scanner scanner) {
        System.out.println("이름을 입력해 주세요:");
        System.out.print(">> ");
        String name = scanner.next();
        System.out.println("비밀번호를 입력해 주세요:");
        System.out.print(">> ");
        String password = scanner.next();
        System.out.println("내용을 입력해 주세요:");
        System.out.print(">> ");
        scanner.nextLine();
        String content = scanner.nextLine();

        Memo memo = new Memo(0, name, password, content, LocalDateTime.now());
        memoList.addMemo(memo);

        System.out.println("메모가 작성되었습니다.");
    }

    private static void showMemoList() {
        List<Memo> memos = memoList.getMemos();
        if (memos.isEmpty()) {
            System.out.println("메모가 없습니다.");
        } else {
            System.out.println("-------------------");
            for (Memo memo : memos) {
                System.out.println("인덱스 : " + memo.getIndex());
                System.out.println("제목 : " + memo.getName());
                System.out.println("내용 : " + memo.getContent());
                System.out.println("작성일 : " + memo.getTimestamp());
                System.out.println("-------------------");
            }
        }
    }
}