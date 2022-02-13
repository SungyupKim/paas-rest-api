package com.cloud.pass.namespace;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.pass.CliGrpcService;
import com.cloud.pass.PassApplication;
import com.cloud.pass.cluster.ClusterService;
import com.cloud.pass.cluster.ClusterVO;
import com.cloud.pass.grpc.client.Client.GetNamespaceRequest;
import com.cloud.pass.grpc.client.Client.GetNamespaceResponse;
import com.cloud.pass.grpc.client.KubectlClientGrpc;
import com.cloud.pass.grpc.client.KubectlClientGrpc.KubectlClientBlockingStub;
import com.cloud.pass.grpc.common.Common.CommonRequest;

import io.grpc.ManagedChannelBuilder;

@Service
public class NamespaceService extends CliGrpcService{
	private final static Logger log = Logger.getGlobal();
	@Autowired
	private ClusterService clusterService;
	@Autowired
	private NamespaceRepository namespaceService;
	
	public NamespaceService() {
		super();
	}
	
	public List<NamespaceVO> getNamespaceByProjectId(String id) {
		List<NamespaceVO> namespaces = namespaceService.findByProjectId(id);
		return namespaces;
	}
	
	public GetNamespaceResponse getNamespace(String cluster) {
		super.setClient();
		ClusterVO clusterInfo = clusterService.findById(cluster);
		if (clusterInfo == null) {
			return null;
		}
		CommonRequest request = CommonRequest.newBuilder().setKubeconfig(clusterInfo.getKubeconfig()).build();
		GetNamespaceRequest sampleRequest = GetNamespaceRequest.newBuilder().setReq(request).build();
		GetNamespaceResponse response = blockingStub.getNamespaces(sampleRequest);
		return response;
	}
}
