package com.example.demo.service;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.util.Config;
import com.example.demo.util.ReschedulableExecutor;

@Component 
public class TestService implements ApplicationRunner {
	private static final Logger logger = LogManager.getLogger(TestService.class);
	@Resource
	ReschedulableExecutor reschedulableExecutor;
	
	/**
	 * サーバ起動時に呼ばれる
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("call com.example.service.TestService.run");
//		reschedulableExecutor = new ReschedulableExecutor(); 	
		reschedulableExecutor.start(new TimerTask(), Config.getValueByLong("scheduler.interval"), Config.getValueByLong("scheduler.delay"));
	}
	/**
	 * 一定時間間隔で実行される処理
	 */
	private class TimerTask implements Runnable {

		private TimerTask() {
			logger.info("call com.example.service.TimerTask constructor");
		}

		@Override
		public void run() {
			logger.info("call com.example.service.TimerTask.run");
		}
	}
	
	/**
	 * 管理画面より変更された設定をスケジューラに反映する
	 * 
	 * @param localgovinfoid
	 */
	public void reschedule(long interval, long initialDelay) {
		if (interval > 0) {
			if (reschedulableExecutor == null) {
				reschedulableExecutor = new ReschedulableExecutor();
			}
			TimerTask timerTask = new TimerTask();
			reschedulableExecutor.start(timerTask, interval, initialDelay);
			return;
		}
		if (reschedulableExecutor != null) reschedulableExecutor.start(null, 0, 0);// スケジューラの停止
	}
}
