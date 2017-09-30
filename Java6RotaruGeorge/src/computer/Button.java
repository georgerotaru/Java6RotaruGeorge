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
    
private static String buttonValue;
private static String totalValue;

public Button() {
    totalValue = "";
}
    public void emptyButton() {
        buttonValue = "";
        totalValue = "";
    }
    public String getButtonValue() {
        return(buttonValue);
    }
    
    public void setButtonValue(String pushButton) {
        buttonValue = pushButton;
    }
    
    public static String getValue() {
        totalValue += buttonValue;
        return(totalValue);
    }
}