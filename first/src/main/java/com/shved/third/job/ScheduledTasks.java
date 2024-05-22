package com.shved.third.job;

import com.shved.third.service.RestServiceFirst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final RestServiceFirst restServiceFirst;

    @Scheduled(cron = "${custom-job.crone}")
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        try{
            restServiceFirst.doRequest();
        }catch (Exception exception){
            log.info("ScheduledTasks error", exception);
        }

    }
}