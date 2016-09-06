#### ��¼
```flow
st=>start: ��ʼ
e=>end: ����
op=>operation: ExamSystem::login(username,password)
cond=>condition: ��½�ɹ�?
out=>inputoutput: ����Teacher����

st->op->cond
cond(yes)->out
out->e
cond(no)->op
```

#### ���ѧ��
```flow
start=>start: ��ʼ
con1=>condition: �Ƿ����ֳɵ�Group����
op5=>operation: �½�Student����s
op1=>operation: Teacher::addStudent(Group g, Student s)
con3=>condition: ��ӵ��µĽ�ѧ���
op2=>operation: �½�Group����g
op3=>operation: ����Teacher::addGroup(Group g)
op4=>operation: ����Teacher::getGroups()��ȡ���а�,Ȼ���Լ�ѡһ������g
end=>end: ����

start->con1
con1(yes)->op5->op1->end
con1(no)->con3
con3(yes)->op2->op3->op5
con3(no)->op4->op5
```

#### ��ȡѧ��
```flow
start=>start: ��ʼ
end=>end: ����
op1=>operation: �½�Student
op2=>operation: ͨ��������������Student����ر���
op3=>operation: Teacher::getStudent(Student s)

start->op1->op2->op3->end
```

#### ɾ��ѧ��
```flow
start=>start: ��ʼ
end=>end: ����
op1=>operation: �½�Student
op2=>operation: ͨ��������������Student����ر���
op3=>operation: Teacher::removeStudent(Student s)

start->op1->op2->op3->end
```

#### ������������Ŀ
```flow
start=>start: ��ʼ
op1=>operation: �½�Question
op2=>operation: ����QuestionSet::addQuestion(Question q)������������Ŀ
end=>end: ����

start->op1->op2->end
```

#### ��ӿ���
```flow
start=>start: ��ʼ
op1=>operation: �½�Examination
op2=>operation: ��QuestionSet��ȡ��Ŀ
op3=>operation: ����Examination::addQuestion(Question q)�������������Ŀ
op4=>operation: ����Teacher::addExamination(Examination e)��ϵͳ����ӿ���
end=>end: ����

start->op1->op2->op3->op4->end
```


