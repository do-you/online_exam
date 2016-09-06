package zhou.onlineexam;

/**
 * Created by zhou on 16-9-5.
 */
//代表教学班
public class Group
{
    private int id = 0;
    //private int gradeid = 0;
    private String classname = null;

    public Group(String classname)
    {
        this.classname = classname;
    }

    public String getClassname()
    {
        return classname;
    }

    public void setClassname(String classname)
    {
        this.classname = classname;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
