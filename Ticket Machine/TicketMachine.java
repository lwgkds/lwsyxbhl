public class TicketMachine {
    double price;
    double balance;
    double total;
//设置票价
    void setPrice(double price) {
        this.price = price;
    }
//充值（投币）
    void insertMoney(double amount) {
        balance += amount;
    }
//余额
    double getBalance() {
        return balance;
    }
//打印车票
    void print() {
        if(balance<price){
            System.out.println("余额不足请继续投币");
        }else{
            System.out.println("==============================");
            System.out.println("This is a ticket");
            System.out.println("price : " + price);
            System.out.println("==============================");
            balance -= price;
            total += price;
        }
    }
//找零
    double refund() {
        double result = balance;
        balance = 0;
        return result;
    }
//总消费额
    double getTotal() {
        return total;
    }
//重置
    void reset() {
        balance = 0;
        total = 0;
    }
}

