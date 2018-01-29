package xdp.test.thrift.calculator;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import sun.reflect.generics.tree.VoidDescriptor;

/**
 * create by dengpingxu on 2018/1/29
 * version 1.0.0
 */
public class CalculatorServer {
    private static int port = 9090;

    /**
     * 启动服务器
     * @param processor
     */
    public static void start(CalculatorService.Processor processor){

        try {
            TServerTransport serverTransport = new TServerSocket(port);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the simple server...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CalculatorHandler handler = new CalculatorHandler();
        CalculatorService.Processor processor = new CalculatorService.Processor(handler);
        start(processor);
    }
}
