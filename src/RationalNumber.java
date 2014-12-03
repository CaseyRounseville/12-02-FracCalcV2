// Write a class called RationalNumber that represents a fraction with an integer numerator and denominator
//Casey Rounseville
//9O
//12-2-2014
import java.lang.Math;
public class RationalNumber
{
  int numerator;
  int denominator;
  public RationalNumber()
  {
    numerator=0;
    denominator=1;
  }
  public RationalNumber(int num1,int num2)
  {
    numerator=num1;
    denominator=num2;
    if(denominator==0)
    {
      denominator=1;
    }
    if(denominator<0)
    {
      numerator*=-1;
      denominator=Math.abs(denominator);
    }
  }
  public int getDenominator()
  {
    return denominator;
  }
  public int getNumerator()
  {
    return numerator;
  }
  public int greatestCommonDivisor(int num1,int num2)
  {
    int temp=0;
    while(num2!=0)
    {
      temp=num2;
      num2=num1%num2;
      num1=temp;
    }
    return num1;
  }
  public String toString()
  {
    int gcd=greatestCommonDivisor(numerator,denominator);
    if(gcd<0)
    {
      gcd=Math.abs(gcd);
    }
    numerator/=gcd;
    denominator/=gcd;
    String fraction=numerator+"/"+denominator;
    if(denominator==1)
    {
      fraction=""+numerator;
    }
    return fraction;
  }
  public void add(RationalNumber frac)
  {
    int temp=denominator;
    denominator*=frac.denominator;
    numerator*=frac.denominator;
    frac.numerator*=temp;
    frac.denominator=denominator;
    numerator+=frac.numerator;
  }
  public void subtract(RationalNumber frac)
  {
    int temp=denominator;
    denominator*=frac.denominator;
    numerator*=frac.denominator;
    frac.numerator*=temp;
    frac.denominator=denominator;
    numerator-=frac.numerator;
  }
  public void multiply(RationalNumber frac)
  {
    numerator*=frac.numerator;
    denominator*=frac.denominator;
  }
  public void divide(RationalNumber frac)
  {
    int temp=frac.numerator;
    frac.numerator=frac.denominator;
    frac.denominator=temp;
    multiply(frac);
  }
}
