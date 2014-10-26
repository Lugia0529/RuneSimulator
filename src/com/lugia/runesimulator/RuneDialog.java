package com.lugia.runesimulator;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RuneDialog extends JDialog implements ActionListener
{
    private JPanel mPnlContent;
    private JPanel mPnlTop;
    private JPanel mPnlMid;
    private JPanel mPnlBottom;

    private JLabel mLblType;
    private JLabel mLblPrimaryStat;
    private JLabel mLblStar;
    private JLabel mLblPowerUp;
    private JLabel mLblHp;
    private JLabel mLblHpPercent;
    private JLabel mLblAttack;
    private JLabel mLblAttackPercent;
    private JLabel mLblDefense;
    private JLabel mLblDefensePercent;
    private JLabel mLblSpeed;
    private JLabel mLblCriticalRate;
    private JLabel mLblCriticalDamage;
    private JLabel mLblResistance;
    private JLabel mLblAccuracy;

    private JTextField mTxtHp;
    private JTextField mTxtHpPercent;
    private JTextField mTxtAttack;
    private JTextField mTxtAttackPercent;
    private JTextField mTxtDefense;
    private JTextField mTxtDefensePercent;
    private JTextField mTxtSpeed;
    private JTextField mTxtCriticalRate;
    private JTextField mTxtCriticalDamage;
    private JTextField mTxtResistance;
    private JTextField mTxtAccuracy;

    private JComboBox<Rune.RuneType> mCbType;
    private JComboBox<RuneStat.Stat> mCbPrimaryStat;
    private JComboBox<String> mCbStar;
    private JComboBox<String> mCbPowerUp;

    private JButton mBtnOk;
    private JButton mBtnCancel;

    private GridBagLayout mTopPanelLayout;
    private GridBagLayout mMidPanelLayout;

    private FlowLayout mBottomPanelLayout;

    private GridBagConstraints mTopPanelConstrain;
    private GridBagConstraints mMidPanelConstrain;

    private Rune mRune;

    private static final Rune.RuneType[] RUNE_TYPE = new Rune.RuneType[]
    {
        Rune.RuneType.NONE,
        Rune.RuneType.ENERGY,
        Rune.RuneType.FATAL,
        Rune.RuneType.BLADE,
        Rune.RuneType.RAGE,
        Rune.RuneType.SWIFT,
        Rune.RuneType.FOCUS,
        Rune.RuneType.GUARD,
        Rune.RuneType.ENDURE,
        Rune.RuneType.VIOLENT,
        Rune.RuneType.DESPAIR,
        Rune.RuneType.VAMPIRE
    };

    private static final RuneStat.Stat[] PRIMARY_STAT = new RuneStat.Stat[]
    {
        RuneStat.Stat.HP,
        RuneStat.Stat.HP_PERCENT,
        RuneStat.Stat.ATK,
        RuneStat.Stat.ATK_PERCENT,
        RuneStat.Stat.DEF,
        RuneStat.Stat.DEF_PERCENT,
        RuneStat.Stat.SPD,
        RuneStat.Stat.CRIT_RATE,
        RuneStat.Stat.CRIT_DMG,
        RuneStat.Stat.RESISTANCE,
        RuneStat.Stat.ACCURACY,
    };

    private static final String[] STAR = new String[]
    {
        "★",
        "★★",
        "★★★",
        "★★★★",
        "★★★★★",
        "★★★★★★"
    };

    private static final String[] POWER_UP = new String[]
    {
        "+0",
        "+1",
        "+2",
        "+3",
        "+4",
        "+5",
        "+6",
        "+7",
        "+8",
        "+9",
        "+10",
        "+11",
        "+12",
        "+13",
        "+14",
        "+15",
    };

    public RuneDialog(JFrame owner, Rune rune, int slot)
    {
        super(owner, "Rune Stat", true);

        initializeComponent();

        mRune = rune;

        mCbType.setSelectedItem(rune.getRuneType());
        mCbPrimaryStat.setSelectedItem(rune.getPrimaryStat());
        mCbStar.setSelectedIndex(rune.getStar() - 1);
        mCbPowerUp.setSelectedIndex(rune.getPowerUp());

        Util.setTextFieldText(mTxtHp,             rune.getRuneStat(RuneStat.Stat.HP));
        Util.setTextFieldText(mTxtHpPercent,      rune.getRuneStat(RuneStat.Stat.HP_PERCENT));
        Util.setTextFieldText(mTxtAttack,         rune.getRuneStat(RuneStat.Stat.ATK));
        Util.setTextFieldText(mTxtAttackPercent,  rune.getRuneStat(RuneStat.Stat.ATK_PERCENT));
        Util.setTextFieldText(mTxtDefense,        rune.getRuneStat(RuneStat.Stat.DEF));
        Util.setTextFieldText(mTxtDefensePercent, rune.getRuneStat(RuneStat.Stat.DEF_PERCENT));
        Util.setTextFieldText(mTxtSpeed,          rune.getRuneStat(RuneStat.Stat.SPD));
        Util.setTextFieldText(mTxtCriticalRate,   rune.getRuneStat(RuneStat.Stat.CRIT_RATE));
        Util.setTextFieldText(mTxtCriticalDamage, rune.getRuneStat(RuneStat.Stat.CRIT_DMG));
        Util.setTextFieldText(mTxtResistance,     rune.getRuneStat(RuneStat.Stat.RESISTANCE));
        Util.setTextFieldText(mTxtAccuracy,       rune.getRuneStat(RuneStat.Stat.ACCURACY));

        setVisible(true);
    }

    private void initializeComponent()
    {
        mPnlContent = new JPanel();
        mPnlTop = new JPanel();
        mPnlMid = new JPanel();
        mPnlBottom = new JPanel();

        mLblType = new JLabel();
        mLblPrimaryStat = new JLabel();
        mLblStar = new JLabel();
        mLblPowerUp = new JLabel();
        mLblHp = new JLabel();
        mLblHpPercent = new JLabel();
        mLblAttack = new JLabel();
        mLblAttackPercent = new JLabel();
        mLblDefense = new JLabel();
        mLblDefensePercent = new JLabel();
        mLblSpeed = new JLabel();
        mLblCriticalRate = new JLabel();
        mLblCriticalDamage = new JLabel();
        mLblResistance = new JLabel();
        mLblAccuracy = new JLabel();

        mCbType = new JComboBox<Rune.RuneType>();
        mCbPrimaryStat = new JComboBox<RuneStat.Stat>();
        mCbStar = new JComboBox<String>();
        mCbPowerUp = new JComboBox<String>();

        mTxtHp = new JTextField();
        mTxtHpPercent = new JTextField();
        mTxtAttack = new JTextField();
        mTxtAttackPercent = new JTextField();
        mTxtDefense = new JTextField();
        mTxtDefensePercent = new JTextField();
        mTxtSpeed = new JTextField();
        mTxtCriticalRate = new JTextField();
        mTxtCriticalDamage = new JTextField();
        mTxtResistance = new JTextField();
        mTxtAccuracy = new JTextField();

        mBtnOk = new JButton();
        mBtnCancel = new JButton();

        mTopPanelLayout = new GridBagLayout();
        mMidPanelLayout = new GridBagLayout();

        mBottomPanelLayout = new FlowLayout(FlowLayout.CENTER);

        mTopPanelConstrain = new GridBagConstraints();
        mMidPanelConstrain = new GridBagConstraints();

        //
        // mTopPanelConstrain
        //
        mTopPanelConstrain.insets.top = 2;
        mTopPanelConstrain.insets.left = 4;
        mTopPanelConstrain.insets.bottom = 2;
        mTopPanelConstrain.insets.right = 4;

        //
        // mMidPanelConstrain
        //
        mMidPanelConstrain.insets.top = 2;
        mMidPanelConstrain.insets.left = 4;
        mMidPanelConstrain.insets.bottom = 2;
        mMidPanelConstrain.insets.right = 4;

        //
        // mLblType
        //
        mLblType.setText("Type");
        mTopPanelConstrain.gridx = 0;
        mTopPanelConstrain.gridy = 0;
        mTopPanelConstrain.weightx = 1;
        mTopPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mTopPanelLayout.setConstraints(mLblType, mTopPanelConstrain);
        //
        // mLblPrimaryStat
        //
        mLblPrimaryStat.setText("Primary Stat");
        mTopPanelConstrain.gridx = 2;
        mTopPanelConstrain.gridy = 0;
        mTopPanelConstrain.weightx = 1;
        mTopPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mTopPanelLayout.setConstraints(mLblPrimaryStat, mTopPanelConstrain);
        //
        // mLblStar
        //
        mLblStar.setText("Star");
        mTopPanelConstrain.gridx = 0;
        mTopPanelConstrain.gridy = 1;
        mTopPanelConstrain.weightx = 1;
        mTopPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mTopPanelLayout.setConstraints(mLblStar, mTopPanelConstrain);
        //
        // mLblPowerUp
        //
        mLblPowerUp.setText("Power Up");
        mTopPanelConstrain.gridx = 2;
        mTopPanelConstrain.gridy = 1;
        mTopPanelConstrain.weightx = 1;
        mTopPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mTopPanelLayout.setConstraints(mLblPowerUp, mTopPanelConstrain);

        //
        // mLblHp
        //
        mLblHp.setText("HP");
        mMidPanelConstrain.gridx = 0;
        mMidPanelConstrain.gridy = 0;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblHp, mMidPanelConstrain);
        //
        // mLblHpPercent
        //
        mLblHpPercent.setText("HP%");
        mMidPanelConstrain.gridx = 0;
        mMidPanelConstrain.gridy = 1;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblHpPercent, mMidPanelConstrain);
        //
        // mLblAttack
        //
        mLblAttack.setText("ATK");
        mMidPanelConstrain.gridx = 0;
        mMidPanelConstrain.gridy = 2;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblAttack, mMidPanelConstrain);
        //
        // mLblAttackPercent
        //
        mLblAttackPercent.setText("ATK%");
        mMidPanelConstrain.gridx = 0;
        mMidPanelConstrain.gridy = 3;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblAttackPercent, mMidPanelConstrain);
        //
        // mLblDefense
        //
        mLblDefense.setText("DEF");
        mMidPanelConstrain.gridx = 0;
        mMidPanelConstrain.gridy = 4;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblDefense, mMidPanelConstrain);
        //
        // mLblDefensePercent
        //
        mLblDefensePercent.setText("DEF%");
        mMidPanelConstrain.gridx = 0;
        mMidPanelConstrain.gridy = 5;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblDefensePercent, mMidPanelConstrain);
        //
        // mLblSpeed
        //
        mLblSpeed.setText("SPD");
        mMidPanelConstrain.gridx = 2;
        mMidPanelConstrain.gridy = 0;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblSpeed, mMidPanelConstrain);
        //
        // mLblCriticalRate
        //
        mLblCriticalRate.setText("CRI Rate");
        mMidPanelConstrain.gridx = 2;
        mMidPanelConstrain.gridy = 1;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblCriticalRate, mMidPanelConstrain);
        //
        // mLblCriticalDamage
        //
        mLblCriticalDamage.setText("CRI Dmg");
        mMidPanelConstrain.gridx = 2;
        mMidPanelConstrain.gridy = 2;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblCriticalDamage, mMidPanelConstrain);
        //
        // mLblResistance
        //
        mLblResistance.setText("Resistance");
        mMidPanelConstrain.gridx = 2;
        mMidPanelConstrain.gridy = 3;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblResistance, mMidPanelConstrain);
        //
        // mLblAccuracy
        //
        mLblAccuracy.setText("Accuracy");
        mMidPanelConstrain.gridx = 2;
        mMidPanelConstrain.gridy = 4;
        mMidPanelConstrain.weightx = 1;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mLblAccuracy, mMidPanelConstrain);
        
        //
        // mCbType
        //
        mCbType.setModel(new DefaultComboBoxModel<Rune.RuneType>(RUNE_TYPE));
        mTopPanelConstrain.gridx = 1;
        mTopPanelConstrain.gridy = 0;
        mTopPanelConstrain.weightx = 2;
        mTopPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mTopPanelLayout.setConstraints(mCbType, mTopPanelConstrain);
        //
        // mCbPrimaryStat
        //
        mCbPrimaryStat.setModel(new DefaultComboBoxModel<RuneStat.Stat>(PRIMARY_STAT));
        mTopPanelConstrain.gridx = 3;
        mTopPanelConstrain.gridy = 0;
        mTopPanelConstrain.weightx = 2;
        mTopPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mTopPanelLayout.setConstraints(mCbPrimaryStat, mTopPanelConstrain);
        //
        // mCbStar
        //
        mCbStar.setModel(new DefaultComboBoxModel<String>(STAR));
        mTopPanelConstrain.gridx = 1;
        mTopPanelConstrain.gridy = 1;
        mTopPanelConstrain.weightx = 2;
        mTopPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mTopPanelLayout.setConstraints(mCbStar, mTopPanelConstrain);
        //
        // mCbPowerUp
        //
        mCbPowerUp.setModel(new DefaultComboBoxModel<String>(POWER_UP));
        mTopPanelConstrain.gridx = 3;
        mTopPanelConstrain.gridy = 1;
        mTopPanelConstrain.weightx = 2;
        mTopPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mTopPanelLayout.setConstraints(mCbPowerUp, mTopPanelConstrain);

        //
        // mTxtHp
        //
        mTxtHp.setHorizontalAlignment(JTextField.RIGHT);
        mTxtHp.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 1;
        mMidPanelConstrain.gridy = 0;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtHp, mMidPanelConstrain);
        //
        // mTxtHpPercent
        //
        mTxtHpPercent.setHorizontalAlignment(JTextField.RIGHT);
        mTxtHpPercent.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 1;
        mMidPanelConstrain.gridy = 1;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtHpPercent, mMidPanelConstrain);
        //
        // mTxtAttack
        //
        mTxtAttack.setHorizontalAlignment(JTextField.RIGHT);
        mTxtAttack.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 1;
        mMidPanelConstrain.gridy = 2;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtAttack, mMidPanelConstrain);
        //
        // mTxtAttackPercent
        //
        mTxtAttackPercent.setHorizontalAlignment(JTextField.RIGHT);
        mTxtAttackPercent.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 1;
        mMidPanelConstrain.gridy = 3;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtAttackPercent, mMidPanelConstrain);
        //
        // mTxtDefense
        //
        mTxtDefense.setHorizontalAlignment(JTextField.RIGHT);
        mTxtDefense.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 1;
        mMidPanelConstrain.gridy = 4;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtDefense, mMidPanelConstrain);
        //
        // mTxtDefensePercent
        //
        mTxtDefensePercent.setHorizontalAlignment(JTextField.RIGHT);
        mTxtDefensePercent.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 1;
        mMidPanelConstrain.gridy = 5;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtDefensePercent, mMidPanelConstrain);
        //
        // mTxtSpeed
        //
        mTxtSpeed.setHorizontalAlignment(JTextField.RIGHT);
        mTxtSpeed.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 3;
        mMidPanelConstrain.gridy = 0;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtSpeed, mMidPanelConstrain);
        //
        // mTxtCriticalRate
        //
        mTxtCriticalRate.setHorizontalAlignment(JTextField.RIGHT);
        mTxtCriticalRate.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 3;
        mMidPanelConstrain.gridy = 1;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtCriticalRate, mMidPanelConstrain);
        //
        // mTxtCriticalDamage
        //
        mTxtCriticalDamage.setHorizontalAlignment(JTextField.RIGHT);
        mTxtCriticalDamage.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 3;
        mMidPanelConstrain.gridy = 2;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtCriticalDamage, mMidPanelConstrain);
        //
        // mTxtResistance
        //
        mTxtResistance.setHorizontalAlignment(JTextField.RIGHT);
        mTxtResistance.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 3;
        mMidPanelConstrain.gridy = 3;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtResistance, mMidPanelConstrain);
        //
        // mTxtAccuracy
        //
        mTxtAccuracy.setHorizontalAlignment(JTextField.RIGHT);
        mTxtAccuracy.setMargin(new Insets(1, 4, 1, 4));
        mMidPanelConstrain.gridx = 3;
        mMidPanelConstrain.gridy = 4;
        mMidPanelConstrain.weightx = 2;
        mMidPanelConstrain.fill = GridBagConstraints.HORIZONTAL;
        mMidPanelLayout.setConstraints(mTxtAccuracy, mMidPanelConstrain);

        //
        // mBtnOk
        //
        mBtnOk.setText("Ok");
        mBtnOk.setPreferredSize(new Dimension(80, 26));
        mBtnOk.addActionListener(RuneDialog.this);

        //
        // mBtnCancel
        //
        mBtnCancel.setText("Cancel");
        mBtnCancel.setPreferredSize(new Dimension(80, 26));
        mBtnCancel.addActionListener(RuneDialog.this);

        //
        // mPnlTop
        //
        mPnlTop.setLayout(mTopPanelLayout);

        mPnlTop.add(mLblType);
        mPnlTop.add(mLblPrimaryStat);
        mPnlTop.add(mLblStar);
        mPnlTop.add(mLblPowerUp);

        mPnlTop.add(mCbType);
        mPnlTop.add(mCbPrimaryStat);
        mPnlTop.add(mCbStar);
        mPnlTop.add(mCbPowerUp);

        //
        // mPnlMid
        //
        mPnlMid.setLayout(mMidPanelLayout);
        mPnlMid.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 1), "Bonus"));

        mPnlMid.add(mLblHp);
        mPnlMid.add(mLblHpPercent);
        mPnlMid.add(mLblAttack);
        mPnlMid.add(mLblAttackPercent);
        mPnlMid.add(mLblDefense);
        mPnlMid.add(mLblDefensePercent);
        mPnlMid.add(mLblSpeed);
        mPnlMid.add(mLblCriticalRate);
        mPnlMid.add(mLblCriticalDamage);
        mPnlMid.add(mLblResistance);
        mPnlMid.add(mLblAccuracy);

        mPnlMid.add(mTxtHp);
        mPnlMid.add(mTxtHpPercent);
        mPnlMid.add(mTxtAttack);
        mPnlMid.add(mTxtAttackPercent);
        mPnlMid.add(mTxtDefense);
        mPnlMid.add(mTxtDefensePercent);
        mPnlMid.add(mTxtSpeed);
        mPnlMid.add(mTxtCriticalRate);
        mPnlMid.add(mTxtCriticalDamage);
        mPnlMid.add(mTxtResistance);
        mPnlMid.add(mTxtAccuracy);

        //
        // mPnlBottom
        //
        mPnlBottom.setLayout(mBottomPanelLayout);
        mPnlBottom.setBorder(new EmptyBorder(6, 0, 0, 0));

        mPnlBottom.add(mBtnOk);
        mPnlBottom.add(mBtnCancel);

        //
        // mPnlContent
        //
        mPnlContent.setLayout(new BorderLayout(5, 5));
        mPnlContent.setBorder(new EmptyBorder(8, 8, 8, 8));

        mPnlContent.add(mPnlTop, BorderLayout.NORTH);
        mPnlContent.add(mPnlMid, BorderLayout.CENTER);
        mPnlContent.add(mPnlBottom, BorderLayout.SOUTH);

        //
        // RuneDialog
        //
        setContentPane(mPnlContent);
        setSize(368, 336);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == mBtnOk)
        {
            mRune.setRuneType((Rune.RuneType)mCbType.getSelectedItem());
            mRune.setPrimaryStat((RuneStat.Stat) mCbPrimaryStat.getSelectedItem());
            mRune.setStar(mCbStar.getSelectedIndex() + 1);
            mRune.setPowerUp(mCbPowerUp.getSelectedIndex());

            mRune.setRuneStat(RuneStat.Stat.HP,          Util.getIntegerValue(mTxtHp));
            mRune.setRuneStat(RuneStat.Stat.HP_PERCENT,  Util.getIntegerValue(mTxtHpPercent));
            mRune.setRuneStat(RuneStat.Stat.ATK,         Util.getIntegerValue(mTxtAttack));
            mRune.setRuneStat(RuneStat.Stat.ATK_PERCENT, Util.getIntegerValue(mTxtAttackPercent));
            mRune.setRuneStat(RuneStat.Stat.DEF,         Util.getIntegerValue(mTxtDefense));
            mRune.setRuneStat(RuneStat.Stat.DEF_PERCENT, Util.getIntegerValue(mTxtDefensePercent));
            mRune.setRuneStat(RuneStat.Stat.SPD,         Util.getIntegerValue(mTxtSpeed));
            mRune.setRuneStat(RuneStat.Stat.CRIT_RATE,   Util.getIntegerValue(mTxtCriticalRate));
            mRune.setRuneStat(RuneStat.Stat.CRIT_DMG,    Util.getIntegerValue(mTxtCriticalDamage));
            mRune.setRuneStat(RuneStat.Stat.RESISTANCE,  Util.getIntegerValue(mTxtResistance));
            mRune.setRuneStat(RuneStat.Stat.ACCURACY,    Util.getIntegerValue(mTxtAccuracy));

            dispose();

            return;
        }

        if (e.getSource() == mBtnCancel)
        {
            dispose();
        }
    }
}
