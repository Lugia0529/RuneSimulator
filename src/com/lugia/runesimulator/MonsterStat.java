package com.lugia.runesimulator;

public class MonsterStat
{
    public enum Stat
    {
        HP,
        ATK,
        DEF,
        SPD,
        CRIT_RATE,
        CRIT_DMG,
        RESISTANCE,
        ACCURACY
    }

    private int mHp;
    private int mAttack;
    private int mDefense;
    private int mSpeed;
    private int mCriticalRate;
    private int mCriticalDamage;
    private int mResistance;
    private int mAccuracy;

    public MonsterStat()
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
            case ATK:         mAttack = value;         break;
            case DEF:         mDefense = value;        break;
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
            case ATK:         return mAttack;
            case DEF:         return mDefense;
            case SPD:         return mSpeed;
            case CRIT_RATE:   return mCriticalRate;
            case CRIT_DMG:    return mCriticalDamage;
            case RESISTANCE:  return mResistance;
            case ACCURACY:    return mAccuracy;

            default: throw new IllegalArgumentException("Unknown Stat: " + stat);
        }
    }

    public MonsterStat applyRune(RuneSet runeSet)
    {
        RuneStat stat = runeSet.getTotalBonus();

        // TODO: mis-calc may occur, percentage result may not 100% accurate
        int hpPercentBonus = Util.percentage(mHp, stat.getStat(RuneStat.Stat.HP_PERCENT));
        int atkPercentBonus = Util.percentage(mAttack, stat.getStat(RuneStat.Stat.ATK_PERCENT));
        int defPercentBonus = Util.percentage(mDefense, stat.getStat(RuneStat.Stat.DEF_PERCENT));

        int newHp             = mHp      + stat.getStat(RuneStat.Stat.HP)  + hpPercentBonus;
        int newAttack         = mAttack  + stat.getStat(RuneStat.Stat.ATK) + atkPercentBonus;
        int newDefense        = mDefense + stat.getStat(RuneStat.Stat.DEF) + defPercentBonus;

        int newSpeed          = mSpeed          + stat.getStat(RuneStat.Stat.SPD);
        int newCriticalRate   = mCriticalRate   + stat.getStat(RuneStat.Stat.CRIT_RATE);
        int newCriticalDamage = mCriticalDamage + stat.getStat(RuneStat.Stat.CRIT_DMG);
        int newResistance     = mResistance     + stat.getStat(RuneStat.Stat.RESISTANCE);
        int newAccuracy       = mAccuracy       + stat.getStat(RuneStat.Stat.ACCURACY);

        MonsterStat monsterStat = new MonsterStat();

        monsterStat.setStat(Stat.HP,         newHp);
        monsterStat.setStat(Stat.ATK,        newAttack);
        monsterStat.setStat(Stat.DEF,        newDefense);
        monsterStat.setStat(Stat.SPD,        newSpeed);
        monsterStat.setStat(Stat.CRIT_RATE,  newCriticalRate);
        monsterStat.setStat(Stat.CRIT_DMG,   newCriticalDamage);
        monsterStat.setStat(Stat.RESISTANCE, newResistance);
        monsterStat.setStat(Stat.ACCURACY,   newAccuracy);

        return monsterStat;
    }

    public void clear()
    {
        mHp             = 0;
        mAttack         = 0;
        mDefense        = 0;
        mSpeed          = 0;
        mCriticalRate   = 0;
        mCriticalDamage = 0;
        mResistance     = 0;
        mAccuracy       = 0;
    }
}
