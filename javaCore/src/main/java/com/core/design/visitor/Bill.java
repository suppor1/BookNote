package com.core.design.visitor;

/**
 * Created by jiangkai
 * Date 2018/9/20
 * 1. 元素的最底层抽象，包含一个方法 accept 用来接受访问者，这里只定义元素最基本的功能[接受访问者]
 * 一般会有一个抽象类实现该类，抽象出元素共有的特性，供具体的元素继承
 */
public interface Bill {//单个单子的接口（相当于Element）
    void accept(AbstractVisitor visitor);
}

/**
 * 定义一个抽象类，抽象出Bill 共有的属性和方法
 */
abstract class AbstractBill implements Bill{//抽象单子类，一个高层次的单子抽象
    private String item;//账单的类型
    private double amount;//账单的数额

    public AbstractBill(String item, double amount) {
        this.item = item;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }
}


/**
 * 具体的元素
 */
class IncomeBill extends AbstractBill{//收入单子 具体的单据

    public IncomeBill(String item, double amount) {
        super(item, amount);
    }

    @Override
    public void accept(AbstractVisitor visitor) {
        visitor.VisitorIncomeBill(this);
    }
}

class CustomBill extends AbstractBill{//消费的单子 具体的单据
    public CustomBill(String item, double amount) {
        super(item, amount);
    }

    @Override
    public void accept(AbstractVisitor visitor) {
        visitor.VisitorCustomBill(this);
    }
}
