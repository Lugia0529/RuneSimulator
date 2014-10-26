package com.lugia.runesimulator;

public class Rune
{
    public enum RuneType
    {
        NONE,
        ENERGY,
        FATAL,
        BLADE,
        RAGE,
        SWIFT,
        FOCUS,
        GUARD,
        ENDURE,
        VIOLENT,
        DESPAIR,
        VAMPIRE
    }

    private RuneType mRuneType;
    private RuneStat mRuneStat;

    private RuneStat.Stat mPrimaryStat;

    private int mStar;
    private int mPowerUp;

    public Rune()
    {
        clear();
    }

    public Rune(Rune rune)
    {
        // Deep Copy Constructor
        setRuneType(rune.getRuneType());
        setPrimaryStat(rune.getPrimaryStat());

        setStar(rune.getStar());
        setPowerUp(rune.getPowerUp());

        setRuneStat(rune.getRuneStat());
    }

    public void setRuneType(RuneType runeType)
    {
        mRuneType = runeType;
    }

    public void setPrimaryStat(RuneStat.Stat primaryStat)
    {
        mPrimaryStat = primaryStat;
    }

    public void setRuneStat(RuneStat runeStat)
    {
        // deep copy every stat
        setRuneStat(RuneStat.Stat.HP,          runeStat.getStat(RuneStat.Stat.HP));
        setRuneStat(RuneStat.Stat.HP_PERCENT,  runeStat.getStat(RuneStat.Stat.HP_PERCENT));
        setRuneStat(RuneStat.Stat.ATK,         runeStat.getStat(RuneStat.Stat.ATK));
        setRuneStat(RuneStat.Stat.ATK_PERCENT, runeStat.getStat(RuneStat.Stat.ATK_PERCENT));
        setRuneStat(RuneStat.Stat.DEF,         runeStat.getStat(RuneStat.Stat.DEF));
        setRuneStat(RuneStat.Stat.DEF_PERCENT, runeStat.getStat(RuneStat.Stat.DEF_PERCENT));
        setRuneStat(RuneStat.Stat.SPD,         runeStat.getStat(RuneStat.Stat.SPD));
        setRuneStat(RuneStat.Stat.CRIT_RATE,   runeStat.getStat(RuneStat.Stat.CRIT_RATE));
        setRuneStat(RuneStat.Stat.CRIT_DMG,    runeStat.getStat(RuneStat.Stat.CRIT_DMG));
        setRuneStat(RuneStat.Stat.RESISTANCE,  runeStat.getStat(RuneStat.Stat.RESISTANCE));
        setRuneStat(RuneStat.Stat.ACCURACY,    runeStat.getStat(RuneStat.Stat.ACCURACY));
    }

    public void setRuneStat(RuneStat.Stat stat, int value)
    {
        mRuneStat.setStat(stat, value);
    }

    public void setStar(int star)
    {
        if (star < 1 || star > 6)
            throw new IllegalArgumentException("Star must between 1 to 6");

        mStar = star;
    }

    public void setPowerUp(int powerUp)
    {
        if (powerUp < 0 || powerUp > 15)
            throw new IllegalArgumentException("Power Up must between 1 to 15");

        mPowerUp = powerUp;
    }

    public RuneType getRuneType()
    {
        return mRuneType;
    }

    public RuneStat.Stat getPrimaryStat()
    {
        return mPrimaryStat;
    }

    public RuneStat getRuneStat()
    {
        return mRuneStat;
    }

    public int getRuneStat(RuneStat.Stat stat)
    {
        return mRuneStat.getStat(stat);
    }

    public int getStar()
    {
        return mStar;
    }

    public int getPowerUp()
    {
        return mPowerUp;
    }

    public void clear()
    {
        mRuneType = RuneType.NONE;
        mPrimaryStat = RuneStat.Stat.NONE;

        mRuneStat = new RuneStat();

        mStar = 1;
        mPowerUp = 0;
    }

    @Override
    public String toString()
    {
        String str = "Rune\n";

        str += "Type:         " + mRuneType    + "\n";
        str += "Star:         " + mStar        + "\n";
        str += "Power Up:     " + mPowerUp     + "\n";
        str += "Primary Stat: " + mPrimaryStat + "\n";

        str += mRuneStat;

        return str;
    }
}
