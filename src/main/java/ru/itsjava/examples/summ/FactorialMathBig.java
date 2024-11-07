package ru.itsjava.examples.summ;

import com.google.protobuf.StringValue;
import lombok.Getter;

import java.math.BigInteger;
import java.util.Scanner;

@Getter
public class FactorialMathBig {
    private BigInteger factorial = new BigInteger( String.valueOf(1));

    public void factorial() {
        Scanner count = new Scanner( System.in );
        System.out.println( "Введите число для вычисления факториала:" );
        factorial = count.nextBigInteger();
        factorialCount( factorial );
    }

    public BigInteger factorialCount(BigInteger a) {
        if (a.compareTo( BigInteger.ONE ) == 0 || a.compareTo( BigInteger.ZERO ) == 0) {
            return BigInteger.ONE;
        } else if (a.compareTo( BigInteger.ZERO ) < 0) {
            System.err.println( "факториал не сущуствует" );
            return BigInteger.ONE.negate();
        } else {
            return (factorial = a.multiply( factorialCount( a.subtract( BigInteger.ONE ) ) ));
        }

    }

    @Override
    public String toString() {
        return String.valueOf( new BigInteger( String.valueOf( getFactorial() ) ) );
    }

}
