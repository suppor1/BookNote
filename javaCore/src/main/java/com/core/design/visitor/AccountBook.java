package com.core.design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangkai
 * Date 2018/9/20
 * 接下来是账本类，它是当前访问者模式例子中的对象结构 这个类很稳定，基本不变
 */
public class AccountBook {
    List<Bill> billList = new ArrayList<Bill>();//账本中有很多账单
    public void addBill(Bill bill){
        billList.add(bill);
    }

    public void show(AbstractVisitor visitor){
        for(Bill bill : billList){
            bill.accept(visitor);
        }
    }
}
