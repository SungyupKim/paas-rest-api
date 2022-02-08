package com.cloud.pass;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cloud.pass.grpc.client.KubectlClientGrpc;
import com.cloud.pass.grpc.client.KubectlClientGrpc.KubectlClientBlockingStub;

import io.grpc.ManagedChannelBuilder;

@Service
public class CliGrpcService {
	private final static Logger log = Logger.getGlobal();
	@Value("${grpc.port}")
	protected int PORT;
	@Value("${grpc.host}") 
	protected String HOST;
	protected KubectlClientBlockingStub blockingStub;
	public CliGrpcService() {
	}
	
	public void setClient() {
		blockingStub = KubectlClientGrpc
				.newBlockingStub(ManagedChannelBuilder.forAddress(HOST, PORT).usePlaintext().build());	
	}
}
