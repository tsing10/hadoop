package com.myhadoop.rpc;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class RPCServer implements Bizable{

	public String sayHi(String name) {
		// TODO Auto-generated method stub
		
		//RPCServer实现Bizable接口
		return "Hi - " + name;
	}
	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		// TODO Auto-generated method stub	
		
		Server server = new RPC.Builder(new Configuration()).setProtocol(Bizable.class).setInstance(new RPCServer()).setBindAddress("win10").setPort(9527).build();
		server.start();
	}

}
