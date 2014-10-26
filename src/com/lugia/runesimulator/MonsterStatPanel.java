package com.lugia.runesimulator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MonsterStatPanel extends JPanel implements FocusListener
{
    private JLabel mLblBaseHeader;
    private JLabel mLblRune1Header;
    private JLabel mLblRune2Header;
    private JLabel mLblDiffHeader;

    private JLabel mLblHp;
    private JLabel mLblAttack;
    private JLabel mLblDefense;
    private JLabel mLblSpeed;
    private JLabel mLblCriticalRate;
    private JLabel mLblCriticalDamage;
    private JLabel mLblResistance;
    private JLabel mLblAccuracy;

    private JLabel mLblHpRune1;
    private JLabel mLblAttackRune1;
    private JLabel mLblDefenseRune1;
    private JLabel mLblSpeedRune1;
    private JLabel mLblCriticalRateRune1;
    private JLabel mLblCriticalDamageRune1;
    private JLabel mLblResistanceRune1;
    private JLabel mLblAccuracyRune1;

    private JLabel mLblHpRune2;
    private JLabel mLblAttackRune2;
    private JLabel mLblDefenseRune2;
    private JLabel mLblSpeedRune2;
    private JLabel mLblCriticalRateRune2;
    private JLabel mLblCriticalDamageRune2;
    private JLabel mLblResistanceRune2;
    private JLabel mLblAccuracyRune2;

    private JLabel mLblHpDiff;
    private JLabel mLblAttackDiff;
    private JLabel mLblDefenseDiff;
    private JLabel mLblSpeedDiff;
    private JLabel mLblCriticalRateDiff;
    private JLabel mLblCriticalDamageDiff;
    private JLabel mLblResistanceDiff;
    private JLabel mLblAccuracyDiff;

    private JTextField mTxtHp;
    private JTextField mTxtAttack;
    private JTextField mTxtDefense;
    private JTextField mTxtSpeed;
    private JTextField mTxtCriticalRate;
    private JTextField mTxtCriticalDamage;
    private JTextField mTxtResistance;
    private JTextField mTxtAccuracy;

    // callback listener
    private OnMonsterStatChangeListener mListener;

    public MonsterStatPanel()
    {
        initializeComponent();
    }

    private void initializeComponent()
    {
        mLblBaseHeader = new JLabel();
        mLblRune1Header = new JLabel();
        mLblRune2Header = new JLabel();
        mLblDiffHeader = new JLabel();

        mLblHp = new JLabel();
        mLblAttack = new JLabel();
        mLblDefense = new JLabel();
        mLblSpeed = new JLabel();
        mLblCriticalRate = new JLabel();
        mLblCriticalDamage = new JLabel();
        mLblResistance = new JLabel();
        mLblAccuracy = new JLabel();

        mTxtHp = new JTextField();
        mTxtAttack = new JTextField();
        mTxtDefense = new JTextField();
        mTxtSpeed = new JTextField();
        mTxtCriticalRate = new JTextField();
        mTxtCriticalDamage = new JTextField();
        mTxtResistance = new JTextField();
        mTxtAccuracy = new JTextField();

        mLblHpRune1 = new JLabel();
        mLblAttackRune1 = new JLabel();
        mLblDefenseRune1 = new JLabel();
        mLblSpeedRune1 = new JLabel();
        mLblCriticalRateRune1 = new JLabel();
        mLblCriticalDamageRune1 = new JLabel();
        mLblResistanceRune1 = new JLabel();
        mLblAccuracyRune1 = new JLabel();

        mLblHpRune2 = new JLabel();
        mLblAttackRune2 = new JLabel();
        mLblDefenseRune2 = new JLabel();
        mLblSpeedRune2 = new JLabel();
        mLblCriticalRateRune2 = new JLabel();
        mLblCriticalDamageRune2 = new JLabel();
        mLblResistanceRune2 = new JLabel();
        mLblAccuracyRune2 = new JLabel();

        mLblHpDiff = new JLabel();
        mLblAttackDiff = new JLabel();
        mLblDefenseDiff = new JLabel();
        mLblSpeedDiff = new JLabel();
        mLblCriticalRateDiff = new JLabel();
        mLblCriticalDamageDiff = new JLabel();
        mLblResistanceDiff = new JLabel();
        mLblAccuracyDiff = new JLabel();

        GridBagLayout monsterPanelLayout = new GridBagLayout();

        GridBagConstraints constrain = new GridBagConstraints();



        constrain.weightx = 1;

        constrain.fill = GridBagConstraints.HORIZONTAL;

        // ====================
        // Header
        // ====================

        // insets constraints for header
        constrain.insets.top = 0;
        constrain.insets.left = 4;
        constrain.insets.bottom = 8;
        constrain.insets.right = 4;

        //
        // mLblBaseHeader
        //
        mLblBaseHeader.setText("Base Stat");
        mLblBaseHeader.setHorizontalAlignment(SwingConstants.CENTER);
        constrain.gridx = 1;
        constrain.gridy = 0;
        monsterPanelLayout.setConstraints(mLblBaseHeader, constrain);
        //
        // mLblRune1Header
        //
        mLblRune1Header.setText("Rune Set 1");
        mLblRune1Header.setHorizontalAlignment(SwingConstants.CENTER);
        constrain.gridx = 2;
        constrain.gridy = 0;
        monsterPanelLayout.setConstraints(mLblRune1Header, constrain);
        //
        // mLblRune2Header
        //
        mLblRune2Header.setText("Rune Set 2");
        mLblRune2Header.setHorizontalAlignment(SwingConstants.CENTER);
        constrain.gridx = 3;
        constrain.gridy = 0;
        monsterPanelLayout.setConstraints(mLblRune2Header, constrain);
        //
        // mLblDiffHeader
        //
        mLblDiffHeader.setText("Difference");
        mLblDiffHeader.setHorizontalAlignment(SwingConstants.CENTER);
        constrain.gridx = 4;
        constrain.gridy = 0;
        monsterPanelLayout.setConstraints(mLblDiffHeader, constrain);

        // ====================
        //  Content
        // ====================

        // insets constrain for the rest
        constrain.insets.top = 2;
        constrain.insets.left = 4;
        constrain.insets.bottom = 2;
        constrain.insets.right = 4;

        // ====================
        // Label
        // ====================

        //
        // mLblHp
        //
        mLblHp.setText("HP");
        constrain.gridx = 0;
        constrain.gridy = 1;
        monsterPanelLayout.setConstraints(mLblHp, constrain);
        //
        // mLblAttack
        //
        mLblAttack.setText("ATK");
        constrain.gridx = 0;
        constrain.gridy = 2;
        monsterPanelLayout.setConstraints(mLblAttack, constrain);
        //
        // mLblDefense
        //
        mLblDefense.setText("DEF");
        constrain.gridx = 0;
        constrain.gridy = 3;
        monsterPanelLayout.setConstraints(mLblDefense, constrain);
        //
        // mLblSpeed
        //
        mLblSpeed.setText("SPD");
        constrain.gridx = 0;
        constrain.gridy = 4;
        monsterPanelLayout.setConstraints(mLblSpeed, constrain);
        //
        // mLblCriticalRate
        //
        mLblCriticalRate.setText("CRI Rate");
        constrain.gridx = 0;
        constrain.gridy = 5;
        monsterPanelLayout.setConstraints(mLblCriticalRate, constrain);
        //
        // mLblCriticalDamage
        //
        mLblCriticalDamage.setText("CRI Dmg");
        constrain.gridx = 0;
        constrain.gridy = 6;
        monsterPanelLayout.setConstraints(mLblCriticalDamage, constrain);
        //
        // mLblResistance
        //
        mLblResistance.setText("Resistance");
        constrain.gridx = 0;
        constrain.gridy = 7;
        monsterPanelLayout.setConstraints(mLblResistance, constrain);
        //
        // mLblAccuracy
        //
        mLblAccuracy.setText("Accuracy");
        constrain.gridx = 0;
        constrain.gridy = 8;
        monsterPanelLayout.setConstraints(mLblAccuracy, constrain);

        // ====================
        // User Input
        // ====================

        //
        // mTxtHp
        //
        mTxtHp.setHorizontalAlignment(JTextField.RIGHT);
        mTxtHp.setMargin(new Insets(1, 4, 1, 4));
        mTxtHp.addFocusListener(MonsterStatPanel.this);
        constrain.gridx = 1;
        constrain.gridy = 1;
        monsterPanelLayout.setConstraints(mTxtHp, constrain);
        //
        // mTxtAttack
        //
        mTxtAttack.setHorizontalAlignment(JTextField.RIGHT);
        mTxtAttack.setMargin(new Insets(1, 4, 1, 4));
        mTxtAttack.addFocusListener(MonsterStatPanel.this);
        constrain.gridx = 1;
        constrain.gridy = 2;
        monsterPanelLayout.setConstraints(mTxtAttack, constrain);
        //
        // mTxtDefense
        //
        mTxtDefense.setHorizontalAlignment(JTextField.RIGHT);
        mTxtDefense.setMargin(new Insets(1, 4, 1, 4));
        mTxtDefense.addFocusListener(MonsterStatPanel.this);
        constrain.gridx = 1;
        constrain.gridy = 3;
        monsterPanelLayout.setConstraints(mTxtDefense, constrain);
        //
        // mTxtSpeed
        //
        mTxtSpeed.setHorizontalAlignment(JTextField.RIGHT);
        mTxtSpeed.setMargin(new Insets(1, 4, 1, 4));
        mTxtSpeed.addFocusListener(MonsterStatPanel.this);
        constrain.gridx = 1;
        constrain.gridy = 4;
        monsterPanelLayout.setConstraints(mTxtSpeed, constrain);
        //
        // mTxtCriticalRate
        //
        mTxtCriticalRate.setHorizontalAlignment(JTextField.RIGHT);
        mTxtCriticalRate.setMargin(new Insets(1, 4, 1, 4));
        mTxtCriticalRate.addFocusListener(MonsterStatPanel.this);
        constrain.gridx = 1;
        constrain.gridy = 5;
        monsterPanelLayout.setConstraints(mTxtCriticalRate, constrain);
        //
        // mTxtCriticalDamage
        //
        mTxtCriticalDamage.setHorizontalAlignment(JTextField.RIGHT);
        mTxtCriticalDamage.setMargin(new Insets(1, 4, 1, 4));
        mTxtCriticalDamage.addFocusListener(MonsterStatPanel.this);
        constrain.gridx = 1;
        constrain.gridy = 6;
        monsterPanelLayout.setConstraints(mTxtCriticalDamage, constrain);
        //
        // mTxtResistance
        //
        mTxtResistance.setHorizontalAlignment(JTextField.RIGHT);
        mTxtResistance.setMargin(new Insets(1, 4, 1, 4));
        mTxtResistance.addFocusListener(MonsterStatPanel.this);
        constrain.gridx = 1;
        constrain.gridy = 7;
        monsterPanelLayout.setConstraints(mTxtResistance, constrain);
        //
        // mTxtAccuracy
        //
        mTxtAccuracy.setHorizontalAlignment(JTextField.RIGHT);
        mTxtAccuracy.setMargin(new Insets(1, 4, 1, 4));
        mTxtAccuracy.addFocusListener(MonsterStatPanel.this);
        constrain.gridx = 1;
        constrain.gridy = 8;
        monsterPanelLayout.setConstraints(mTxtAccuracy, constrain);

        // ====================
        // Rune 1
        // ====================

        //
        // mLblHpRune1
        //
        mLblHpRune1.setText("0");
        mLblHpRune1.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 2;
        constrain.gridy = 1;
        monsterPanelLayout.setConstraints(mLblHpRune1, constrain);
        //
        // mLblAttackRune1
        //
        mLblAttackRune1.setText("0");
        mLblAttackRune1.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 2;
        constrain.gridy = 2;
        monsterPanelLayout.setConstraints(mLblAttackRune1, constrain);
        //
        // mLblDefenseRune1
        //
        mLblDefenseRune1.setText("0");
        mLblDefenseRune1.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 2;
        constrain.gridy = 3;
        monsterPanelLayout.setConstraints(mLblDefenseRune1, constrain);
        //
        // mLblSpeedRune1
        //
        mLblSpeedRune1.setText("0");
        mLblSpeedRune1.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 2;
        constrain.gridy = 4;
        monsterPanelLayout.setConstraints(mLblSpeedRune1, constrain);
        //
        // mLblCriticalRateRune1
        //
        mLblCriticalRateRune1.setText("0");
        mLblCriticalRateRune1.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 2;
        constrain.gridy = 5;
        monsterPanelLayout.setConstraints(mLblCriticalRateRune1, constrain);
        //
        // mLblCriticalDamageRune1
        //
        mLblCriticalDamageRune1.setText("0");
        mLblCriticalDamageRune1.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 2;
        constrain.gridy = 6;
        monsterPanelLayout.setConstraints(mLblCriticalDamageRune1, constrain);
        //
        // mLblResistanceRune1
        //
        mLblResistanceRune1.setText("0");
        mLblResistanceRune1.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 2;
        constrain.gridy = 7;
        monsterPanelLayout.setConstraints(mLblResistanceRune1, constrain);
        //
        // mLblAccuracyRune1
        //
        mLblAccuracyRune1.setText("0");
        mLblAccuracyRune1.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 2;
        constrain.gridy = 8;
        monsterPanelLayout.setConstraints(mLblAccuracyRune1, constrain);

        // ====================
        // Rune 2
        // ====================

        //
        // mLblHpRune2
        //
        mLblHpRune2.setText("0");
        mLblHpRune2.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 3;
        constrain.gridy = 1;
        monsterPanelLayout.setConstraints(mLblHpRune2, constrain);
        //
        // mLblAttackRune2
        //
        mLblAttackRune2.setText("0");
        mLblAttackRune2.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 3;
        constrain.gridy = 2;
        monsterPanelLayout.setConstraints(mLblAttackRune2, constrain);
        //
        // mLblDefenseRune2
        //
        mLblDefenseRune2.setText("0");
        mLblDefenseRune2.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 3;
        constrain.gridy = 3;
        monsterPanelLayout.setConstraints(mLblDefenseRune2, constrain);
        //
        // mLblSpeedRune2
        //
        mLblSpeedRune2.setText("0");
        mLblSpeedRune2.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 3;
        constrain.gridy = 4;
        monsterPanelLayout.setConstraints(mLblSpeedRune2, constrain);
        //
        // mLblCriticalRateRune2
        //
        mLblCriticalRateRune2.setText("0");
        mLblCriticalRateRune2.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 3;
        constrain.gridy = 5;
        monsterPanelLayout.setConstraints(mLblCriticalRateRune2, constrain);
        //
        // mLblCriticalDamageRune2
        //
        mLblCriticalDamageRune2.setText("0");
        mLblCriticalDamageRune2.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 3;
        constrain.gridy = 6;
        monsterPanelLayout.setConstraints(mLblCriticalDamageRune2, constrain);
        //
        // mLblResistanceRune2
        //
        mLblResistanceRune2.setText("0");
        mLblResistanceRune2.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 3;
        constrain.gridy = 7;
        monsterPanelLayout.setConstraints(mLblResistanceRune2, constrain);
        //
        // mLblAccuracyRune2
        //
        mLblAccuracyRune2.setText("0");
        mLblAccuracyRune2.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 3;
        constrain.gridy = 8;
        monsterPanelLayout.setConstraints(mLblAccuracyRune2, constrain);

        // ====================
        // Difference
        // ====================

        //
        // mLblHpDiff
        //
        mLblHpDiff.setText("0");
        mLblHpDiff.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 4;
        constrain.gridy = 1;
        monsterPanelLayout.setConstraints(mLblHpDiff, constrain);
        //
        // mLblAttackDiff
        //
        mLblAttackDiff.setText("0");
        mLblAttackDiff.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 4;
        constrain.gridy = 2;
        monsterPanelLayout.setConstraints(mLblAttackDiff, constrain);
        //
        // mLblDefenseDiff
        //
        mLblDefenseDiff.setText("0");
        mLblDefenseDiff.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 4;
        constrain.gridy = 3;
        monsterPanelLayout.setConstraints(mLblDefenseDiff, constrain);
        //
        // mLblSpeedDiff
        //
        mLblSpeedDiff.setText("0");
        mLblSpeedDiff.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 4;
        constrain.gridy = 4;
        monsterPanelLayout.setConstraints(mLblSpeedDiff, constrain);
        //
        // mLblCriticalRateDiff
        //
        mLblCriticalRateDiff.setText("0");
        mLblCriticalRateDiff.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 4;
        constrain.gridy = 5;
        monsterPanelLayout.setConstraints(mLblCriticalRateDiff, constrain);
        //
        // mLblCriticalDamageDiff
        //
        mLblCriticalDamageDiff.setText("0");
        mLblCriticalDamageDiff.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 4;
        constrain.gridy = 6;
        monsterPanelLayout.setConstraints(mLblCriticalDamageDiff, constrain);
        //
        // mLblResistanceDiff
        //
        mLblResistanceDiff.setText("0");
        mLblResistanceDiff.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 4;
        constrain.gridy = 7;
        monsterPanelLayout.setConstraints(mLblResistanceDiff, constrain);
        //
        // mLblAccuracyDiff
        //
        mLblAccuracyDiff.setText("0");
        mLblAccuracyDiff.setHorizontalAlignment(JTextField.RIGHT);
        constrain.gridx = 4;
        constrain.gridy = 8;
        monsterPanelLayout.setConstraints(mLblAccuracyDiff, constrain);
        
        //
        // MonsterStatPanel
        //
        setLayout(monsterPanelLayout);
        setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 1), "Monster Stat"));

        add(mLblBaseHeader);
        add(mLblRune1Header);
        add(mLblRune2Header);
        add(mLblDiffHeader);

        add(mLblHp);
        add(mLblAttack);
        add(mLblDefense);
        add(mLblSpeed);
        add(mLblCriticalRate);
        add(mLblCriticalDamage);
        add(mLblResistance);
        add(mLblAccuracy);

        add(mTxtHp);
        add(mTxtAttack);
        add(mTxtDefense);
        add(mTxtSpeed);
        add(mTxtCriticalRate);
        add(mTxtCriticalDamage);
        add(mTxtResistance);
        add(mTxtAccuracy);

        add(mLblHpRune1);
        add(mLblAttackRune1);
        add(mLblDefenseRune1);
        add(mLblSpeedRune1);
        add(mLblCriticalRateRune1);
        add(mLblCriticalDamageRune1);
        add(mLblResistanceRune1);
        add(mLblAccuracyRune1);

        add(mLblHpRune2);
        add(mLblAttackRune2);
        add(mLblDefenseRune2);
        add(mLblSpeedRune2);
        add(mLblCriticalRateRune2);
        add(mLblCriticalDamageRune2);
        add(mLblResistanceRune2);
        add(mLblAccuracyRune2);

        add(mLblHpDiff);
        add(mLblAttackDiff);
        add(mLblDefenseDiff);
        add(mLblSpeedDiff);
        add(mLblCriticalRateDiff);
        add(mLblCriticalDamageDiff);
        add(mLblResistanceDiff);
        add(mLblAccuracyDiff);
    }

    public void updateData(MonsterStat monsterStat, RuneSet runeSet1, RuneSet runeSet2)
    {
        MonsterStat monsterStat1 = monsterStat.applyRune(runeSet1);
        MonsterStat monsterStat2 = monsterStat.applyRune(runeSet2);

        Util.setTextFieldText(mTxtHp,             monsterStat.getStat(MonsterStat.Stat.HP));
        Util.setTextFieldText(mTxtAttack,         monsterStat.getStat(MonsterStat.Stat.ATK));
        Util.setTextFieldText(mTxtDefense,        monsterStat.getStat(MonsterStat.Stat.DEF));
        Util.setTextFieldText(mTxtSpeed,          monsterStat.getStat(MonsterStat.Stat.SPD));
        Util.setTextFieldText(mTxtCriticalRate,   monsterStat.getStat(MonsterStat.Stat.CRIT_RATE));
        Util.setTextFieldText(mTxtCriticalDamage, monsterStat.getStat(MonsterStat.Stat.CRIT_DMG));
        Util.setTextFieldText(mTxtResistance,     monsterStat.getStat(MonsterStat.Stat.RESISTANCE));
        Util.setTextFieldText(mTxtAccuracy,       monsterStat.getStat(MonsterStat.Stat.ACCURACY));

        Util.setLabelText(mLblHpRune1,             monsterStat1.getStat(MonsterStat.Stat.HP));
        Util.setLabelText(mLblAttackRune1,         monsterStat1.getStat(MonsterStat.Stat.ATK));
        Util.setLabelText(mLblDefenseRune1,        monsterStat1.getStat(MonsterStat.Stat.DEF));
        Util.setLabelText(mLblSpeedRune1,          monsterStat1.getStat(MonsterStat.Stat.SPD));
        Util.setLabelText(mLblCriticalRateRune1,   monsterStat1.getStat(MonsterStat.Stat.CRIT_RATE));
        Util.setLabelText(mLblCriticalDamageRune1, monsterStat1.getStat(MonsterStat.Stat.CRIT_DMG));
        Util.setLabelText(mLblResistanceRune1,     monsterStat1.getStat(MonsterStat.Stat.RESISTANCE));
        Util.setLabelText(mLblAccuracyRune1,       monsterStat1.getStat(MonsterStat.Stat.ACCURACY));

        Util.setLabelText(mLblHpRune2,             monsterStat2.getStat(MonsterStat.Stat.HP));
        Util.setLabelText(mLblAttackRune2,         monsterStat2.getStat(MonsterStat.Stat.ATK));
        Util.setLabelText(mLblDefenseRune2,        monsterStat2.getStat(MonsterStat.Stat.DEF));
        Util.setLabelText(mLblSpeedRune2,          monsterStat2.getStat(MonsterStat.Stat.SPD));
        Util.setLabelText(mLblCriticalRateRune2,   monsterStat2.getStat(MonsterStat.Stat.CRIT_RATE));
        Util.setLabelText(mLblCriticalDamageRune2, monsterStat2.getStat(MonsterStat.Stat.CRIT_DMG));
        Util.setLabelText(mLblResistanceRune2,     monsterStat2.getStat(MonsterStat.Stat.RESISTANCE));
        Util.setLabelText(mLblAccuracyRune2,       monsterStat2.getStat(MonsterStat.Stat.ACCURACY));

        Util.setLabelTextSigned(mLblHpDiff, monsterStat2.getStat(MonsterStat.Stat.HP) - monsterStat1.getStat(MonsterStat.Stat.HP));
        Util.setLabelTextSigned(mLblAttackDiff, monsterStat2.getStat(MonsterStat.Stat.ATK) - monsterStat1.getStat(MonsterStat.Stat.ATK));
        Util.setLabelTextSigned(mLblDefenseDiff, monsterStat2.getStat(MonsterStat.Stat.DEF) - monsterStat1.getStat(MonsterStat.Stat.DEF));
        Util.setLabelTextSigned(mLblSpeedDiff, monsterStat2.getStat(MonsterStat.Stat.SPD) - monsterStat1.getStat(MonsterStat.Stat.SPD));
        Util.setLabelTextSigned(mLblCriticalRateDiff, monsterStat2.getStat(MonsterStat.Stat.CRIT_RATE) - monsterStat1.getStat(MonsterStat.Stat.CRIT_RATE));
        Util.setLabelTextSigned(mLblCriticalDamageDiff, monsterStat2.getStat(MonsterStat.Stat.CRIT_DMG) - monsterStat1.getStat(MonsterStat.Stat.CRIT_DMG));
        Util.setLabelTextSigned(mLblResistanceDiff, monsterStat2.getStat(MonsterStat.Stat.RESISTANCE) - monsterStat1.getStat(MonsterStat.Stat.RESISTANCE));
        Util.setLabelTextSigned(mLblAccuracyDiff, monsterStat2.getStat(MonsterStat.Stat.ACCURACY) - monsterStat1.getStat(MonsterStat.Stat.ACCURACY));
    }

    public void setOnMonsterStatChangeListener(OnMonsterStatChangeListener listener)
    {
        mListener = listener;
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        ((JTextField)e.getSource()).selectAll();
    }

    @Override
    public void focusLost(FocusEvent e)
    {
        if (mListener == null)
            return;

        MonsterStat monsterStat = new MonsterStat();

        monsterStat.setStat(MonsterStat.Stat.HP,         Util.getIntegerValue(mTxtHp));
        monsterStat.setStat(MonsterStat.Stat.ATK,        Util.getIntegerValue(mTxtAttack));
        monsterStat.setStat(MonsterStat.Stat.DEF,        Util.getIntegerValue(mTxtDefense));
        monsterStat.setStat(MonsterStat.Stat.SPD,        Util.getIntegerValue(mTxtSpeed));
        monsterStat.setStat(MonsterStat.Stat.CRIT_RATE,  Util.getIntegerValue(mTxtCriticalRate));
        monsterStat.setStat(MonsterStat.Stat.CRIT_DMG,   Util.getIntegerValue(mTxtCriticalDamage));
        monsterStat.setStat(MonsterStat.Stat.RESISTANCE, Util.getIntegerValue(mTxtResistance));
        monsterStat.setStat(MonsterStat.Stat.ACCURACY,   Util.getIntegerValue(mTxtAccuracy));

        mListener.onMonsterStatChange(monsterStat);
    }

    public interface OnMonsterStatChangeListener
    {
        public void onMonsterStatChange(MonsterStat monsterStat);
    }
}
