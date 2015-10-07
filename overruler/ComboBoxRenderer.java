/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package overruler;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author kvmoffae
 */
class ComboBoxRenderer extends JLabel
                           implements ListCellRenderer {
        private Font uhOhFont;
        ImageIcon[] images;
        String[] users;
 
        public ComboBoxRenderer(String[] users, ImageIcon[] images) {
            setOpaque(true);
            
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
            this.images = images;
            this.users=users;
          
        }
 
        /*
         * This method finds the image and text corresponding
         * to the selected value and returns the label, set up
         * to display the text and image.
         */
        public Component getListCellRendererComponent(
                                           JList list,
                                           Object value,
                                           int index,
                                           boolean isSelected,
                                           boolean cellHasFocus) {
            //Get the selected index. (The index param isn't
            //always valid, so just use the value.)
            int selectedIndex = ((Integer)value).intValue();
 
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
 
            //Set the icon and text.  If icon was null, say so.
            ImageIcon icon = images[selectedIndex];
            String pet = users[selectedIndex];
            setIcon(icon);
            if (icon != null) {
                setText(pet);
                setFont(list.getFont());
            } else {
                setUhOhText(pet + " (no image available)",
                            list.getFont());
            }
 
            return this;
        }
 
        //Set the font and text when no image was found.
        protected void setUhOhText(String uhOhText, Font normalFont) {
            if (uhOhFont == null) { //lazily create this font
                uhOhFont = normalFont.deriveFont(Font.ITALIC);
            }
            setFont(uhOhFont);
            setText(uhOhText);
        }
    }