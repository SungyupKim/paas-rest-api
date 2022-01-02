package com.cloud.pass.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.cloud.pass.grpc.client.Client.GetPodsRequest;
import com.cloud.pass.grpc.client.Client.GetPodsResponse;
import com.cloud.pass.grpc.client.KubectlClientGrpc;
import com.cloud.pass.grpc.client.KubectlClientGrpc.KubectlClientBlockingStub;
import com.cloud.pass.grpc.common.Common.CommonRequest;

import io.grpc.ManagedChannelBuilder;

public class PodInfoService {
	private static final int PORT = 80;
	public static final String HOST = "kubectl-cli.dev.svc.cluster.local";
	private final static Logger log = Logger.getGlobal();
	private final KubectlClientBlockingStub blockingStub = KubectlClientGrpc
			.newBlockingStub(ManagedChannelBuilder.forAddress(HOST, PORT).usePlaintext().build());

	public GetPodsResponse getPods(String cluster, String namespace) {
		CommonRequest request = CommonRequest.newBuilder().setKubeconfig("YXBpVmVyc2lvbjogdjEKY2x1c3RlcnM6Ci0gY2x1c3RlcjoKICAgIGNlcnRpZmljYXRlLWF1dGhvcml0eS1kYXRhOiBMUzB0TFMxQ1JVZEpUaUJEUlZKVVNVWkpRMEZVUlMwdExTMHRDazFKU1VSRWVrTkRRV1psWjBGM1NVSkJaMGxWVlZST1JUazJNVUpLUjJOclluWnlaSEp5ZG1wMFNFdFJkazEzZDBSUldVcExiMXBKYUhaalRrRlJSVXdLUWxGQmQwWjZSVlpOUWsxSFFURlZSVUYzZDAxTlZFRjFUVlJWZVV4cVJUUk5lVFI0VFVJMFdFUlVTWGxOUkVWM1RWUkJlRTFxVVhwUFJtOVlSRlJOZUFwTlZFbDZUVVJCZUUxcVVYcFBSbTkzUm5wRlZrMUNUVWRCTVZWRlFYZDNUVTFVUVhWTlZGVjVUR3BGTkUxNU5IaE5TVWxDU1dwQlRrSm5hM0ZvYTJsSENqbDNNRUpCVVVWR1FVRlBRMEZST0VGTlNVbENRMmRMUTBGUlJVRjVLMGc1WWt4WGFrbE5kalJ3YVV0VVdERk9jR3BMTVhKaEwwRm1hVEpYT0ZwS1FXd0tjR1JIUVhCNloyeDNUQ3Q0YlM5SFIxTlRaVzh2Y3poeVkzSjRhMHN6WVV0VU4xZHVZVWR3Yms4eVNGUlVNbXRzTWpndkwzRnpTaXRoU1dwNlNEWTBZZ3BEYlN0dVlXSnpZamRWVTNCb1NWQXhOSEIzVm5OT2F6RlhhWHBLTVd4a1VWQjJWazlQTHpKUVZ6RnhhR1prU1dKV1UyRXhaVXhoVlVWM2FXUXlNMjlwQ25aaVlVOTBhU3NyYlRCcWRXVTJWRkpQU21WRWMxTXhXbkJpUm1GWVF6azJjbmxMUW01SGExSk9SV1p4TldWWFFqQkRabFJSVFRrNVJqZExWRGx0Tnk4S0wxZE5NRkJZUWt3MGMyaFlXVzV0Ym5OQlNIbHFMMUpvVjJOWk9XNU5VVFZwTVZOcGFUQnNTakJtY0VoWlJtRTNaRWwyUW5JM1RGbE1OazFTUTFWbU9BcGxaRkpJY0ZKTmJYWmxjSEpNWmsxRlNpODBWM04xYzJ4dWJYazNRMlpUTVc1dVlqRlZORVIzUjJVMU1rRXJMeXRUZDBsRVFWRkJRbTh4VFhkVlZFRmtDa0puVGxaSVVUUkZSbWRSVldoTFdsaHNXa3BKU0hSNU1VMTZXVTE0ZGxFNGVuYzRiMGR5T0hkSWQxbEVWbEl3YWtKQ1ozZEdiMEZWYUV0YVdHeGFTa2tLU0hSNU1VMTZXVTE0ZGxFNGVuYzRiMGR5T0hkRWQxbEVWbEl3VkVGUlNDOUNRVlYzUVhkRlFpOTZRVTVDWjJ0eGFHdHBSemwzTUVKQlVYTkdRVUZQUXdwQlVVVkJWMUpuZEhSQ1IzVndVR3BLTlVJMmVrc3dTRU5LWkc1alEydERaMkoyYjNrcmNXTTJiekJwVFVONFVqQlROMVpaU0Vnd2VtUmpVekVyWmxaYUNtZDZjelY1YmtkSVpERXJWMDUwWTBweVVUaEhiVkZZYzBOb2VuRlFUM2N3ZVRZeWRDODFlRGxHTUdwWlJtTnJOWHBaUW1sNlZUUlphemg0U0ZJNFdHY0tRVTEyUXpWT1YwZFRZVUpSTDA0MFJqWkJhVWxWY2xJclYwUnFSMmRzYnpWbGIzQk1LMWhwVmpabWVYSmhibTlPT0hGNFEzaHlLMjl1V1hkcllXSmFWQXB1WnprMVpFMUtkMVJYT1U1cE1EZElaWGszYkVWMFIzYzFOVXdyYUN0V00yNXdZazVUUzBkU2NXSklWMFpOWmpWek1Hd3dUbTlMWjJSNVJWcDNTek5rQ2k5b2JFcDJSSEZTVlcxa00wY3pVVEk0T0RFeFVWTnRlRUpQVWpSRFJFNXlRblpaVVU1TFdGVk1iR0pxUzAxb01FWm5kVWhRZWpoNVMxZE5OV0pWV0drS09EaHVVMWhZU0hkdFJGa3dXbVpMVFM5TlN6TXdVVFZZVTBFOVBRb3RMUzB0TFVWT1JDQkRSVkpVU1VaSlEwRlVSUzB0TFMwdENnPT0KICAgIHNlcnZlcjogaHR0cHM6Ly8xOTIuMTY4LjIxOS4xMTY6MTY0NDMKICBuYW1lOiBtaWNyb2s4cy1jbHVzdGVyCmNvbnRleHRzOgotIGNvbnRleHQ6CiAgICBjbHVzdGVyOiBtaWNyb2s4cy1jbHVzdGVyCiAgICB1c2VyOiBhZG1pbgogIG5hbWU6IG1pY3JvazhzCmN1cnJlbnQtY29udGV4dDogbWljcm9rOHMKa2luZDogQ29uZmlnCnByZWZlcmVuY2VzOiB7fQp1c2VyczoKLSBuYW1lOiBhZG1pbgogIHVzZXI6CiAgICB0b2tlbjogVkVOcmFWTXpOR05ZYWtNM016RnpjbmxxYUVKMlVHOVVRbFJPUld3MFoxTkdZVXBNUVM5aVRHbFBTVDBLCg==").build();
		final GetPodsRequest sampleRequest = GetPodsRequest.newBuilder().setNamespace(namespace).setReq(request).build();

		GetPodsResponse response = blockingStub.getPods(sampleRequest);
		/*
		 * blockingStub.getPods(sampleRequest, new StreamObserver<GetPodsResponse>() {
		 * 
		 * @Override public void onError(Throwable t) {
		 * log.severe("GrpcClient#sampleCall - onError"); }
		 * 
		 * @Override public void onCompleted() {
		 * log.info("GrpcClient#sampleCall - onCompleted"); }
		 * 
		 * @Override public void onNext(GetPodsResponse value) { // TODO Auto-generated
		 * method stub log.info("GrpcClient#sampleCall - {}" + value); } });
		 */
		return response;
	}
}
