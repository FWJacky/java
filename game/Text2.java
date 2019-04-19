import java.util.Scanner;

/**
 * @ClassName Text2
 * @Description TODO
 * @Author L
 * @Date 2019/4/8 22:24
 * @Version 1.0
 **/

abstract class OnlineShopping {
    public final void browseGoods() {
        System.out.println("浏览商品");
    }
    public final void slesctGoods() {
        System.out.println("选择商品");
    }
    public abstract void callService();
    public final void computerPrice() {
        System.out.println("结算");
    }
    public abstract void orderPay();
    public abstract void sendService();
    public void showOrder() {
        System.out.println("查看订单");
    }
    public void process() {
        browseGoods();
        slesctGoods();
        if(isCallService()) {
            callService();
        }
        if(isComputerPrice()) {
            computerPrice();
        }
        orderPay();
        sendService();
        showOrder();
    }
    public boolean isComputerPrice() {
        return true;
    }
    public boolean isCallService() {
        return true;
    }
}
class Jd extends OnlineShopping {
    @Override
    public void callService() {
        System.out.println("京东客服为您服务");
    }

    @Override
    public boolean isCallService() {
        System.out.println("是否选择咨询客服？是 or 否");
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        if(str1.equals("是")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isComputerPrice() {
        System.out.println("是否选择结算？是 or 否");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.equals("是")) {
            return true;
        }
        return false;
    }

    @Override
    public void orderPay() {
        System.out.println("微信支付");
    }

    @Override
    public void sendService() {
        System.out.println("京东配送");
    }
}
class Tianmao extends OnlineShopping {
    @Override
    public boolean isComputerPrice() {
        System.out.println("是否选择结算？是 or 否");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.equals("是")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCallService() {
        System.out.println("是否选择咨询客服？是 or 否");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.equals("是")) {
            return true;
        }
        return false;
    }

    @Override
    public void callService() {
        System.out.println("天猫客服为您服务");
    }

    @Override
    public void orderPay() {
        System.out.println("选择支付方式：微信 or 支付宝");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("微信")) {
            System.out.println("微信支付");
        }else {
            System.out.println("支付宝支付");
        }
    }

    @Override
    public void sendService() {
        System.out.println("请选择配送方式：顺丰 or 圆通 or 中通");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("顺丰")) {
            System.out.println("顺丰配送");
        }else if (str.equals("圆通")) {
            System.out.println("圆通配送");
        }else if (str.equals("中通")) {
            System.out.println("中通配送");
        }
    }
}

class SuNing extends OnlineShopping {
    @Override
    public boolean isComputerPrice() {
        System.out.println("是否选择结算？是 or 否");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.equals("是")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCallService() {
        System.out.println("是否选择咨询客服？是 or 否");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.equals("是")) {
            return true;
        }
        return false;
    }

    @Override
    public void callService() {
        System.out.println("苏宁客服为您服务");
    }

    @Override
    public void orderPay() {
        System.out.println("选择支付方式：微信 or 支付宝");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("微信")) {
            System.out.println("微信支付");
        }else {
            System.out.println("支付宝支付");
        }
    }

    @Override
    public void sendService() {
        System.out.println("请选择配送方式：顺丰 or 圆通 or 中通");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("顺丰")) {
            System.out.println("顺丰配送");
        }else if (str.equals("圆通")) {
            System.out.println("圆通配送");
        }else if (str.equals("中通")) {
            System.out.println("中通配送");
        }
    }
}
public class Text2 {
    public static void main(String[] args) {
        Jd jd = new Jd();
        jd.process();
        Tianmao tianmao = new Tianmao();
        tianmao.process();
        SuNing suNing = new SuNing();
        suNing.process();
    }
}
