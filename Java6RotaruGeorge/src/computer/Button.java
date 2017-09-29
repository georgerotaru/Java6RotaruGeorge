/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;

/**
 *
 * @author George
 */
public class Button {
    
private String buttonValue;

public Button() {
    buttonValue = "";
}
    public void emptyButton() {
        buttonValue = "";
    }
    public String getButtonValue() {
        return(buttonValue);
    }
    
    public void setButtonValue(String pushButton) {
        buttonValue = pushButton;
    }
}