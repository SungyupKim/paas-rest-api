package com.cloud.pass.pod;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.pass.grpc.client.Client.GetPodsRequest;
import com.cloud.pass.grpc.client.Client.GetPodsResponse;
import com.cloud.pass.CliGrpcService;
import com.cloud.pass.PassApplication;
import com.cloud.pass.cluster.ClusterService;
import com.cloud.pass.cluster.ClusterVO;
import com.cloud.pass.grpc.client.KubectlClientGrpc;
import com.cloud.pass.grpc.client.KubectlClientGrpc.KubectlClientBlockingStub;
import com.cloud.pass.grpc.common.Common.CommonRequest;

import io.grpc.ManagedChannelBuilder;

@Service
public class PodInfoService extends CliGrpcService{

	@Autowired
	private ClusterService clusterService;
	
	private final static Logger log = Logger.getGlobal();
	
	public PodInfoService() {
		super();
	}
	
	public GetPodsResponse getPods(String cluster, String namespace) {
		super.setClient();
		ClusterVO clusterInfo = clusterService.findById(cluster);
		if (clusterInfo == null) {
			return null;
		}
		CommonRequest request = CommonRequest.newBuilder().setKubeconfig(clusterInfo.getKubeconfig()).build();
		GetPodsRequest sampleRequest = GetPodsRequest.newBuilder().setNamespace(namespace).setReq(request).build();
		GetPodsResponse response = blockingStub.getPods(sampleRequest);
	
		return response;
	}
}
