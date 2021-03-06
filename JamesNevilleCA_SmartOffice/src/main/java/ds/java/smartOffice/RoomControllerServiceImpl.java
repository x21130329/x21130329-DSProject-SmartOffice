// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service1.proto

package ds.java.smartOffice;

public final class RoomControllerServiceImpl {
  private RoomControllerServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_doorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_doorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_doorReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_doorReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tempRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tempRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tempReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tempReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lightRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lightRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lightReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lightReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016service1.proto\"\037\n\013doorRequest\022\020\n\010passC" +
      "ode\030\001 \001(\005\"\034\n\tdoorReply\022\017\n\007success\030\001 \001(\t\"" +
      "+\n\013tempRequest\022\r\n\005temp1\030\001 \001(\005\022\r\n\005temp2\030\002" +
      " \001(\t\"5\n\ttempReply\022\023\n\013tempResult1\030\001 \001(\005\022\023" +
      "\n\013tempResult2\030\002 \001(\t\"\036\n\014lightRequest\022\016\n\006l" +
      "ights\030\001 \001(\t\" \n\nlightReply\022\022\n\nlightState\030" +
      "\001 \001(\t2\214\001\n\016RoomController\022(\n\ndoorAccess\022\014" +
      ".doorRequest\032\n.doorReply\"\000\022&\n\006airCon\022\014.t" +
      "empRequest\032\n.tempReply\"\0000\001\022(\n\010lighting\022\r" +
      ".lightRequest\032\013.lightReply\"\000B2\n\023ds.java." +
      "smartOfficeB\031RoomControllerServiceImplP\001" +
      "b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_doorRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_doorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_doorRequest_descriptor,
        new java.lang.String[] { "PassCode", });
    internal_static_doorReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_doorReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_doorReply_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_tempRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_tempRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tempRequest_descriptor,
        new java.lang.String[] { "Temp1", "Temp2", });
    internal_static_tempReply_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_tempReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tempReply_descriptor,
        new java.lang.String[] { "TempResult1", "TempResult2", });
    internal_static_lightRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_lightRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lightRequest_descriptor,
        new java.lang.String[] { "Lights", });
    internal_static_lightReply_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_lightReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lightReply_descriptor,
        new java.lang.String[] { "LightState", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
