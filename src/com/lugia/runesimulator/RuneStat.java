package com.lugia.runesimulator;

public class RuneStat
{
    public enum Stat
    {
        NONE,
        HP,
        HP_PERCENT,
        ATK,
        ATK_PERCENT,
        DEF,
        DEF_PERCENT,
        SPD,
        CRIT_RATE,
        CRIT_DMG,
        RESISTANCE,
        ACCURACY,
    }

    private int mHp;
    private int mHpPercent;
    private int mAttack;
    private int mAttackPercent;
    private int mDefense;
    private int mDefensePercent;
    private int mSpeed;
    private int mCriticalRate;
    private int mCriticalDamage;
    private int mResistance;
    private int mAccuracy;

    public RuneStat()
    {
        clear();
    }

    public void setStat(Stat stat, int value)
    {
        if (value < 0)
            throw new IllegalArgumentException("Rune stat value must be greater or equal to 0!");

        switch (stat)
        {
            case HP:          mHp = value;             break;
            case HP_PERCENT:  mHpPercent = value;      break;
            case ATK:         mAttack = value;         break;
            case ATK_PERCENT: mAttackPercent = value;  break;
            case DEF:         mDefense = value;        break;
            case DEF_PERCENT: mDefensePercent = value; break;
            case SPD:         mSpeed = value;          break;
            case CRIT_RATE:   mCriticalRate = value;   break;
            case CRIT_DMG:    mCriticalDamage = value; break;
            case RESISTANCE:  mResistance = value;     break;
            case ACCURACY:    mAccuracy = value;       break;

            default: throw new IllegalArgumentException("Unknown Stat: " + stat);
        }
    }

    public int getStat(Stat stat)
    {
        switch (stat)
        {
            case HP:          return mHp;
            case HP_PERCENT:  return mHpPercent;
            case ATK:         return mAttack;
            case ATK_PERCENT: return mAttackPercent;
            case DEF:         return mDefense;
            case DEF_PERCENT: return mDefensePercent;
            case SPD:         return mSpeed;
            case CRIT_RATE:   return mCriticalRate;
            case CRIT_DMG:    return mCriticalDamage;
            case RESISTANCE:  return mResistance;
            case ACCURACY:    return mAccuracy;

            default: throw new IllegalArgumentException("Unknown Stat: " + stat);
        }
    }

    public RuneStat add(RuneStat stat)
    {
        mHp             += stat.mHp;
        mHpPercent      += stat.mHpPercent;
        mAttack         += stat.mAttack;
        mAttackPercent  += stat.mAttackPercent;
        mDefense        += stat.mDefense;
        mDefensePercent += stat.mDefensePercent;
        mSpeed          += stat.mSpeed;
        mCriticalRate   += stat.mCriticalRate;
        mCriticalDamage += stat.mCriticalDamage;
        mResistance     += stat.mResistance;
        mAccuracy       += stat.mAccuracy;

        return this;
    }

    public void clear()
    {
        mHp             = 0;
        mHpPercent      = 0;
        mAttack         = 0;
        mAttackPercent  = 0;
        mDefense        = 0;
        mDefensePercent = 0;
        mSpeed          = 0;
        mCriticalRate   = 0;
        mCriticalDamage = 0;
        mResistance     = 0;
        mAccuracy       = 0;
    }

    @Override
    public String toString()
    {
        String str = "Rune Stat\n";

        str += "HP:       " + mHp             + "\n";
        str += "HP%:      " + mHpPercent      + "\n";
        str += "ATK:      " + mAttack         + "\n";
        str += "ATK%:     " + mAttackPercent  + "\n";
        str += "DEF:      " + mDefense        + "\n";
        str += "DEF%:     " + mDefensePercent + "\n";
        str += "SPD:      " + mSpeed          + "\n";
        str += "CRI RATE: " + mCriticalRate   + "\n";
        str += "CRI DMG:  " + mCriticalDamage + "\n";
        str += "RES:      " + mResistance     + "\n";
        str += "ACC:      " + mAccuracy       + "\n";

        return str;
    }
}
