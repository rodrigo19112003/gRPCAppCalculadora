package grpcappcalculadora.server;

import com.proto.calculator.Calculator.CalculatorRequest;
import com.proto.calculator.Calculator.CalculatorResponse;
import com.proto.calculator.CalculatorServiceGrpc.CalculatorServiceImplBase;

import io.grpc.stub.StreamObserver;

public class CalculadoraRPC extends CalculatorServiceImplBase{
    
    @Override
    public void division(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {
        CalculatorResponse response = CalculatorResponse.newBuilder().setResult(request.getFirstNumber() / request.getSecondNumber()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void multiplication(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {
        CalculatorResponse response = CalculatorResponse.newBuilder().setResult(request.getFirstNumber() * request.getSecondNumber()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addition(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {
        CalculatorResponse response = CalculatorResponse.newBuilder().setResult(request.getFirstNumber() + request.getSecondNumber()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void subtraction(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {
        CalculatorResponse response = CalculatorResponse.newBuilder().setResult(request.getFirstNumber() - request.getSecondNumber()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
