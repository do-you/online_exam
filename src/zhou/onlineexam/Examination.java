package zhou.onlineexam;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by zhou on 16-9-5.
 */
//代表考试
public class Examination
{
    private int id = 0;
    private int teacherid = 0;
    private String examname = null;
    private Date startdate = null;//
    private Date enddate = null;//
    private int examstatus = 0;

    public Examination(String examname, Date startdate, Date enddate)
    {
        this.examname = examname;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public ArrayList<Pair<Student, Integer>> getScore()
    {
        return null;
    }

    public ArrayList<Question> getQuestion()
    {
        return null;
    }

    public void addQuestion(Question q)
    {
    }

    public void removeQuestion(Question q)
    {
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getTeacherid()
    {
        return teacherid;
    }

    public void setTeacherid(int teacherid)
    {
        this.teacherid = teacherid;
    }

    public String getExamname()
    {
        return examname;
    }

    public Date getStartdate()
    {
        return startdate;
    }

    public Date getEnddate()
    {
        return enddate;
    }

    public int getExamstatus()
    {
        return examstatus;
    }

    public void setExamstatus(int examstatus)
    {
        this.examstatus = examstatus;
    }
}
