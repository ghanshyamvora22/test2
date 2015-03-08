package com.example.capoli_vaadin;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;


public class MyDialog extends Window implements Button.ClickListener{
 
    private final Button saveButton = new Button("save");
    private final Button cancelButton = new Button("cancel");
    MyBean myBean = new MyBean();

    Form form = new Form();
    
    private void initialise()
   {
        BeanItem<MyBean> item = new BeanItem<MyBean>(myBean);
       // Form.setWriteThrough(false);
       form.setInvalidCommitted(false);

        //form.setFormFieldFactory(new MyBeanFormFieldFactory());
        form.setImmediate(true);

        form.setItemDataSource(item);

        // Add form to layout
        addComponent(form);

        // The cancel / apply buttons
        HorizontalLayout buttons = new HorizontalLayout();

        form.getLayout().addComponent(buttons);

        buttons.addComponent(saveButton);
        buttons.addComponent(cancelButton);

        saveButton.addListener(this);
        cancelButton.addListener(this);
    }

    public void buttonClick(ClickEvent event) {
        if (event.getSource() == saveButton) {
            try {
                form.commit();

                try
                {
                
                	
                	System.out.println(myBean.getName());
                   System.out.println(myBean.getPassword());
                   
                   // parentWindow.removeWindow(this);
                }
                catch (Exception e)    {
                    //LOGGER.error(e.getLocalizedMessage(), e);
                    //parentWindow.removeWindow(this);
                }
            }
            catch (Exception e)    {
                // This is a validation error so ignore...
            }
        }
        else    {
           // LOGGER.debug("Cancel " + getCaption());
            //parentWindow.removeWindow(this);
        }
    }
}
