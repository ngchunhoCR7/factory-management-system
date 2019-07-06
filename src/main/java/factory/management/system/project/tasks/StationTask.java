package factory.management.system.project.tasks;

import factory.management.system.project.utils.MyUtils;
import org.springframework.stereotype.Component;

/**
 * StationTask
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/26 22:21
 */
@Component
public class StationTask {

    // 定义每过10秒执行任务
//    @Scheduled(fixedRate = 10000)
    // http://cron.qqe2.com/
    // @Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime() {
        System.out.println("现在时间：" + MyUtils.DateUtils.getDateTimeString());
    }
}
