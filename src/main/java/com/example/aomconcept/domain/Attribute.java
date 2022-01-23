package com.example.aomconcept.domain;

import javax.naming.OperationNotSupportedException;

public class Attribute {
    // Attribute = 속성, 필드. attributType 및 value를 가져야 한다.
    private AttributeType type;

    public Attribute(AttributeType type){
        this.type = type;
    }

    public AttributeType getType(){ return type; }
    private Object value;
    public Object getValue() { return value; }
    public void setValue(Object value) {
        if(isSettable == false){
            throwOperationNotSupportException();
            return;
        }
        this.value = value;
    }
    private void throwOperationNotSupportException(){
        try { throw new OperationNotSupportedException(); }
        catch (OperationNotSupportedException e) {
            System.err.println("Attribute " + type.getName() + " is immutable.");
            e.printStackTrace();
        }
    }
    private boolean isSettable = true;
    public boolean isSettable(){ return isSettable; }
    public void setSettable(boolean isSettable){ this.isSettable = isSettable; }
}
