import com.czf.base.common.Constant;
import com.czf.gen.service.SysGeneratorService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 代码生成测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class GenTest {
    private static Logger logger = Logger.getLogger(GenTest.class);

    @Resource
    private SysGeneratorService generatorService;

    @Before
    public void before() {

    }
    @Test
    public void generatorCode() {
        byte[]  bytes = generatorService.generatorCode(new String[]{"sys_user"}, Constant.genType.local.getValue());
    }
}
