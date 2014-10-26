package com.lugia.runesimulator;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class MainUI extends JFrame implements RunePanel.OnRuneClickListener, MonsterStatPanel.OnMonsterStatChangeListener
{
    private MonsterStatPanel mMonsterStatPanel;

    private RunePanel mRunePanel1,
                      mRunePanel2;

    // TODO: Move to Main.java
    private RuneSet mRuneSet1,
                    mRuneSet2;

    private MonsterStat mMonsterStat;

    public MainUI()
    {
        super("Rune Stat Simulator");

        initializeComponent();

        mRuneSet1 = new RuneSet();
        mRuneSet2 = new RuneSet();

        mMonsterStat = new MonsterStat();
        mMonsterStat.setStat(MonsterStat.Stat.HP, 6660);
        mMonsterStat.setStat(MonsterStat.Stat.ATK, 400);
        mMonsterStat.setStat(MonsterStat.Stat.DEF, 350);
        mMonsterStat.setStat(MonsterStat.Stat.SPD, 99);
        mMonsterStat.setStat(MonsterStat.Stat.CRIT_RATE, 15);
        mMonsterStat.setStat(MonsterStat.Stat.CRIT_DMG, 50);
        mMonsterStat.setStat(MonsterStat.Stat.RESISTANCE, 15);
        mMonsterStat.setStat(MonsterStat.Stat.ACCURACY, 0);

        mMonsterStatPanel.updateData(mMonsterStat, mRuneSet1, mRuneSet2);
    }

    private void initializeComponent()
    {
        mMonsterStatPanel = new MonsterStatPanel();

        mRunePanel1 = new RunePanel();
        mRunePanel2 = new RunePanel();

        GridBagLayout mainPanelLayout = new GridBagLayout();

        GridBagConstraints constrain = new GridBagConstraints();

        constrain.weightx = 1;

        constrain.fill = GridBagConstraints.HORIZONTAL;

        //
        // mMonsterStatPanel
        //
        mMonsterStatPanel.setOnMonsterStatChangeListener(MainUI.this);
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.gridwidth = 2;
        constrain.insets.top = 0;
        constrain.insets.left = 8;
        constrain.insets.bottom = 3;
        constrain.insets.right = 8;

        mainPanelLayout.setConstraints(mMonsterStatPanel, constrain);

        //
        // mRunePanel1
        //
        mRunePanel1.setTitle("Rune Set 1");
        mRunePanel1.setOnRuneClickListener(MainUI.this);
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.gridwidth = 1;
        constrain.insets.top = 3;
        constrain.insets.left = 8;
        constrain.insets.bottom = 0;
        constrain.insets.right = 3;
        mainPanelLayout.setConstraints(mRunePanel1, constrain);
        //
        // mRunePanel2
        //
        mRunePanel2.setTitle("Rune Set 2");
        mRunePanel2.setOnRuneClickListener(MainUI.this);
        constrain.gridx = 1;
        constrain.gridy = 1;
        constrain.gridwidth = 1;
        constrain.insets.top = 3;
        constrain.insets.left = 3;
        constrain.insets.bottom = 0;
        constrain.insets.right = 8;
        mainPanelLayout.setConstraints(mRunePanel2, constrain);

        //
        // MainUI
        //
        setLayout(mainPanelLayout);
        setSize(612, 484);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        add(mMonsterStatPanel);
        add(mRunePanel1);
        add(mRunePanel2);
    }

    @Override
    public void onMonsterStatChange(MonsterStat monsterStat)
    {
        mMonsterStat = monsterStat;

        mMonsterStatPanel.updateData(mMonsterStat, mRuneSet1, mRuneSet2);
    }

    @Override
    public void onRuneClick(Object sender, int slot)
    {
        Rune rune = null;
        RuneSet runeSet = null;

        if (sender == mRunePanel1)
            runeSet = mRuneSet1;
        else if (sender == mRunePanel2)
            runeSet = mRuneSet2;

        switch (slot)
        {
            case 1: rune = runeSet.getRune(1); break;
            case 2: rune = runeSet.getRune(2); break;
            case 3: rune = runeSet.getRune(3); break;
            case 4: rune = runeSet.getRune(4); break;
            case 5: rune = runeSet.getRune(5); break;
            case 6: rune = runeSet.getRune(6); break;
        }

        // Modal dialog, blocking statement
        RuneDialog dialog = new RuneDialog(MainUI.this, rune, slot);

        mMonsterStatPanel.updateData(mMonsterStat, mRuneSet1, mRuneSet2);
    }
}
