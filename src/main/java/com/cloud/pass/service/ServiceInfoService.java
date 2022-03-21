package com.cloud.pass.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.pass.CliGrpcService;
import com.cloud.pass.cluster.ClusterService;
import com.cloud.pass.cluster.ClusterVO;
import com.cloud.pass.grpc.client.Client.GetServiceRequest;
import com.cloud.pass.grpc.client.Client.GetServiceResponse;
import com.cloud.pass.grpc.common.Common.CommonRequest;

@Service
public class ServiceInfoService extends CliGrpcService{
	private final static Logger log = Logger.getGlobal();
	
	@Autowired
	private ClusterService clusterService;
	
	public ServiceInfoService() {
		super();
	}
	
	public GetServiceResponse getServiceInfo(String cluster, String namespace) {
		super.setClient();
		ClusterVO clusterInfo = clusterService.findById(cluster);
		
		if (clusterInfo == null) {
			return null;
		}
		CommonRequest request = CommonRequest.newBuilder().setKubeconfig(clusterInfo.getKubeconfig()).build();
		GetServiceRequest sampleRequest = GetServiceRequest.newBuilder().setNamespace(namespace).setReq(request).build();

		GetServiceResponse response = blockingStub.getServices(sampleRequest);
		return response;
	}
}
