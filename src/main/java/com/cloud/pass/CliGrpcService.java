package com.cloud.pass;

import com.cloud.pass.grpc.client.KubectlClientGrpc;
import com.cloud.pass.grpc.client.KubectlClientGrpc.KubectlClientBlockingStub;

import io.grpc.ManagedChannelBuilder;

public class CliGrpcService {
	private static final int PORT_LOCAL = 3010;
	public static final String HOST_LOCAL = "127.0.0.1";
	private static final int PORT = 80;
	public static final String HOST = "kubectl-cli.dev.svc.cluster.local";
	protected final KubectlClientBlockingStub blockingStub;
	public CliGrpcService() {
		if (PassApplication.runEnvironment == "prod") {
			blockingStub = KubectlClientGrpc
					.newBlockingStub(ManagedChannelBuilder.forAddress(HOST, PORT).usePlaintext().build());
		}else{
			blockingStub = KubectlClientGrpc
					.newBlockingStub(ManagedChannelBuilder.forAddress(HOST_LOCAL, PORT_LOCAL).usePlaintext().build());
		}
	}
}
