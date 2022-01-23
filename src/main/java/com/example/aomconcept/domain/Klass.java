package com.example.aomconcept.domain;

import javax.naming.directory.NoSuchAttributeException;
import java.util.HashMap;
import java.util.Map;

public class Klass {
// 객체에 해당한다.
    public Klass(KlassType type, String name, String id){
        this.type = type;
        this.name = name;
        this.id = id;
        initAttributes();
    }

    private void initAttributes(){
        for(AttributeType attributeType : type.getAttributeTypes()){
            attributes.put(attributeType.getName(), new Attribute(attributeType));
        }
    }

    private KlassType type;
    public KlassType getType(KlassType type){ return type; }

    String name;
    public String getName(){ return name; }

    String id;
    public String getId(){ return id; }

    Map<String, Attribute> attributes = new HashMap<>();
    public Object get(String name){
        Attribute attr = attributes.get(name);
        if(attr != null) return attr.getValue();
        else throwNoSuchAttributeException(name);
        return null;
    }

    public void set(String name, Object value){
        Attribute attr = attributes.get(name);
        if(attr != null) attr.setValue(value);
        else throwNoSuchAttributeException(name);
    }
    public Attribute getAttribute(String name){
        Attribute attr = attributes.get(name);
        if(attr != null) return attr;
        else throwNoSuchAttributeException(name);
        return null;
    }

    public String toIndentString(String indent){
        StringBuffer buffer = new StringBuffer();
        buffer.append(indent + "Class " + type.getName() + " " + name);
        if(type.parent != null) buffer.append(" extends " + type.parent.getName());
        buffer.append("{\n");
        for(Attribute each : attributes.values()){
            if(each.getValue() instanceof Klass){
                Klass inner = (Klass)each.getValue();
                buffer.append(indent + "   " + each.getType().getTypeClassName() + " " + each.getType().getName() + " = " + inner.toIndentString(indent + "   ") + ";\n");
            }
            else{
                buffer.append(indent + "   " + each.getType().getTypeClassName() + " " + each.getType().getName() + " = " + each.getValue() + ";\n");
            }
        }
        buffer.append(indent + "}");
        return buffer.toString();
    }
    private void throwNoSuchAttributeException(String attributeName){
        try {
            throw new NoSuchAttributeException();
        } catch (NoSuchAttributeException e) {

            System.out.println("Class \"" + name + "\" has no such attribute : \"" + attributeName + "\n");
            e.printStackTrace();
        }
    }
}
