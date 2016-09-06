package zhou.onlineexam;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by zhou on 16-9-6.
 */
//考试系统
public class ExamSystem
{
    public static Teacher login()
    {
        return null;
    }

    private class Teacher
    {
        //下面是各种个人信息类的变量
        private int id = 0;
        private String username = null;
        private String password = null;
        private String realname = null;
        private String sex = null;
        private Date birthday = null;
        private String telephone = null;

        public Teacher(int id, String username, String password, String realname, String sex, Date birthday, String telephone)
        {
            this.id = id;
            this.username = username;
            this.password = password;
            this.realname = realname;
            this.sex = sex;
            this.birthday = birthday;
            this.telephone = telephone;
        }

        public ArrayList<Student> getStudents()
        {
            return null;
        }

        public void addStudent(Group g, Student s)
        {

        }

        public ArrayList<Student> getStudent(Student s)//待定
        {
            return null;
        }

        public int removeStudent(Student s)
        {
        }

        public void addExamination(Examination e)
        {
        }

        public void removeExamination(Examination e)
        {
        }

        public ArrayList<Group> getGroups()
        {
            return null;
        }

        public void addGroup(Group g)
        {
        }

        public void removeGroup(Group g)
        {
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

        //修改完个人信息后调用这个把更改提交到数据库
        void commitChange()
        {
        }
    }
}
