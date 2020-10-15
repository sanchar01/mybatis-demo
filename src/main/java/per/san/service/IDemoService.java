package per.san.service;

import per.san.domain.Student;

import java.util.List;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 8/4/2020 14:30
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 8/4/2020
 */
public interface IDemoService {

    String getContent();

    /**
     * 批量插入学生
     * @param students
     * @return
     */
    int insertList(List<Student> students);
}
