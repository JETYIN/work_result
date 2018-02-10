package com.haowan.funcell.common.sdk.api;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class PayTaskWithResult implements Callable<String> {
	private String accessToken;

	public PayTaskWithResult(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * 任务的具体过程，一旦任务传给ExecutorService的submit方法， 则该方法自动在一个线程上执行
	 */
	public String call() throws Exception {
		System.out.println("call()方法被自动调用！！！    "
				+ Thread.currentThread().getName());
		TimeUnit.SECONDS.sleep(5);
		// 该返回结果将被Future的get方法得到
		return "call()方法被自动调用，任务返回的结果是：" + accessToken + "    "
				+ Thread.currentThread().getName();
	}
}