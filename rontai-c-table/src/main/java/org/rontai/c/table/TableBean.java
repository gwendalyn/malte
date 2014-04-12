package org.rontai.c.table;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.rontai.s.base.SpringContext;


@ManagedBean
@SessionScoped
public class TableBean {
	
	private List<Car> carsSmall;
	
	public TableBean(){
		HelloWorld hw = (HelloWorld)SpringContext.getApplicationContext().getBean("helloWorld");
		hw.shout();
	}
	
	
	public List<Car> getCarsSmall() {
		
		Car c1 = new Car("model1", 1881, "manu1", "yellow");
		Car c2 = new Car("model2", 1892, "manu2", "red");
		carsSmall = new ArrayList<Car>();
		carsSmall.add(c1);
		carsSmall.add(c2);
		return carsSmall;
	}

	public void setCarsSmall(List<Car> carsSmall) {
		this.carsSmall = carsSmall;
	}
	
	

}
