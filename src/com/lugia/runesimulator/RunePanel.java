package com.lugia.runesimulator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunePanel extends JPanel implements ActionListener
{
    private JButton mBtnRune1;
    private JButton mBtnRune2;
    private JButton mBtnRune3;
    private JButton mBtnRune4;
    private JButton mBtnRune5;
    private JButton mBtnRune6;

    private JLabel mLblSetBonus;

    private OnRuneClickListener mListener = null;

    private static final String ENERGY_SET_TEXT = "Energy<br />HP +15%";
    private static final String FATAL_SET_TEXT = "Fatal<br />ATK +30%";

    public RunePanel()
    {
        initializeComponent();
    }

    private void initializeComponent()
    {
        mBtnRune1 = new JButton();
        mBtnRune2 = new JButton();
        mBtnRune3 = new JButton();
        mBtnRune4 = new JButton();
        mBtnRune5 = new JButton();
        mBtnRune6 = new JButton();

        mLblSetBonus = new JLabel();

        GridBagLayout mainPanelLayout = new GridBagLayout();
        GridBagLayout runePanelLayout = new GridBagLayout();

        GridBagConstraints constrain = new GridBagConstraints();

        JPanel leftPanel = new JPanel();

        //
        // mBtnRune1
        //
        mBtnRune1.setText("1");
        mBtnRune1.setPreferredSize(new Dimension(42, 42));
        mBtnRune1.addActionListener(RunePanel.this);
        constrain.gridx = 1;
        constrain.gridy = 0;
        constrain.insets.top = 2;
        constrain.insets.left = 4;
        constrain.insets.bottom = 2;
        constrain.insets.right = 4;
        runePanelLayout.setConstraints(mBtnRune1, constrain);
        //
        // mBtnRune2
        //
        mBtnRune2.setText("2");
        mBtnRune2.setPreferredSize(new Dimension(42, 42));
        mBtnRune2.addActionListener(RunePanel.this);
        constrain.gridx = 2;
        constrain.gridy = 1;
        constrain.insets.top = -12;
        constrain.insets.left = 4;
        constrain.insets.bottom = 2;
        constrain.insets.right = 4;
        runePanelLayout.setConstraints(mBtnRune2, constrain);
        //
        // mBtnRune3
        //
        mBtnRune3.setText("3");
        mBtnRune3.setPreferredSize(new Dimension(42, 42));
        mBtnRune3.addActionListener(RunePanel.this);
        constrain.gridx = 2;
        constrain.gridy = 2;
        constrain.insets.top = 2;
        constrain.insets.left = 4;
        constrain.insets.bottom = 2;
        constrain.insets.right = 4;
        runePanelLayout.setConstraints(mBtnRune3, constrain);
        //
        // mBtnRune4
        //
        mBtnRune4.setText("4");
        mBtnRune4.setPreferredSize(new Dimension(42, 42));
        mBtnRune4.addActionListener(RunePanel.this);
        constrain.gridx = 1;
        constrain.gridy = 3;
        constrain.insets.top = -12;
        constrain.insets.left = 4;
        constrain.insets.bottom = 2;
        constrain.insets.right = 4;
        runePanelLayout.setConstraints(mBtnRune4, constrain);
        //
        // mBtnRune5
        //
        mBtnRune5.setText("5");
        mBtnRune5.setPreferredSize(new Dimension(42, 42));
        mBtnRune5.addActionListener(RunePanel.this);
        constrain.gridx = 0;
        constrain.gridy = 2;
        constrain.insets.top = 2;
        constrain.insets.left = 4;
        constrain.insets.bottom = 2;
        constrain.insets.right = 4;
        runePanelLayout.setConstraints(mBtnRune5, constrain);
        //
        // mBtnRune6
        //
        mBtnRune6.setText("6");
        mBtnRune6.setPreferredSize(new Dimension(42, 42));
        mBtnRune6.addActionListener(RunePanel.this);
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.insets.top = -12;
        constrain.insets.left = 4;
        constrain.insets.bottom = 2;
        constrain.insets.right = 4;
        runePanelLayout.setConstraints(mBtnRune6, constrain);

        //
        // leftPanel
        //
        leftPanel.setLayout(runePanelLayout);

        leftPanel.add(mBtnRune1);
        leftPanel.add(mBtnRune2);
        leftPanel.add(mBtnRune3);
        leftPanel.add(mBtnRune4);
        leftPanel.add(mBtnRune5);
        leftPanel.add(mBtnRune6);

        //
        // mLblSetBonus
        //
        mLblSetBonus.setText("No Set Effect");
        mLblSetBonus.setHorizontalAlignment(SwingConstants.CENTER);
        mLblSetBonus.setVerticalAlignment(SwingConstants.CENTER);
        mLblSetBonus.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 1), "Set Effect"));

        //
        // RunePanel
        //
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 1), "Rune Set"));

        add(leftPanel, BorderLayout.WEST);
        add(mLblSetBonus, BorderLayout.CENTER);
    }

    public void setTitle(String title)
    {
        setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 1), title));
    }

    public void setOnRuneClickListener(OnRuneClickListener listener)
    {
        mListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (mListener == null)
            return;

        int slot = Integer.parseInt(e.getActionCommand());

        mListener.onRuneClick(RunePanel.this, slot);
    }

    public interface OnRuneClickListener
    {
        public void onRuneClick(Object sender, int slot);
    }
}
