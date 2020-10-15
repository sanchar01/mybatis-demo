package per.san.service;

import per.san.domain.Student;

import java.util.List;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 2020/10/12 11:38 上午
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 2020/10/12
 */
public interface ISlaveTestService {

    /**
     * 批量插入学生
     * @param students
     * @return
     */
    int insertList(List<Student> students);
}
