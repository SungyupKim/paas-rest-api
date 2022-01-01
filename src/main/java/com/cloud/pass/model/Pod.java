package com.cloud.pass.model;

public class Pod{
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalPods() {
		return TotalPods;
	}
	public void setTotalPods(int totalPods) {
		TotalPods = totalPods;
	}
	public int getReadyPods() {
		return ReadyPods;
	}
	public void setReadyPods(int readyPods) {
		ReadyPods = readyPods;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Pod(String namespace, String name, int totalPods, int readyPods, String status, int restarts,
			String age) {
		super();
		this.namespace = namespace;
		this.name = name;
		TotalPods = totalPods;
		ReadyPods = readyPods;
		Status = status;
		Restarts = restarts;
		Age = age;
	}
	public int getRestarts() {
		return Restarts;
	}
	public void setRestarts(int restarts) {
		Restarts = restarts;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	private String namespace;
	private String name;
	private int TotalPods;
	private int ReadyPods;
	private String Status;
	private int Restarts;
	private String Age;
}
