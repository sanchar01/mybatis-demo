package per.san.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.san.service.IDemoService;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 8/4/2020 14:28
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 8/4/2020
 */
@Controller
public class DemoController {

    @Autowired
    IDemoService iDemoService;

    @RequestMapping("/list")
    @ResponseBody
    public String selectByStudent() {
        return iDemoService.getContent();
    }
}
