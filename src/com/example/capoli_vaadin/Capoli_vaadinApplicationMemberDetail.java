package com.example.capoli_vaadin;

import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.LoginForm.LoginListener;

/**
 * Main application class.
 */
public class Capoli_vaadinApplicationMemberDetail extends Application {

	@Override
	public void init() {
		final Window mainWindow = new Window("Capoli_vaadin Application");
		Label label = new Label("Capoli_vaadin Application");
		
		
		
		
		
		VerticalLayout vlayout = new VerticalLayout();		
		mainWindow.addComponent(label);
		mainWindow.addComponent(vlayout);
		
		setMainWindow(mainWindow);
		
		
		
		
		
		
	}
}

