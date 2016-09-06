package zhou.onlineexam;

/**
 * Created by zhou on 16-9-6.
 */

//代表一个题目
public class Question
{
    private int id = 0;
    private String question;
    private String answer;//json数组格式的选项描述
    private int rightanswer;//类choice中的选项值s的与
    private int type;

    public Question(String question, String answer, int rightanswer, int type)
    {
        this.question = question;
        this.rightanswer = rightanswer;
        this.type = type;
        this.answer = answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public int getRightanswer()
    {
        return rightanswer;
    }

    public int getType()
    {
        return type;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getAnswer()
    {
        return answer;
    }
}
