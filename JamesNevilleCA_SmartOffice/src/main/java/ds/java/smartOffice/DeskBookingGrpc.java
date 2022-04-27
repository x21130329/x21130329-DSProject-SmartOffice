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
    comments = "Source: service2.proto")
public final class DeskBookingGrpc {

  private DeskBookingGrpc() {}

  public static final String SERVICE_NAME = "DeskBooking";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.java.smartOffice.loginRequest,
      ds.java.smartOffice.loginRequest> getPortalLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "portalLogin",
      requestType = ds.java.smartOffice.loginRequest.class,
      responseType = ds.java.smartOffice.loginRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.java.smartOffice.loginRequest,
      ds.java.smartOffice.loginRequest> getPortalLoginMethod() {
    io.grpc.MethodDescriptor<ds.java.smartOffice.loginRequest, ds.java.smartOffice.loginRequest> getPortalLoginMethod;
    if ((getPortalLoginMethod = DeskBookingGrpc.getPortalLoginMethod) == null) {
      synchronized (DeskBookingGrpc.class) {
        if ((getPortalLoginMethod = DeskBookingGrpc.getPortalLoginMethod) == null) {
          DeskBookingGrpc.getPortalLoginMethod = getPortalLoginMethod = 
              io.grpc.MethodDescriptor.<ds.java.smartOffice.loginRequest, ds.java.smartOffice.loginRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "DeskBooking", "portalLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.loginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.loginRequest.getDefaultInstance()))
                  .setSchemaDescriptor(new DeskBookingMethodDescriptorSupplier("portalLogin"))
                  .build();
          }
        }
     }
     return getPortalLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.java.smartOffice.deskRequest,
      ds.java.smartOffice.deskReply> getBookDeskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookDesk",
      requestType = ds.java.smartOffice.deskRequest.class,
      responseType = ds.java.smartOffice.deskReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.java.smartOffice.deskRequest,
      ds.java.smartOffice.deskReply> getBookDeskMethod() {
    io.grpc.MethodDescriptor<ds.java.smartOffice.deskRequest, ds.java.smartOffice.deskReply> getBookDeskMethod;
    if ((getBookDeskMethod = DeskBookingGrpc.getBookDeskMethod) == null) {
      synchronized (DeskBookingGrpc.class) {
        if ((getBookDeskMethod = DeskBookingGrpc.getBookDeskMethod) == null) {
          DeskBookingGrpc.getBookDeskMethod = getBookDeskMethod = 
              io.grpc.MethodDescriptor.<ds.java.smartOffice.deskRequest, ds.java.smartOffice.deskReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DeskBooking", "bookDesk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.deskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.deskReply.getDefaultInstance()))
                  .setSchemaDescriptor(new DeskBookingMethodDescriptorSupplier("bookDesk"))
                  .build();
          }
        }
     }
     return getBookDeskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeskBookingStub newStub(io.grpc.Channel channel) {
    return new DeskBookingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeskBookingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DeskBookingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeskBookingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DeskBookingFutureStub(channel);
  }

  /**
   */
  public static abstract class DeskBookingImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ds.java.smartOffice.loginRequest> portalLogin(
        io.grpc.stub.StreamObserver<ds.java.smartOffice.loginRequest> responseObserver) {
      return asyncUnimplementedStreamingCall(getPortalLoginMethod(), responseObserver);
    }

    /**
     */
    public void bookDesk(ds.java.smartOffice.deskRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.deskReply> responseObserver) {
      asyncUnimplementedUnaryCall(getBookDeskMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPortalLoginMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.java.smartOffice.loginRequest,
                ds.java.smartOffice.loginRequest>(
                  this, METHODID_PORTAL_LOGIN)))
          .addMethod(
            getBookDeskMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.java.smartOffice.deskRequest,
                ds.java.smartOffice.deskReply>(
                  this, METHODID_BOOK_DESK)))
          .build();
    }
  }

  /**
   */
  public static final class DeskBookingStub extends io.grpc.stub.AbstractStub<DeskBookingStub> {
    private DeskBookingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeskBookingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeskBookingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeskBookingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.java.smartOffice.loginRequest> portalLogin(
        io.grpc.stub.StreamObserver<ds.java.smartOffice.loginRequest> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getPortalLoginMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void bookDesk(ds.java.smartOffice.deskRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.deskReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBookDeskMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DeskBookingBlockingStub extends io.grpc.stub.AbstractStub<DeskBookingBlockingStub> {
    private DeskBookingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeskBookingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeskBookingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeskBookingBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.java.smartOffice.deskReply bookDesk(ds.java.smartOffice.deskRequest request) {
      return blockingUnaryCall(
          getChannel(), getBookDeskMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DeskBookingFutureStub extends io.grpc.stub.AbstractStub<DeskBookingFutureStub> {
    private DeskBookingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeskBookingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeskBookingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeskBookingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.java.smartOffice.deskReply> bookDesk(
        ds.java.smartOffice.deskRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBookDeskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BOOK_DESK = 0;
  private static final int METHODID_PORTAL_LOGIN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DeskBookingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeskBookingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BOOK_DESK:
          serviceImpl.bookDesk((ds.java.smartOffice.deskRequest) request,
              (io.grpc.stub.StreamObserver<ds.java.smartOffice.deskReply>) responseObserver);
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
        case METHODID_PORTAL_LOGIN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.portalLogin(
              (io.grpc.stub.StreamObserver<ds.java.smartOffice.loginRequest>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DeskBookingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeskBookingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.java.smartOffice.DeskBookingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeskBooking");
    }
  }

  private static final class DeskBookingFileDescriptorSupplier
      extends DeskBookingBaseDescriptorSupplier {
    DeskBookingFileDescriptorSupplier() {}
  }

  private static final class DeskBookingMethodDescriptorSupplier
      extends DeskBookingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeskBookingMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeskBookingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeskBookingFileDescriptorSupplier())
              .addMethod(getPortalLoginMethod())
              .addMethod(getBookDeskMethod())
              .build();
        }
      }
    }
    return result;
  }
}
