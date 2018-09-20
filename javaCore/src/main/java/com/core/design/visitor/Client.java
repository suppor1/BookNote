package com.core.design.visitor;

/**
 * Created by jiangkai
 * Date 2018/9/20
 */
public class Client {
    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();

        //添加两条收入
        accountBook.addBill(new IncomeBill("卖商品",10000));
        accountBook.addBill(new IncomeBill("卖广告位",12000));
        //添加两条支出
        accountBook.addBill(new CustomBill("工资",1000));
        accountBook.addBill(new CustomBill("材料费",2000));

        //访问者
        BosVisitor bosVisitor = new BosVisitor();
        CPA cpa = new CPA();

        accountBook.show(bosVisitor);

        System.out.println("共消费："+bosVisitor.getTotalCustom());
        System.out.println("共收入："+bosVisitor.getTotalIncome());

        accountBook.show(cpa);
    }
}
