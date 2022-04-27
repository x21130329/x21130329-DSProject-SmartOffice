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
    comments = "Source: service1.proto")
public final class RoomControllerGrpc {

  private RoomControllerGrpc() {}

  public static final String SERVICE_NAME = "RoomController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.java.smartOffice.doorRequest,
      ds.java.smartOffice.doorReply> getDoorAccessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "doorAccess",
      requestType = ds.java.smartOffice.doorRequest.class,
      responseType = ds.java.smartOffice.doorReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.java.smartOffice.doorRequest,
      ds.java.smartOffice.doorReply> getDoorAccessMethod() {
    io.grpc.MethodDescriptor<ds.java.smartOffice.doorRequest, ds.java.smartOffice.doorReply> getDoorAccessMethod;
    if ((getDoorAccessMethod = RoomControllerGrpc.getDoorAccessMethod) == null) {
      synchronized (RoomControllerGrpc.class) {
        if ((getDoorAccessMethod = RoomControllerGrpc.getDoorAccessMethod) == null) {
          RoomControllerGrpc.getDoorAccessMethod = getDoorAccessMethod = 
              io.grpc.MethodDescriptor.<ds.java.smartOffice.doorRequest, ds.java.smartOffice.doorReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RoomController", "doorAccess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.doorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.doorReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RoomControllerMethodDescriptorSupplier("doorAccess"))
                  .build();
          }
        }
     }
     return getDoorAccessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.java.smartOffice.tempRequest,
      ds.java.smartOffice.tempReply> getAirConMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "airCon",
      requestType = ds.java.smartOffice.tempRequest.class,
      responseType = ds.java.smartOffice.tempReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.java.smartOffice.tempRequest,
      ds.java.smartOffice.tempReply> getAirConMethod() {
    io.grpc.MethodDescriptor<ds.java.smartOffice.tempRequest, ds.java.smartOffice.tempReply> getAirConMethod;
    if ((getAirConMethod = RoomControllerGrpc.getAirConMethod) == null) {
      synchronized (RoomControllerGrpc.class) {
        if ((getAirConMethod = RoomControllerGrpc.getAirConMethod) == null) {
          RoomControllerGrpc.getAirConMethod = getAirConMethod = 
              io.grpc.MethodDescriptor.<ds.java.smartOffice.tempRequest, ds.java.smartOffice.tempReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RoomController", "airCon"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.tempRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.tempReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RoomControllerMethodDescriptorSupplier("airCon"))
                  .build();
          }
        }
     }
     return getAirConMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.java.smartOffice.lightRequest,
      ds.java.smartOffice.lightReply> getLightingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lighting",
      requestType = ds.java.smartOffice.lightRequest.class,
      responseType = ds.java.smartOffice.lightReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.java.smartOffice.lightRequest,
      ds.java.smartOffice.lightReply> getLightingMethod() {
    io.grpc.MethodDescriptor<ds.java.smartOffice.lightRequest, ds.java.smartOffice.lightReply> getLightingMethod;
    if ((getLightingMethod = RoomControllerGrpc.getLightingMethod) == null) {
      synchronized (RoomControllerGrpc.class) {
        if ((getLightingMethod = RoomControllerGrpc.getLightingMethod) == null) {
          RoomControllerGrpc.getLightingMethod = getLightingMethod = 
              io.grpc.MethodDescriptor.<ds.java.smartOffice.lightRequest, ds.java.smartOffice.lightReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RoomController", "lighting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.lightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.java.smartOffice.lightReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RoomControllerMethodDescriptorSupplier("lighting"))
                  .build();
          }
        }
     }
     return getLightingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoomControllerStub newStub(io.grpc.Channel channel) {
    return new RoomControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoomControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RoomControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoomControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RoomControllerFutureStub(channel);
  }

  /**
   */
  public static abstract class RoomControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public void doorAccess(ds.java.smartOffice.doorRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.doorReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDoorAccessMethod(), responseObserver);
    }

    /**
     */
    public void airCon(ds.java.smartOffice.tempRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.tempReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAirConMethod(), responseObserver);
    }

    /**
     */
    public void lighting(ds.java.smartOffice.lightRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.lightReply> responseObserver) {
      asyncUnimplementedUnaryCall(getLightingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDoorAccessMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.java.smartOffice.doorRequest,
                ds.java.smartOffice.doorReply>(
                  this, METHODID_DOOR_ACCESS)))
          .addMethod(
            getAirConMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.java.smartOffice.tempRequest,
                ds.java.smartOffice.tempReply>(
                  this, METHODID_AIR_CON)))
          .addMethod(
            getLightingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.java.smartOffice.lightRequest,
                ds.java.smartOffice.lightReply>(
                  this, METHODID_LIGHTING)))
          .build();
    }
  }

  /**
   */
  public static final class RoomControllerStub extends io.grpc.stub.AbstractStub<RoomControllerStub> {
    private RoomControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomControllerStub(channel, callOptions);
    }

    /**
     */
    public void doorAccess(ds.java.smartOffice.doorRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.doorReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDoorAccessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void airCon(ds.java.smartOffice.tempRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.tempReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAirConMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lighting(ds.java.smartOffice.lightRequest request,
        io.grpc.stub.StreamObserver<ds.java.smartOffice.lightReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLightingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RoomControllerBlockingStub extends io.grpc.stub.AbstractStub<RoomControllerBlockingStub> {
    private RoomControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomControllerBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.java.smartOffice.doorReply doorAccess(ds.java.smartOffice.doorRequest request) {
      return blockingUnaryCall(
          getChannel(), getDoorAccessMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.java.smartOffice.tempReply airCon(ds.java.smartOffice.tempRequest request) {
      return blockingUnaryCall(
          getChannel(), getAirConMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.java.smartOffice.lightReply lighting(ds.java.smartOffice.lightRequest request) {
      return blockingUnaryCall(
          getChannel(), getLightingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RoomControllerFutureStub extends io.grpc.stub.AbstractStub<RoomControllerFutureStub> {
    private RoomControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomControllerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.java.smartOffice.doorReply> doorAccess(
        ds.java.smartOffice.doorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDoorAccessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.java.smartOffice.tempReply> airCon(
        ds.java.smartOffice.tempRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAirConMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.java.smartOffice.lightReply> lighting(
        ds.java.smartOffice.lightRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLightingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DOOR_ACCESS = 0;
  private static final int METHODID_AIR_CON = 1;
  private static final int METHODID_LIGHTING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RoomControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RoomControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DOOR_ACCESS:
          serviceImpl.doorAccess((ds.java.smartOffice.doorRequest) request,
              (io.grpc.stub.StreamObserver<ds.java.smartOffice.doorReply>) responseObserver);
          break;
        case METHODID_AIR_CON:
          serviceImpl.airCon((ds.java.smartOffice.tempRequest) request,
              (io.grpc.stub.StreamObserver<ds.java.smartOffice.tempReply>) responseObserver);
          break;
        case METHODID_LIGHTING:
          serviceImpl.lighting((ds.java.smartOffice.lightRequest) request,
              (io.grpc.stub.StreamObserver<ds.java.smartOffice.lightReply>) responseObserver);
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

  private static abstract class RoomControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoomControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.java.smartOffice.RoomControllerServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RoomController");
    }
  }

  private static final class RoomControllerFileDescriptorSupplier
      extends RoomControllerBaseDescriptorSupplier {
    RoomControllerFileDescriptorSupplier() {}
  }

  private static final class RoomControllerMethodDescriptorSupplier
      extends RoomControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RoomControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (RoomControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoomControllerFileDescriptorSupplier())
              .addMethod(getDoorAccessMethod())
              .addMethod(getAirConMethod())
              .addMethod(getLightingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
