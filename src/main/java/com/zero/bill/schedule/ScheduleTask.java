package com.zero.bill.schedule;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONArray;
import com.zero.bill.websokect.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zengzhx
 * @date 2020/6/12 4:29 PM
 */
@EnableScheduling
@Component
public class ScheduleTask {

    private Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    @Scheduled(fixedDelay = 5000)
    public void Run() {
        logger.info("定期任务执行");
        // 衬衫
        int cs = RandomUtil.randomInt(10, 100);
        // 羊毛衫
        int yms = RandomUtil.randomInt(10, 100);
        // 雪纺衫
        int xfs = RandomUtil.randomInt(10, 100);
        // 裤子
        int kz = RandomUtil.randomInt(10, 100);
        // 高跟鞋
        int ggx = RandomUtil.randomInt(10, 100);
        // 袜子
        int wz = RandomUtil.randomInt(10, 100);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(cs);
        jsonArray.add(yms);
        jsonArray.add(xfs);
        jsonArray.add(kz);
        jsonArray.add(ggx);
        jsonArray.add(wz);


        try {
            String uuid = UUID.randomUUID().toString();
            WebSocketServer.BroadCastInfo(jsonArray.toString());
        } catch (IOException e) {
            logger.error("", e);
        }
    }
}
