package per.san;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import per.san.domain.Student;
import per.san.mapper.StudentMapper;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class ApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void selectByStudent() {
        Student search = new Student();
        search.setName("明");

        System.out.println("只有名字时的查询");
        List<Student> studentsByName = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsByName.size(); i++) {
            logger.info(studentsByName.get(i).toString());
        }

        search.setName(null);
        search.setSex((byte) 1);
        System.out.println("只有性别时的查询");
        List<Student> studentsBySex = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsBySex.size(); i++) {
            logger.info(studentsByName.get(i).toString());
        }

        System.out.println("姓名和性别同时存在的查询");
        search.setName("明");
        List<Student> studentsByNameAndSex = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsByNameAndSex.size(); i++) {
            logger.info(studentsByName.get(i).toString());
        }
    }

    @Test
    public void updateByStudentSelective() {
        Student student = new Student();
        student.setStudentId(1);
        student.setName("明明");
        student.setPhone("13838438888");
        logger.info("{}", studentMapper.updateByPrimaryKeySelective(student));
    }

    @Test
    public void insertByStudentSelective() {
        Student student = new Student();
        student.setName("小飞机");
        student.setPhone("13838438899");
        student.setEmail("xiaofeiji@qq.com");
        student.setLocked((byte) 0);
        logger.info("{}", studentMapper.insertSelective(student));
    }

    @Test
    public void selectByIdOrName() {
        Student student = new Student();
        student.setName("小明");
        student.setStudentId(1);

        System.out.println("有 ID 则根据 ID 获取");
        Student studentById = studentMapper.selectByIdOrName(student);
        logger.info(studentById.toString());

        System.out.println("没有 ID 则根据 name 获取");
        student.setStudentId(null);
        Student studentByName = studentMapper.selectByIdOrName(student);
        logger.info(studentByName.toString());

        System.out.println("没有 ID 和 name, 返回 null");
        student.setName(null);
        Student studentNull = studentMapper.selectByIdOrName(student);
        logger.info("{}", studentNull);
    }

    @Test
    public void selectByStudentWhereTag() {
        Student search = new Student();
        search.setName("明");

        System.out.println("只有名字时的查询");
        List<Student> studentsByName = studentMapper.selectByStudentSelectiveWhereTag(search);
        for (int i = 0; i < studentsByName.size(); i++) {
            logger.info(studentsByName.get(i).toString());
        }

        search.setSex((byte) 1);
        System.out.println("姓名和性别同时存在的查询");
        List<Student> studentsBySex = studentMapper.selectByStudentSelectiveWhereTag(search);
        for (int i = 0; i < studentsBySex.size(); i++) {
            logger.info(studentsBySex.get(i).toString());
        }

        System.out.println("姓名和性别都不存在时查询");
        search.setName(null);
        search.setSex(null);
        List<Student> studentsByNameAndSex = studentMapper.selectByStudentSelectiveWhereTag(search);
        for (int i = 0; i < studentsByNameAndSex.size(); i++) {
            logger.info(studentsByNameAndSex.get(i).toString());
        }
    }

    @Test
    public void selectByStudentIdList() {
        List<Integer> ids = new LinkedList<>();
        ids.add(1);
        ids.add(3);
        List<Student> students = studentMapper.selectByStudentIdList(ids);
        for (int i = 0; i < students.size(); i++) {
            logger.info(students.get(i).toString());
        }
    }

    @Test
    public void insertList() {
        List<Student> students = new LinkedList<>();
        Student stu1 = new Student();
        stu1.setName("批量01");
        stu1.setPhone("13888888881");
        stu1.setLocked((byte) 0);
        stu1.setEmail("13888888881@138.com");
        stu1.setSex((byte) 1);
        students.add(stu1);

        Student stu2 = new Student();
        stu2.setName("批量02");
        stu2.setPhone("13888888882");
        stu2.setLocked((byte) 0);
        stu2.setEmail("13888888882@138.com");
        stu2.setSex((byte) 0);
        students.add(stu2);

        logger.info("{}", studentMapper.insertList(students));
    }
}
