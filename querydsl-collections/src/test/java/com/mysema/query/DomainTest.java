/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query;

import java.math.BigDecimal;
import java.util.*;

import org.junit.Test;

import com.mysema.query.annotations.Domain;

/**
 * Domain provides
 *
 * @author tiwe
 * @version $Id$
 */
public class DomainTest {
    
    @Test
    @SuppressWarnings("unused")
    public void test(){        
        QSimpleTypes st = new QSimpleTypes("st");        
        QRelationType rt = new QRelationType("rt");
        
        QRelationType2 rt2 = new QRelationType2("rt2");        
        rt2 = rt2.list(0);
        
        QGenericType gt = new QGenericType("qt");
        QItemType it = gt.itemType;
        it = new QItemType("it");
    }
    
    @Domain
    public interface InterfaceType{
        InterfaceType getRelation();
        List<InterfaceType> getRelation2();
        List<? extends InterfaceType> getRelation3();
        int getRelation4();        
    }
    
    @Domain
    public static class SimpleTypes{
        transient int test;
        long id;
        BigDecimal bigDecimal;
        Byte bbyte;
        byte bbyte2;
        Character cchar;
        char cchar2;
        Double ddouble;
        double ddouble2;
        Float ffloat;
        float ffloat2;
        Integer iint;
        int iint2;
        Locale llocale;
        Long llong;
        long llong2;
        String sstring;
        Date date;
        java.sql.Time time;
        java.sql.Timestamp timestamp;
    }
    
    @Domain
    public static class RelationType{
        // list
        List<RelationType> list;
        List<? extends RelationType> list2;
        List<String> list3;
        
        // set
        Set<RelationType> set;        
        SortedSet<RelationType> sortedSet;
        Set<String> set2;
        
        // .. of Object
        List<Object> listOfObjects;
        Set<Object> setOfObjects;
        
        // collection
        Collection<RelationType> collection;
        Collection<String> set3;
        
        // map
        Map<String,RelationType> map;
        Map<RelationType,RelationType> map2;
        Map<RelationType, String> map3;
    }
    
    @Domain
    public static class RelationType2<D extends RelationType2<D>>{
        List<D> list;
    }
    
    @Domain
    public class GenericType<T extends ItemType>{
        T itemType;        
    }        
    
    @Domain
    public class ItemType{
        
    }
    
}
