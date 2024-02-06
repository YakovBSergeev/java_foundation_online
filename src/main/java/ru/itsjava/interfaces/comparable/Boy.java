package ru.itsjava.interfaces.comparable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Boy implements Comparable<Boy> {
    private final String name;
    private double age;
    private double high;


    @Override
    public int compareTo(Boy boy) {
        return (int) (high - boy.high);
    }

    public String getName() {
        return this.name;
    }

    public double getAge() {
        return this.age;
    }

    public double getHigh() {
        return this.high;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Boy)) return false;
        final Boy other = (Boy) o;
        if (!other.canEqual( (Object) this )) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals( other$name )) return false;
        if (Double.compare( this.getAge(), other.getAge() ) != 0) return false;
        if (Double.compare( this.getHigh(), other.getHigh() ) != 0) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Boy;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final long $age = Double.doubleToLongBits( this.getAge() );
        result = result * PRIME + (int) ($age >>> 32 ^ $age);
        final long $high = Double.doubleToLongBits( this.getHigh() );
        result = result * PRIME + (int) ($high >>> 32 ^ $high);
        return result;
    }

    public String toString() {
        return "Boy(name=" + this.getName() + ", age=" + this.getAge() + ", high=" + this.getHigh() + ")";
    }
}
