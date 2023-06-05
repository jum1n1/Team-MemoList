package problem.MemoList.memo;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Memo {
    private int index;
    private String name;
    private String password;
    private String content;
    private String time;

    public Memo(){}

    public Memo(int index, String name, String password, String content) {
        this.index = index;
        this.name = name;
        this.password = password;
        this.content = content;

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.time = formatter.format(date);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return this.time;
    }

    public void setTimestamp(String timestamp) {
        this.time = timestamp;
    }
    public void resetTimestamp() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.time = formatter.format(date);
    }

    public void setTimestamp(LocalDateTime now) {
    }
}