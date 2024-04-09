/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package gui_examples;

import java.beans.*;
import java.io.Serializable;
import javax.swing.*;               // добавлено вручную
import java.awt.*;                  // добавлено вручную
import java.awt.geom.Rectangle2D;   // добавлено вручную

/**
 *
 * @author a.yusupova
 */
public class JTitledPanel extends JPanel implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "title";
    
    private String title="Заголовок"; //добавлено вручную
    private Color titleColor = Color.red; // добавлено вручную
    
    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
    
    public JTitledPanel() {
        super();
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public JTitledPanel(LayoutManager layout, boolean isDoubleBuffered)
    {
        super(layout, isDoubleBuffered);
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public JTitledPanel(LayoutManager layout) {
        super(layout);
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public JTitledPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getTitle() {
        return title;
    }
    
    public Color getTitleColor() {
        return titleColor;
    }
    
    public void setTitle(String value) {
        String oldValue = title;
        title = value;
        propertySupport.firePropertyChange("title", oldValue, title);
        repaint(); //добавлено вручную
    }
    
    public void setTitleColor(Color value) {
        Color oldValue = titleColor;
        titleColor = value;
        propertySupport.firePropertyChange("titleColor", oldValue, title);
        repaint(); //добавлено вручную
    }
    
//    public String getSampleProperty() {
//        return sampleProperty;
//    }
//    
//    public void setSampleProperty(String value) {
//        String oldValue = sampleProperty;
//        sampleProperty = value;
//        propertySupport.firePropertyChange(title, oldValue, sampleProperty);
//    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if(propertySupport != null)
            propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener){
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public void paint(Graphics g){ // добавлен вручную
        super.paint(g);
        FontMetrics fontMetrics=g.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(title, g);
        g.setColor(titleColor);
        g.drawString(title,(int)Math.round((this.getWidth() -
        rect.getWidth())/2), 10);
    }
}
