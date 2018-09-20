package com.core.design.visitor;

/**
 * Created by jiangkai
 * Date 2018/9/20
 * 访问者Visitor可以是接口或者抽象类，提供给具体的访问者实现； 访问者接口可以是两类
 * 1. 访问者接口定义一个方法，这种情况要求，被访问的元素有相同的方法，不然就访问不到了，不够灵活，但是代码量小
 * 2. 访问者接口定义的方法与结构体元素数相同，每一种方法访问一个元素，这种情况足够灵活，代码稍微多一点
 *    这种一般在高层次的抽象类中实现，接口一般定义最底层的方法即可
 */
public interface Visitor {//超级访问者接口（它支持定义高层操作）
    void visitBill(Bill bill);//Bill 是元素的一个抽象接口，里面有一个方法accept 可以接受访问者
}

abstract class AbstractVisitor implements Visitor{//比Viewer接口低一个层次的访问者接口
    /**
     * 一般在这个抽象类中定义访问者能够访问的所有元素
     */
    abstract void VisitorIncomeBill(IncomeBill incomeBill);//访问具体元素IncomeBill 的方法
    abstract void VisitorCustomBill(CustomBill customBill);//访问具体元素CustomBill 的方法


    @Override
    final public void visitBill(Bill bill) {
        System.out.println("即将访问元素"+bill.getClass().getName());
    }
}

//老板类，查看账本的类之一，作用于最低层次结构AbstractVisitor
class BosVisitor extends AbstractVisitor{ //具体的访问者类

    private double totalIncome;//总共收了多少钱
    private double totalCustom;//总共花了多少钱

    @Override
    void VisitorIncomeBill(IncomeBill incomeBill) {
        totalIncome += incomeBill.getAmount();
    }

    @Override
    void VisitorCustomBill(CustomBill customBill) {
        totalCustom += customBill.getAmount();
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalCustom() {
        return totalCustom;
    }
}

//注册会计师类，查看账本的类之一，作用于最低层次结构
class CPA extends AbstractVisitor{

    //注会在看账本时，如果是支出，则如果支出是工资，则需要看应该交的税交了没
    @Override
    void VisitorIncomeBill(IncomeBill incomeBill) {
        if (incomeBill.getItem().equals("工资")) {
            System.out.println("注会查看是否交个人所得税。");
        }
    }

    //如果是收入，则所有的收入都要交税
    @Override
    void VisitorCustomBill(CustomBill customBill) {
        System.out.println("注会查看收入交税了没。");
    }

}




