package com.pm.billingservice.gRPC;

import billing.BillingServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {

}