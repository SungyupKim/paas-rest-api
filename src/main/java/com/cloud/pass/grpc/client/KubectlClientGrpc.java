package com.cloud.pass.grpc.client;

import static io.grpc.MethodDescriptor.generateFullMethodName;

import io.grpc.stub.annotations.GrpcGenerated;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: client.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class KubectlClientGrpc {

  private KubectlClientGrpc() {}

  public static final String SERVICE_NAME = "KubectlClient";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.cloud.pass.grpc.client.Client.GetPodsRequest,
      com.cloud.pass.grpc.client.Client.GetPodsResponse> getGetPodsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPods",
      requestType = com.cloud.pass.grpc.client.Client.GetPodsRequest.class,
      responseType = com.cloud.pass.grpc.client.Client.GetPodsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cloud.pass.grpc.client.Client.GetPodsRequest,
      com.cloud.pass.grpc.client.Client.GetPodsResponse> getGetPodsMethod() {
    io.grpc.MethodDescriptor<com.cloud.pass.grpc.client.Client.GetPodsRequest, com.cloud.pass.grpc.client.Client.GetPodsResponse> getGetPodsMethod;
    if ((getGetPodsMethod = KubectlClientGrpc.getGetPodsMethod) == null) {
      synchronized (KubectlClientGrpc.class) {
        if ((getGetPodsMethod = KubectlClientGrpc.getGetPodsMethod) == null) {
          KubectlClientGrpc.getGetPodsMethod = getGetPodsMethod =
              io.grpc.MethodDescriptor.<com.cloud.pass.grpc.client.Client.GetPodsRequest, com.cloud.pass.grpc.client.Client.GetPodsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPods"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cloud.pass.grpc.client.Client.GetPodsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cloud.pass.grpc.client.Client.GetPodsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KubectlClientMethodDescriptorSupplier("GetPods"))
              .build();
        }
      }
    }
    return getGetPodsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KubectlClientStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KubectlClientStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KubectlClientStub>() {
        @java.lang.Override
        public KubectlClientStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KubectlClientStub(channel, callOptions);
        }
      };
    return KubectlClientStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KubectlClientBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KubectlClientBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KubectlClientBlockingStub>() {
        @java.lang.Override
        public KubectlClientBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KubectlClientBlockingStub(channel, callOptions);
        }
      };
    return KubectlClientBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KubectlClientFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KubectlClientFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KubectlClientFutureStub>() {
        @java.lang.Override
        public KubectlClientFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KubectlClientFutureStub(channel, callOptions);
        }
      };
    return KubectlClientFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class KubectlClientImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getPods(com.cloud.pass.grpc.client.Client.GetPodsRequest request,
        io.grpc.stub.StreamObserver<com.cloud.pass.grpc.client.Client.GetPodsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPodsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPodsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.cloud.pass.grpc.client.Client.GetPodsRequest,
                com.cloud.pass.grpc.client.Client.GetPodsResponse>(
                  this, METHODID_GET_PODS)))
          .build();
    }
  }

  /**
   */
  public static final class KubectlClientStub extends io.grpc.stub.AbstractAsyncStub<KubectlClientStub> {
    private KubectlClientStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KubectlClientStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KubectlClientStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getPods(com.cloud.pass.grpc.client.Client.GetPodsRequest request,
        io.grpc.stub.StreamObserver<com.cloud.pass.grpc.client.Client.GetPodsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPodsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class KubectlClientBlockingStub extends io.grpc.stub.AbstractBlockingStub<KubectlClientBlockingStub> {
    private KubectlClientBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KubectlClientBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KubectlClientBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.cloud.pass.grpc.client.Client.GetPodsResponse getPods(com.cloud.pass.grpc.client.Client.GetPodsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPodsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class KubectlClientFutureStub extends io.grpc.stub.AbstractFutureStub<KubectlClientFutureStub> {
    private KubectlClientFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KubectlClientFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KubectlClientFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cloud.pass.grpc.client.Client.GetPodsResponse> getPods(
        com.cloud.pass.grpc.client.Client.GetPodsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPodsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PODS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KubectlClientImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KubectlClientImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PODS:
          serviceImpl.getPods((com.cloud.pass.grpc.client.Client.GetPodsRequest) request,
              (io.grpc.stub.StreamObserver<com.cloud.pass.grpc.client.Client.GetPodsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class KubectlClientBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KubectlClientBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cloud.pass.grpc.client.Client.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("KubectlClient");
    }
  }

  private static final class KubectlClientFileDescriptorSupplier
      extends KubectlClientBaseDescriptorSupplier {
    KubectlClientFileDescriptorSupplier() {}
  }

  private static final class KubectlClientMethodDescriptorSupplier
      extends KubectlClientBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    KubectlClientMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (KubectlClientGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KubectlClientFileDescriptorSupplier())
              .addMethod(getGetPodsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
