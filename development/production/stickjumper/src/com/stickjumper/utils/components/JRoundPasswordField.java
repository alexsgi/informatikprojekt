package com.stickjumper.utils.components;

import com.stickjumper.utils.Settings;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class JRoundPasswordField extends JPasswordField {

    private Shape shape;

    public JRoundPasswordField() {
        super();
        setOpaque(false);
        setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        setHorizontalAlignment(SwingConstants.LEFT);
        setEchoChar('*');
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS, Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(((LineBorder) getBorder()).getLineColor());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS, Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS);
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS, Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS);
        }
        return shape.contains(x, y);
    }
}
