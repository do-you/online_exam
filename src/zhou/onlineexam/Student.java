package zhou.onlineexam;

import java.util.Date;

/**
 * Created by zhou on 16-9-5.
 */
public class Student
{
    //下面是各种个人信息类的变量
    private int id = 0;
    private String username = null;
    private String password = null;
    private String realname = null;
    private String sex = null;
    private Date birthday = null;
    private String telephone = null;
    //private int gradeid = 0;
    private int classid = 0;

    public Student(String username, String password, String realname, String sex, Date birthday, String telephone, int gradeid, int classid)
    {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.birthday = birthday;
        this.telephone = telephone;
        //this.gradeid = gradeid;
        this.classid = classid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRealname()
    {
        return realname;
    }

    public void setRealname(String realname)
    {
        this.realname = realname;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

//    public int getGradeid()
//    {
//        return gradeid;
//    }
//
//    public void setGradeid(int gradeid)
//    {
//        this.gradeid = gradeid;
//    }

    public int getClassid()
    {
        return classid;
    }

    public void setClassid(int classid)
    {
        this.classid = classid;
    }

    //修改完个人信息后调用这个把更改提交到数据库
    void commitChange()
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

}
