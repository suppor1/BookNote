package com.jdk8.core.lambda;

import com.jdk8.core.lambda.dto.GeoPoint;

/**
 * Created by jiangkai
 * Date 2018/6/1
 */
public class LambdaFirst {
    //内部功能，定义接口
    interface LandmarkSearch{
        int getLandmark(Integer type, GeoPoint geoPoint);
    }

    public static void main(String[] args) {
        //lambda表达式可以不指定参数类型，省略 return 关键字
        LandmarkSearch searchLandmarkMall = (type,geoPoint) -> searchLandmarkByType(type);
        // lambda 中有多条语句是需要使用大括号
        LandmarkSearch searchLandmarkSchool = (Integer type,GeoPoint geoPoint) ->{
            System.out.println();
            return searchLandmarkByType(type);
        };
        LambdaFirst lambdaFirst = new LambdaFirst();
        Integer landmarkMall = lambdaFirst.lanmark(1,new GeoPoint(1.0,3.0),searchLandmarkMall);
        System.out.println("landmarkMall:"+landmarkMall);
        Integer landmarkSchool = lambdaFirst.lanmark(2,new GeoPoint(1.0,3.0),searchLandmarkSchool);
        System.out.println("landmarkSchool:"+landmarkSchool);

    }

    public int lanmark(Integer type,GeoPoint geoPoint,LandmarkSearch search){
        return search.getLandmark(type,geoPoint);
    }

    public static int searchLandmarkByType(Integer type){
        return type;
    }
}
