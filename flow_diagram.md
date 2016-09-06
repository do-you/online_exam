#### 登录
```flow
st=>start: 开始
e=>end: 结束
op=>operation: ExamSystem::login(username,password)
cond=>condition: 登陆成功?
out=>inputoutput: 返回Teacher对象

st->op->cond
cond(yes)->out
out->e
cond(no)->op
```

#### 添加学生
```flow
start=>start: 开始
con1=>condition: 是否有现成的Group对象
op5=>operation: 新建Student对象s
op1=>operation: Teacher::addStudent(Group g, Student s)
con3=>condition: 想加到新的教学班里？
op2=>operation: 新建Group对象g
op3=>operation: 调用Teacher::addGroup(Group g)
op4=>operation: 调用Teacher::getGroups()获取所有班,然后自己选一个赋给g
end=>end: 结束

start->con1
con1(yes)->op5->op1->end
con1(no)->con3
con3(yes)->op2->op3->op5
con3(no)->op4->op5
```

#### 获取学生
```flow
start=>start: 开始
end=>end: 结束
op1=>operation: 新建Student
op2=>operation: 通过过滤条件设置Student的相关变量
op3=>operation: Teacher::getStudent(Student s)

start->op1->op2->op3->end
```

#### 删除学生
```flow
start=>start: 开始
end=>end: 结束
op1=>operation: 新建Student
op2=>operation: 通过过滤条件设置Student的相关变量
op3=>operation: Teacher::removeStudent(Student s)

start->op1->op2->op3->end
```

#### 往题库里添加题目
```flow
start=>start: 开始
op1=>operation: 新建Question
op2=>operation: 调用QuestionSet::addQuestion(Question q)往题库里添加题目
end=>end: 结束

start->op1->op2->end
```

#### 添加考试
```flow
start=>start: 开始
op1=>operation: 新建Examination
op2=>operation: 从QuestionSet获取题目
op3=>operation: 调用Examination::addQuestion(Question q)往考试里添加题目
op4=>operation: 调用Teacher::addExamination(Examination e)往系统里添加考试
end=>end: 结束

start->op1->op2->op3->op4->end
```


