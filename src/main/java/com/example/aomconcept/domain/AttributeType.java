package com.example.aomconcept.domain;

import java.util.HashMap;
import java.util.Map;

public class AttributeType {
    // 클래스에 속성(변수)을 선언하면 int data; 와 같이 선언한다. 이 정보를 이 클래스가 가지고 있어야 한다.
    Map<String, KlassType> klassTypes = new HashMap<>();

    @SuppressWarnings("rawtypes")
    private Class typeClass;
    @SuppressWarnings("rawtypes")
    public Class getTypeClass(){ return typeClass; }
    public String getTypeClassName(){
        String typeName = typeClass.getName();
        typeName = typeName.substring(typeName.lastIndexOf(".") + 1);
        return typeName;
    }
    @SuppressWarnings("rawtypes")
    public AttributeType(Class typeClass, String name, String description){
        this.typeClass = typeClass;
        this.name = name;
    }
    private String name;
    public String getName() { return name; }
    private String description;
    public String getDescription(){ return description; }
}
