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
public class Capoli_vaadinApplication extends Application{

@Override
public void init() {
	final Window mainWindow = new Window("Capoli_vaadin Application");
	Label label = new Label("Capoli_vaadin Application");
	
	
	
	
	
	
	VerticalLayout vlayout = new VerticalLayout();

    // Create a container for such beans
    final BeanItemContainer<MemberDetailForm> beans =getBeanContainer();

    // A layout for the table and form
    HorizontalLayout layout = new HorizontalLayout();

    // Bind a table to it
    final Table table = new Table("Member Detail", beans);
    table.setVisibleColumns(new Object[]{"age","email","gender","member_id","mobile","name","profession","qualification"});
    
    
    
    table.setPageLength(7);
    table.setWriteThrough(true);
    layout.addComponent(table);
    
    // Create a form for editing a selected or new item.
    // It is invisible until actually used.
    final Form form = new Form();
    form.setCaption("Edit Member Data");
    form.setVisible(false);
    form.setWriteThrough(false); // Enable buffering
    layout.addComponent(form);
    
    // When the user selects an item, show it in the form
    table.addListener(new Property.ValueChangeListener() {
        public void valueChange(ValueChangeEvent event) {
            // Close the form if the item is deselected
            if (event.getProperty().getValue() == null) {
                form.setVisible(false);
                return;
            }

            // Bind the form to the selected item
            form.setItemDataSource(table.getItem(table.getValue()));
            form.setVisible(true);

            // The form was opened for editing an existing item
            table.setData(null);
        }
    });
    table.setSelectable(true);
    table.setImmediate(true);

    // Creates a new bean for editing in the form before adding
    // it to the table. Adding is handled after committing
    // the form.
    final Button newBean = new Button("New Bean");
    newBean.addListener(new Button.ClickListener() {
        public void buttonClick(ClickEvent event) {
            // Create a new item; this will create a new bean
        	
        	 MemberDetailForm bean = new MemberDetailForm();
			 bean.setAge(String.valueOf(20));
			 bean.setEmail("test@gmail.com");
			 bean.setGender("M");
			 bean.setMember_id(String.valueOf(20));
			 bean.setMobile(String.valueOf(123456));
			 bean.setName("ghanshyam"+11);
			 bean.setProfession("test");
			 bean.setQualification("test");
			 
			 
            Object itemId = beans.addItem(bean);
            form.setItemDataSource(table.getItem(itemId));

            // Make the form a bit nicer
            form.setVisibleItemProperties(
                    new Object[]{"age","email","gender","member_id","mobile","name","profession","qualification"});
            //((TextField)form.getField("name"))
            //        .setNullRepresentation("");
            
            // The form was opened for editing a new item
            table.setData(itemId);
            
            table.select(itemId);
            table.setEnabled(false);
            newBean.setEnabled(false);
            form.setVisible(true);
        }
    });

    // When OK button is clicked, commit the form to the bean
    final Button submit = new Button("Save");
    submit.addListener(new Button.ClickListener() {
        public void buttonClick(ClickEvent event) {
            form.commit();
            form.setVisible(false); // and close it
            
            // New items have to be added to the container
            if (table.getValue() == null) {
                // Commit the addition
                table.commit();
                
                table.setEnabled(true);
                newBean.setEnabled(true);
            }
        }
    });
    form.getFooter().addComponent(submit);
    
    // Make modification to enable/disable the Save button
    form.setFormFieldFactory(new DefaultFieldFactory() {
        @Override
        public Field createField(Item item, Object propertyId, Component uiContext) {
            final AbstractField field = (AbstractField)
                    super.createField(item, propertyId, uiContext);
            field.addListener(new ValueChangeListener() {
                public void valueChange(ValueChangeEvent event) {
                    submit.setEnabled(form.isModified());
                }
            });
            if (field instanceof TextField) {
                final TextField tf = (TextField) field;
                tf.addListener(new TextChangeListener() {
                    public void textChange(TextChangeEvent event) {
                        if (form.isModified() ||
                            !event.getText().equals(tf.getValue())) {
                            submit.setEnabled(true);
                            
                            // Not needed after first event unless
                            // want to detect also changes back to
                            // unmodified value.
                            tf.removeListener(this);
                            
                            // Has to be reset because the
                            // removeListener() setting causes
                            // updating the field value from the
                            // server-side.
                            tf.setValue(event.getText());
                        }
                    }
                });
            }
            field.setImmediate(true);
            
            return field;
        }
    });

    Button cancel = new Button("Cancel");
    cancel.addListener(new Button.ClickListener() {
        public void buttonClick(ClickEvent event) {
            form.discard();  // Not really necessary
            form.setVisible(false); // and close it
            table.discard(); // Discards possible addItem()
            table.setEnabled(true);
            if (table.getData() != null)
                beans.removeItem(table.getData());
            newBean.setEnabled(true);
        }
    });
    form.getFooter().addComponent(cancel);
	
	
	
	mainWindow.addComponent(label);
	mainWindow.addComponent(layout);
	mainWindow.addComponent(getAddressPanel());
	
	setMainWindow(mainWindow);
	
	
	
	
	
	
}


public BeanItemContainer getBeanContainer(){
	
	
	 BeanItemContainer<MemberDetailForm> beans =
		        new BeanItemContainer<MemberDetailForm>(MemberDetailForm.class);
		    
		    // Add some beans to it
	 for (int i=0;i<7;i++){
		
		 MemberDetailForm bean = new MemberDetailForm();
		 bean.setAge(String.valueOf(i));
		 bean.setEmail("test@gmail.com");
		 bean.setGender("M");
		 bean.setMember_id(String.valueOf(i));
		 bean.setMobile(String.valueOf(123456));
		 bean.setName("ghanshyam"+i);
		 bean.setProfession("test");
		 bean.setQualification("test");
		 
		 beans.addBean(bean);
		 
	 }
		   
	
	return beans;
}


public BeanItemContainer getaddressContainer(){
	
	
	 BeanItemContainer<Address> beans =
		        new BeanItemContainer<Address>(Address.class);
		    
		    // Add some beans to it
	 for (int i=0;i<7;i++){
		
		 Address bean = new Address();
		 
		 bean.setAddressid(String.valueOf(i));
		 bean.setLocation("location"+i);
		 bean.setCity("city"+i);
		 bean.setPincode("pincode"+i);
		 bean.setCountry("country"+i);
		 bean.setState("state"+i);
		 
		 
		 beans.addBean(bean);
		 
	 }
		   
	
	return beans;
}



public HorizontalLayout getAddressPanel()
{
	
	  // Create a container for such beans
    final BeanItemContainer<Bean> beans =getaddressContainer();

    // A layout for the table and form
    HorizontalLayout layout = new HorizontalLayout();

    // Bind a table to it
    final Table table = new Table("Address Detail", beans);
    table.setVisibleColumns(new Object[]{"addressid","location","city","pincode","country","state"});
    
    
    
    table.setPageLength(7);
    table.setWriteThrough(true);
    layout.addComponent(table);
    
    // Create a form for editing a selected or new item.
    // It is invisible until actually used.
    final Form form = new Form();
    form.setCaption("Edit Member Data");
    form.setVisible(false);
    form.setWriteThrough(false); // Enable buffering
    layout.addComponent(form);
    
    // When the user selects an item, show it in the form
    table.addListener(new Property.ValueChangeListener() {
        public void valueChange(ValueChangeEvent event) {
            // Close the form if the item is deselected
            if (event.getProperty().getValue() == null) {
                form.setVisible(false);
                return;
            }

            // Bind the form to the selected item
            form.setItemDataSource(table.getItem(table.getValue()));
            form.setVisible(true);

            // The form was opened for editing an existing item
            table.setData(null);
        }
    });
    table.setSelectable(true);
    table.setImmediate(true);

    // Creates a new bean for editing in the form before adding
    // it to the table. Adding is handled after committing
    // the form.
    final Button newBean = new Button("New Bean");
    newBean.addListener(new Button.ClickListener() {
        public void buttonClick(ClickEvent event) {
            // Create a new item; this will create a new bean
        	
        	 Address bean = new Address();
			 bean.setAddressid("");
			 bean.setCity("");
			 bean.setCountry("");
			 bean.setLocation("");
			 bean.setPincode("");
			 bean.setState("");
			 
            Object itemId = beans.addItem(bean);
            form.setItemDataSource(table.getItem(itemId));

            // Make the form a bit nicer
            form.setVisibleItemProperties(
                    new Object[]{"addressid","location","city","pincode","country","state"});
            //((TextField)form.getField("name"))
            //        .setNullRepresentation("");
            
            // The form was opened for editing a new item
            table.setData(itemId);
            
            table.select(itemId);
            table.setEnabled(false);
            newBean.setEnabled(false);
            form.setVisible(true);
        }
    });

    // When OK button is clicked, commit the form to the bean
    final Button submit = new Button("Save");
    submit.addListener(new Button.ClickListener() {
        public void buttonClick(ClickEvent event) {
            form.commit();
            form.setVisible(false); // and close it
            
            // New items have to be added to the container
            if (table.getValue() == null) {
                // Commit the addition
                table.commit();
                
                table.setEnabled(true);
                newBean.setEnabled(true);
            }
        }
    });
    form.getFooter().addComponent(submit);
    
    // Make modification to enable/disable the Save button
    form.setFormFieldFactory(new DefaultFieldFactory() {
        @Override
        public Field createField(Item item, Object propertyId, Component uiContext) {
            final AbstractField field = (AbstractField)
                    super.createField(item, propertyId, uiContext);
            field.addListener(new ValueChangeListener() {
                public void valueChange(ValueChangeEvent event) {
                    submit.setEnabled(form.isModified());
                }
            });
            if (field instanceof TextField) {
                final TextField tf = (TextField) field;
                tf.addListener(new TextChangeListener() {
                    public void textChange(TextChangeEvent event) {
                        if (form.isModified() ||
                            !event.getText().equals(tf.getValue())) {
                            submit.setEnabled(true);
                            
                            // Not needed after first event unless
                            // want to detect also changes back to
                            // unmodified value.
                            tf.removeListener(this);
                            
                            // Has to be reset because the
                            // removeListener() setting causes
                            // updating the field value from the
                            // server-side.
                            tf.setValue(event.getText());
                        }
                    }
                });
            }
            field.setImmediate(true);
            
            return field;
        }
    });

    Button cancel = new Button("Cancel");
    cancel.addListener(new Button.ClickListener() {
        public void buttonClick(ClickEvent event) {
            form.discard();  // Not really necessary
            form.setVisible(false); // and close it
            table.discard(); // Discards possible addItem()
            table.setEnabled(true);
            if (table.getData() != null)
                beans.removeItem(table.getData());
            newBean.setEnabled(true);
        }
    });
    form.getFooter().addComponent(cancel);
	
	return layout;
}


}