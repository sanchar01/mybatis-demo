package per.san.mapper;

import org.apache.ibatis.annotations.Mapper;
import per.san.domain.Student;

import java.util.List;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 8/3/2020 17:42
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 8/3/2020
 */
@Mapper
public interface StudentMapper {
    /**
     * 根据输入的学生信息进行条件检索
     * 1. 当只输入用户名时， 使用用户名进行模糊检索；
     * 2. 当只输入邮箱时， 使用性别进行完全匹配
     * 3. 当用户名和性别都存在时， 用这两个条件进行查询匹配的用
     *
     * @param student
     * @return
     */
    List<Student> selectByStudentSelective(Student student);

    /**
     * 更新非空属性
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * 非空字段才进行插入
     * @param record
     * @return
     */
    int insertSelective(Student record);

    /**
     * - 当 studen_id 有值时， 使用 studen_id 进行查询；
     * - 当 studen_id 没有值时， 使用 name 进行查询；
     * - 否则返回空
     * @param record
     * @return
     */
    Student selectByIdOrName(Student record);

    /**
     * 根据输入的学生信息进行条件检索
     * 1. 当只输入用户名时， 使用用户名进行模糊检索；
     * 2. 当只输入邮箱时， 使用性别进行完全匹配
     * 3. 当用户名和性别都存在时， 用这两个条件进行查询匹配的用
     * @param student
     * @return
     */
    List<Student> selectByStudentSelectiveWhereTag(Student student);

    /**
     * 获取 id 集合中的用户信息
     * @param ids
     * @return
     */
    List<Student> selectByStudentIdList(List<Integer> ids);

    /**
     * 批量插入学生
     * @param students
     * @return
     */
    int insertList(List<Student> students);
}
