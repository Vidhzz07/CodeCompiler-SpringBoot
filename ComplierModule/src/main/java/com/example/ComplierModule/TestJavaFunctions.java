package com.example.ComplierModule;


import java.util.*;

public class TestJavaFunctions
{
  void sumSeries(int n, double x)
  {
    double sum=0;

    for(int  i=1;i<=n;i++)
    {
      double term  = x/i;

      sum=sum+term;
    }
    System.out.println(sum);
  }

 static void series(int p)
  {
    for(int i=1;i<=p;i++)
    {
      System.out.println(Math.pow(i,3)-1);
    }
  }

    public static void main(String[] args) {

    series(9);


    }


}
