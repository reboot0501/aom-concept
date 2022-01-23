package com.example.aomconcept;

import com.example.aomconcept.domain.AttributeType;
import com.example.aomconcept.domain.Klass;
import com.example.aomconcept.domain.KlassType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class AomConceptApplication {

	public static void main(String[] args) {

//		SpringApplication.run(AomConceptApplication.class, args);
		KlassType site = new KlassType("Site", null);

		site.addAttributeType(new AttributeType(String.class, "position", "위치"));


		KlassType house = new KlassType("House", site);

		house.addAttributeType(new AttributeType(String.class, "owner", "소유주"));

		house.addAttributeType(new AttributeType(Integer.class, "area", "면적"));

		house.addAttributeType(new AttributeType(Klass.class, "car", "차량"));


		Klass myHouse = new Klass(house, "우리집", UUID.randomUUID().toString());

		myHouse.set("position", "사당동");

		myHouse.set("owner", "홍길동");

		myHouse.set("area", "30평");


		KlassType car = new KlassType("Car", null);

		car.addAttributeType(new AttributeType(String.class, "model", "모델"));

		car.addAttributeType(new AttributeType(Integer.class, "hp", "마력"));

		car.addAttributeType(new AttributeType(String.class, "type", "종류"));


		Klass myCar = new Klass(car, "내차", UUID.randomUUID().toString());

		myCar.set("model", "아우디");

		myCar.set("hp", "500마력");

		myCar.set("type", "세단");


		myHouse.set("car", myCar);


		System.out.println(myHouse.toIndentString(""));

	}

}
