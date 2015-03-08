package com.example.capoli_vaadin;

import com.vaadin.Application;

public class customWindow extends Application {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		 MyDialog m= new MyDialog();
		 setMainWindow(m);
	}
}