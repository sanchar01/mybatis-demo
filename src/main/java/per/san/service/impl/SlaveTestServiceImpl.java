package per.san.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.domain.Student;
import per.san.mapper.StudentMapper;
import per.san.service.ISlaveTestService;

import java.util.List;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 2020/10/12 11:39 上午
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 2020/10/12
 */
@Service
@DS("slave")
public class SlaveTestServiceImpl implements ISlaveTestService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public int insertList(List<Student> students) {
        return studentMapper.insertList(students);
    }
}
