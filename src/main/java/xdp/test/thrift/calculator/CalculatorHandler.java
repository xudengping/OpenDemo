package xdp.test.thrift.calculator;

/**
 * create by dengpingxu on 2018/1/29
 * version 1.0.0
 */
public class CalculatorHandler implements  CalculatorService.Iface{
    public int add(int num1, int num2) throws org.apache.thrift.TException {
        return num1+num2;
    }

    public int minus(int num1, int num2) throws org.apache.thrift.TException {
        return num1-num2;
    }

    public int multi(int num1, int num2) throws org.apache.thrift.TException {
        return num1*num2;
    }

    public int divi(int num1, int num2) throws org.apache.thrift.TException {
        if(num2 == 0){
            throw new RuntimeException("分母不能为0");
        }
        return num1/num2;
    }
}
