package problem.MemoList.memo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MemoList {
    ArrayList<Memo> memoArrayList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private int memoIndex=1;

    public int getMemoIndex(){
        return memoIndex;
    }
    public void plusMemoIndex(){
        memoIndex++;
    }


    public void addMemoList(){
        System.out.println("작성자를 입력하세요.");
        String name = sc.next();
        System.out.println("암호를 입력하세요.");
        String password = sc.next();
        System.out.println("메모를 입력하세요.");
        sc.nextLine();
        String content = sc.nextLine();
        Memo memo = new Memo(getMemoIndex(),name,password,content);
        System.out.println("메모가 입력됐습니다.");
        plusMemoIndex();
        memoArrayList.add(memo);
    }

    public void showAllMemo(){
        for(Memo memo : memoArrayList){
            System.out.println(memo.getIndex()+"번 메모\n작성시간 : " +memo.getTimestamp() +"\n작성자 : "+memo.getName()+".\n내용 : "+memo.getContent()+"\n");
        }
    }

    //    글의 수정 또는 삭제 시 글 번호를 넘겨 받고 리스트에서 글 번호에 해당하는  글 1건을 얻어와 리턴 시키는 메소드가 있다.
//    public boolean checkMemoEmpty(){
//        if(memoArrayList.isEmpty()) {
//            return true;
//        } else {
//            return false;
//        }
//    }


    public void deleteMemoOnList(Memo memo){
        memoArrayList.remove(memo);
        resetIndex();
    }

    public void resetIndex(){
        memoIndex = 1;
        for(Memo memo : memoArrayList){
            memo.setIndex(memoIndex);
            memoIndex++;
        }
    }

    public Memo getMemo(){
        System.out.println("메모번호를 입력해주세요.");
        Memo memo = findMemo(sc.nextInt());
        return memo;
    }

    public Memo findMemo(int index){
        int targetIdx=index;
        Memo targetMemo=new Memo();
        for (Memo memo : memoArrayList){
            if(memo.getIndex()!=targetIdx){
            } else {
                targetMemo=memo;
                break;
            }
        }
        return targetMemo;
    }

    public void modifyMemoOnList(Memo targetMemo, String content) {
        targetMemo.setContent(content);
    }



}
