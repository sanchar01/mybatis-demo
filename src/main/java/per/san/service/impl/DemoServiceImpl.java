package per.san.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.domain.Student;
import per.san.mapper.StudentMapper;
import per.san.service.IDemoService;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 8/4/2020 14:31
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 8/4/2020
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public String getContent() {
        return studentMapper.selectByStudentSelective(new Student()).toString();
    }


}
