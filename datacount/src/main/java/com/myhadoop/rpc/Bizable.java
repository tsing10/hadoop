package com.myhadoop.rpc;

public interface Bizable {
	//versionD没有会抛出runtimeexception
	public static final long versionID = 10010;
	//
	public String sayHi(String name);

}