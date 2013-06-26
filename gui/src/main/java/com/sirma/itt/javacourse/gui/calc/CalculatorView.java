package com.sirma.itt.javacourse.gui.calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.*;

/**
 * Calculator view. Creates GUI.
 *
 * @version 1.1 14 June 2013
 * @author Stella Djulgerova
 */
public class CalculatorView extends JFrame {
    
	private static final long serialVersionUID = -7911217837565168277L;

	// all gui components
    private JTextField txtDisplay = new JTextField();

    private JButton btnClear = new JButton("C");
    private JButton btnBackspace = new JButton("B");
    private JButton btnCalculate = new JButton("=");
    
    private JButton btnSeven = new JButton("7");
    private JButton btnEigth = new JButton("8");
    private JButton btnNine = new JButton("9");
    private JButton btnDivide = new JButton("/");
    
    private JButton btnFour = new JButton("4");
    private JButton btnFive = new JButton("5");
    private JButton btnSix = new JButton("6");
    private JButton btnMultiply = new JButton("*");
    
    private JButton btnOne = new JButton("1");
    private JButton btnTwo = new JButton("2");
    private JButton btnThree = new JButton("3");
    private JButton btnSubtract = new JButton("-");
    
    private JButton btnZero = new JButton("0");
    private JButton btnMinus = new JButton("-/+");
    private JButton btnPoint = new JButton(".");
    private JButton btnAdd = new JButton("+");

    /**
     * Constructor. Initialize all components and show it on screen.
     */
    public CalculatorView() {

    	txtDisplay.setText("0");
    	txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
    	txtDisplay.setBackground(new Color(255,255,255));
    	txtDisplay.setEditable(false);

    	// set components names
        btnClear.setName("C");
        btnBackspace.setName("Backspace");
        btnCalculate.setName("=");
        btnSeven.setName("7");
        btnEigth.setName("8");
        btnNine.setName("9");
        btnDivide.setName("/");
        btnFour.setName("4");
        btnFive.setName("5");
        btnSix.setName("6");
        btnMultiply.setName("*");
        btnOne.setName("1");
        btnTwo.setName("2");
        btnThree.setName("3");
        btnSubtract.setName("-");
        btnZero.setName("0");

        btnMinus.setName("-/+");
        btnPoint.setName(".");
        btnAdd.setName("+");
        
        JPanel pnlDisplay = new JPanel();
        pnlDisplay.setLayout(new GridLayout(1,2));
        pnlDisplay.add(txtDisplay);
        
        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridLayout(5,3,5,5));
        
        // add elements to panel
        pnlButtons.add(new JLabel(""));
        pnlButtons.add(btnClear);
        pnlButtons.add(btnBackspace);
        pnlButtons.add(btnCalculate);
        pnlButtons.add(btnSeven);
        pnlButtons.add(btnEigth);
        pnlButtons.add(btnNine);
        pnlButtons.add(btnDivide);
        pnlButtons.add(btnFour);
        pnlButtons.add(btnFive);
        pnlButtons.add(btnSix);
        pnlButtons.add(btnMultiply);
        pnlButtons.add(btnOne);
        pnlButtons.add(btnTwo);
        pnlButtons.add(btnThree);
        pnlButtons.add(btnSubtract);
        pnlButtons.add(btnZero);
        pnlButtons.add(btnMinus);
        pnlButtons.add(btnPoint);
        pnlButtons.add(btnAdd);
        
        Container pane = this.getContentPane();
        pane.add(pnlDisplay,  BorderLayout.NORTH);
        pane.add(pnlButtons, BorderLayout.SOUTH);

        this.setContentPane(pane);
        this.pack();
        this.setResizable(false);
        this.setLocation(500, 300);
        this.setSize(220,205);
        this.setTitle("Calculator");
        setVisible(true);
        
        // The window closing event should be in Controller ??
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Add mouse listener to all buttons.
     * @param listener - mouse listener
     */
    public void addCalculationListener(MouseListener listener) {
        btnClear.addMouseListener(listener);
        btnBackspace.addMouseListener(listener);
        btnCalculate.addMouseListener(listener);
        btnSeven.addMouseListener(listener);
        btnEigth.addMouseListener(listener);
        btnNine.addMouseListener(listener);
        btnDivide.addMouseListener(listener);
        btnFour.addMouseListener(listener);
        btnFive.addMouseListener(listener);
        btnSix.addMouseListener(listener);
        btnMultiply.addMouseListener(listener);
        btnOne.addMouseListener(listener);
        btnTwo.addMouseListener(listener);
        btnThree.addMouseListener(listener);
        btnSubtract.addMouseListener(listener);
        btnZero.addMouseListener(listener);
        btnMinus.addMouseListener(listener);
        btnPoint.addMouseListener(listener);
        btnAdd.addMouseListener(listener);
	}

    /**
     * Set result in display text field.
     * @return - display text field
     */
	public void display(String result) {
		txtDisplay.setText(result);
	}
}