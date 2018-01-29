package xdp.test.thrift.calculator;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.Objects;

/**
 * create by dengpingxu on 2018/1/29
 * version 1.0.0
 */
public class CalculatorClient {
    private static int port = 9090;
    private static String ip = "localhost";

    public static void main(String[] args) {
        TTransport transport = null;
        try {
            transport = createTTransport();
            openTTransport(transport);
            CalculatorService.Client client = createClient(transport);
            if(Objects.equals(client,null)){
                System.out.println("客户端创建失败。。。");
                return;
            }
            System.out.println("num1+num2="+client.add(100,200));
            System.out.println("num1-num2="+client.minus(100,200));
            System.out.println("num1*num2="+client.multi(100,200));
            System.out.println("num1/num2="+client.divi(100,200));
        } catch (TException e) {
            e.printStackTrace();
        }finally {
            if(!Objects.equals(transport,null)){
                closeTTransport(transport);
            }
        }
    }

    private static void closeTTransport(TTransport transport) {
        if(Objects.equals(transport, null)){
            return;
        }
        transport.close();
    }

    private static CalculatorService.Client createClient(TTransport transport) {
        if(Objects.equals(transport,null)){
           return null;
        }
        TBinaryProtocol protocol = new TBinaryProtocol(transport);
        if(Objects.equals(protocol,null)){
            return null;
        }
        return new CalculatorService.Client(protocol);
    }

    private static void openTTransport(TTransport transport) throws TTransportException {
        if(Objects.equals(transport,null)){
            return;
        }
        transport.open();
    }

    private static TTransport createTTransport() {
        TTransport transport = new TSocket(ip,port);
        return transport;
    }
}
