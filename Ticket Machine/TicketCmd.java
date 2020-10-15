import java.util.Scanner;
public class TicketCmd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicketMachine ticketMachine=new TicketMachine();

        String price1;
        int A=0;//用来验证是否成功设置车票单价
        System.out.println("使用本售票机前请先设置车票固定单价：");
        price1 = scan.nextLine();
        double price=Double.parseDouble(price1);
        ticketMachine.setPrice(price);
        if(price!=0){
            A=1;
            System.out.println("车票设置成功！");
        }
        else{
            System.out.println("输入有误，请重启售票机后重新设置车票固定单价");
        }
        while (A==1) {
            int quitFlag =0;
            System.out.println("===============欢迎使用自动售票机===============");
            System.out.println("本机销售固定票价 " + price + " 元的车票");
            while(true){
                System.out.println("请选择服务...");
                System.out.println("1、投币");
                System.out.println("2、打印车票");
                System.out.println("3、找零");
                System.out.println("Reset 重置");
                System.out.println("0 关机");
                String choice = scan.nextLine();
                    switch (choice) {
                        case "1":
                            int amount = scan.nextInt();
                            scan.nextLine();//输入回车之后才进入下一步
                            if (amount < 0) {
                                System.out.println("请正常投币...");
                            } else {
                                ticketMachine.insertMoney(amount);
                            }
                            System.out.println("当前余额：" + ticketMachine.getBalance() + " 元");
                            break;
                        case "2":
                            ticketMachine.print();
                            System.out.println("当前余额：" + ticketMachine.getBalance() + " 元");
                            if (ticketMachine.getBalance() == 0) {
                                quitFlag = 1;
                            }
                            break;
                        case "3":
                            System.out.println("请收好找零 " + ticketMachine.refund() + " 元");
                            quitFlag = 1;
                            break;
                        case "Reset":
                            System.out.println("本次运营总收入 " + ticketMachine.getTotal() + " 元");
                            ticketMachine.reset();
                            System.out.println("============本机被重置============");
                            quitFlag = 1;
                            break;
                        case "0":
                            System.exit(0);
                        default:
                            System.out.println("请输入正确的功能序号");
                    }
                    if (quitFlag == 1) {
                        break;
                    }
                }
        }
    }
}
