package com.lugia.runesimulator;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Util
{
    public static int percentage(int value, int percent)
    {
        return (int)Math.ceil(value * (percent / 100f));
    }

    public static int getIntegerValue(JTextField textField)
    {
        try
        {
            return Integer.parseInt(textField.getText());
        }
        catch (NumberFormatException nfe)
        {
            return 0;
        }
    }

    public static void setTextFieldText(JTextField textField, int value)
    {
        textField.setText(String.valueOf(value));
    }

    public static void setLabelText(JLabel label, int value)
    {
        label.setText(String.valueOf(value));
    }

    public static void setLabelTextSigned(JLabel label, int value)
    {
        label.setText((value > 0 ? "+" : "") + String.valueOf(value));
    }
}
