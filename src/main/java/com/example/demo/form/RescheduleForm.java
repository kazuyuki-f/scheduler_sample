package com.example.demo.form;

/**
 * hello.jspで使用されているフォームのクラス
 * @author kazuyuki
 *
 */
public class RescheduleForm {
	
	private long interval;
	private long delay;
	
	public long getInterval() {
		return interval;
	}
	public void setInterval(long interval) {
		this.interval = interval;
	}
	public long getDelay() {
		return delay;
	}
	public void setDelay(long delay) {
		this.delay = delay;
	}
}
