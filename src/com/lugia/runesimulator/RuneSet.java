package com.lugia.runesimulator;

public class RuneSet
{
    private Rune mRune1,
                 mRune2,
                 mRune3,
                 mRune4,
                 mRune5,
                 mRune6;

    public RuneSet()
    {
        mRune1 = new Rune();
        mRune2 = new Rune();
        mRune3 = new Rune();
        mRune4 = new Rune();
        mRune5 = new Rune();
        mRune6 = new Rune();
    }

    public Rune getRune(int slot)
    {
        switch (slot)
        {
            case 1: return mRune1;
            case 2: return mRune2;
            case 3: return mRune3;
            case 4: return mRune4;
            case 5: return mRune5;
            case 6: return mRune6;

            default: throw new IllegalArgumentException("Rune slot must between 1 to 6");
        }
    }

    public RuneStat getTotalBonus(/* boolean includeSetBonus */)
    {
        RuneStat stat = new RuneStat();

        stat.add(mRune1.getRuneStat())
            .add(mRune2.getRuneStat())
            .add(mRune3.getRuneStat())
            .add(mRune4.getRuneStat())
            .add(mRune5.getRuneStat())
            .add(mRune6.getRuneStat());

        //TODO: Set Bonus

        return stat;
    }
}
