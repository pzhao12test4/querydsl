/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.jdoql;

import com.mysema.query.serialization.JavaTemplates;
import com.mysema.query.types.operation.Ops;
import com.mysema.query.types.path.PathType;

/**
 * Operation patterns for JDOQL serialization
 * 
 * @author tiwe
 * 
 */
public class JDOQLTemplates extends JavaTemplates {

    public JDOQLTemplates() {
        // String
        add(Ops.STRING_CONTAINS, "{0}.indexOf({1}) > -1", 25);
        add(Ops.EQ_IGNORECASE, "{0}.toLowerCase().equals({1}.toLowerCase())");
        add(Ops.STRING_ISEMPTY, "{0} == \"\"", 25);
        
        // Date
        add(Ops.DateTimeOps.DAY_OF_MONTH, "{0}.getDay()");
        
        // other
        add(Ops.ALIAS, "{0} {1}");
    }

}
