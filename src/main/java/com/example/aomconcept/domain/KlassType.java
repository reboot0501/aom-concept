package com.example.aomconcept.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class KlassType {
    // 클래스 정보에 해당한다.
    KlassType parent;

    public KlassType(String name, KlassType parent){
        this.name = name;
        this.parent = parent;
        addParentAttributeTypes();
    }

    private void addParentAttributeTypes(){
        if(parent == null) return;
        Collection<AttributeType> parentAttributeTypes = parent.getAttributeTypes();
        for(AttributeType each : parentAttributeTypes){
            attributeTypes.put(each.getName(), each);
        }
    }

    Map<String, AttributeType> attributeTypes = new HashMap<>();

    public void addAttributeType(AttributeType attributeType){
        attributeTypes.put(attributeType.getName(), attributeType);
    }

    public AttributeType getAttributeType(String typeName){
        return attributeTypes.get(typeName);
    }

    public Collection<AttributeType> getAttributeTypes() {
        return attributeTypes.values();
    }

    private String name;
    public String getName(){ return name; }

}
