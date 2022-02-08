package com.cloud.pass;

import java.util.logging.Logger;

import com.cloud.pass.grpc.client.KubectlClientGrpc;
import com.cloud.pass.grpc.client.KubectlClientGrpc.KubectlClientBlockingStub;

import io.grpc.ManagedChannelBuilder;

public class CliGrpcService {
	private final static Logger log = Logger.getGlobal();
	private int PORT_LOCAL = 3010;
	public String HOST_LOCAL = "127.0.0.1";
	private int PORT = 80;
	public String HOST = "kubectl-cli.dev.svc.cluster.local";
	protected KubectlClientBlockingStub blockingStub;
	public CliGrpcService() {
		log.info("in costructor");
		if (PassApplication.runEnvironment == "prod") {
			log.info("in costructor prod");
			blockingStub = KubectlClientGrpc
					.newBlockingStub(ManagedChannelBuilder.forAddress(HOST, PORT).usePlaintext().build());
		}else{
			log.info("in costructor local");
			blockingStub = KubectlClientGrpc
					.newBlockingStub(ManagedChannelBuilder.forAddress(HOST_LOCAL, PORT_LOCAL).usePlaintext().build());
		}
	}
}
