package grpcappcalculadora.client;

import com.proto.calculator.Calculator.CalculatorRequest;
import com.proto.calculator.Calculator.CalculatorResponse;
import com.proto.calculator.CalculatorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;

        ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress(host, port)
        .usePlaintext()
        .build();

        CalculatorServiceGrpc.CalculatorServiceBlockingStub stub = CalculatorServiceGrpc.newBlockingStub(managedChannel);
        CalculatorRequest request;
        CalculatorResponse response;

        while (true) {
            String option = JOptionPane.showInputDialog(
                "Calular\n" +
                "Suma........................................... (1)\n" +
                "Resta........................................... (2)\n" +
                "Multiplicacion............................. (3)\n" +
                "Division....................................... (4)\n"
            );

            if (option == null) {
                break;
            }

            float firstNumber = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el primer numero"));
            float secondNumber = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el segundo numero"));

            switch (option) {
                case "1":
                    request = CalculatorRequest.newBuilder().setFirstNumber(firstNumber).setSecondNumber(secondNumber).build();
                    response = stub.addition(request);
                    JOptionPane.showMessageDialog(null, firstNumber + " + " + secondNumber + " = " + response.getResult());
                    break;
                case "2":
                    request = CalculatorRequest.newBuilder().setFirstNumber(firstNumber).setSecondNumber(secondNumber).build();
                    response = stub.subtraction(request);
                    JOptionPane.showMessageDialog(null, firstNumber + " - " + secondNumber + " = " + response.getResult());
                    break;
                case "3":
                    request = CalculatorRequest.newBuilder().setFirstNumber(firstNumber).setSecondNumber(secondNumber).build();
                    response = stub.multiplication(request);
                    JOptionPane.showMessageDialog(null, firstNumber + " * " + secondNumber + " = " + response.getResult());
                    break;
                case "4":
                    request = CalculatorRequest.newBuilder().setFirstNumber(firstNumber).setSecondNumber(secondNumber).build();
                    response = stub.division(request);
                    JOptionPane.showMessageDialog(null, firstNumber + " / " + secondNumber + " = " + response.getResult());
                    break;
                default:
                    break;
            }
        }

        managedChannel.shutdown();
    }
}
