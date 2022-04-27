package ds.java.smartOffice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service3.proto")
public final class ProjectManagementGrpc {

  private ProjectManagementGrpc() {}

  public static final String SERVICE_NAME = "ProjectManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.java.smartOffice.deadlineRequest,
      ds.java.smartOffice.deadlineReply> getDeadlineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deadline",
      requestType = ds.java.smartOffice.deadlineRequest.class,
      responseType = ds.java.smartOffice.deadlineReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.java.smartOffice.deadlineRequest,
      ds.java.smartOffice.deadlineReply> getDeadlineMethod() {
    io.grpc.MethodDescriptor<ds.java.smartOffice.deadlineRequest, ds.java.smartOffice.deadlineReply> getDeadlineMethod;
    if ((getDeadlineMethod = ProjectManagementGrpc.getDeadlineMethod) == null) {
      synchronized (ProjectManagementGrpc.class) {
        if ((getDeadlineMethod = ProjectManagementGrpc.getDeadlineMethod) == null) {
          ProjectManagementGrpc.getDeadlineMethod = getDeadlineMethod = 
              io.grpc.MethodDescriptor.<ds.java.smartOffice.deadlineRequest, ds.java.smartOffice.deadlineReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ProjectManagement", "deadline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.deadlineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.deadlineReply.getDefaultInstance()))
                  .setSchemaDescriptor(new ProjectManagementMethodDescriptorSupplier("deadline"))
                  .build();
          }
        }
     }
     return getDeadlineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.java.smartOffice.stateRequest,
      ds.java.smartOffice.stateReply> getCheckStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkState",
      requestType = ds.java.smartOffice.stateRequest.class,
      responseType = ds.java.smartOffice.stateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.java.smartOffice.stateRequest,
      ds.java.smartOffice.stateReply> getCheckStateMethod() {
    io.grpc.MethodDescriptor<ds.java.smartOffice.stateRequest, ds.java.smartOffice.stateReply> getCheckStateMethod;
    if ((getCheckStateMethod = ProjectManagementGrpc.getCheckStateMethod) == null) {
      synchronized (ProjectManagementGrpc.class) {
        if ((getCheckStateMethod = ProjectManagementGrpc.getCheckStateMethod) == null) {
          ProjectManagementGrpc.getCheckStateMethod = getCheckStateMethod = 
              io.grpc.MethodDescriptor.<ds.java.smartOffice.stateRequest, ds.java.smartOffice.stateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ProjectManagement", "checkState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.stateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.stateReply.getDefaultInstance()))
                  .setSchemaDescriptor(new ProjectManagementMethodDescriptorSupplier("checkState"))
                  .build();
          }
        }
     }
     return getCheckStateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProjectManagementStub newStub(io.grpc.Channel channel) {
    return new ProjectManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProjectManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProjectManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProjectManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProjectManagementFutureStub(channel);
  }

  /**
   */
  public static abstract class ProjectManagementImplBase implements io.grpc.BindableService {

    /**
     */
    public void deadline(ds.java.smartOffice.deadlineRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.deadlineReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeadlineMethod(), responseObserver);
    }

    /**
     */
    public void checkState(ds.java.smartOffice.stateRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.stateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckStateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeadlineMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.java.smartOffice.deadlineRequest,
                ds.java.smartOffice.deadlineReply>(
                  this, METHODID_DEADLINE)))
          .addMethod(
            getCheckStateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.java.smartOffice.stateRequest,
                ds.java.smartOffice.stateReply>(
                  this, METHODID_CHECK_STATE)))
          .build();
    }
  }

  /**
   */
  public static final class ProjectManagementStub extends io.grpc.stub.AbstractStub<ProjectManagementStub> {
    private ProjectManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProjectManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProjectManagementStub(channel, callOptions);
    }

    /**
     */
    public void deadline(ds.java.smartOffice.deadlineRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.deadlineReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeadlineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkState(ds.java.smartOffice.stateRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.stateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckStateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProjectManagementBlockingStub extends io.grpc.stub.AbstractStub<ProjectManagementBlockingStub> {
    private ProjectManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProjectManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProjectManagementBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.java.smartOffice.deadlineReply deadline(ds.java.smartOffice.deadlineRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeadlineMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.java.smartOffice.stateReply checkState(ds.java.smartOffice.stateRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckStateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProjectManagementFutureStub extends io.grpc.stub.AbstractStub<ProjectManagementFutureStub> {
    private ProjectManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProjectManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProjectManagementFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.java.smartOffice.deadlineReply> deadline(
        ds.java.smartOffice.deadlineRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeadlineMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.java.smartOffice.stateReply> checkState(
        ds.java.smartOffice.stateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckStateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DEADLINE = 0;
  private static final int METHODID_CHECK_STATE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProjectManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProjectManagementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DEADLINE:
          serviceImpl.deadline((ds.java.smartOffice.deadlineRequest) request,
              (io.grpc.stub.StreamObserver<ds.java.smartOffice.deadlineReply>) responseObserver);
          break;
        case METHODID_CHECK_STATE:
          serviceImpl.checkState((ds.java.smartOffice.stateRequest) request,
              (io.grpc.stub.StreamObserver<ds.java.smartOffice.stateReply>) responseObserver);
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

  private static abstract class ProjectManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.java.smartOffice.ProjectManagementServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProjectManagement");
    }
  }

  private static final class ProjectManagementFileDescriptorSupplier
      extends ProjectManagementBaseDescriptorSupplier {
    ProjectManagementFileDescriptorSupplier() {}
  }

  private static final class ProjectManagementMethodDescriptorSupplier
      extends ProjectManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProjectManagementMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProjectManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProjectManagementFileDescriptorSupplier())
              .addMethod(getDeadlineMethod())
              .addMethod(getCheckStateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
