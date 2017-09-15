﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;


namespace ProjectEuler
    
{
    class Program
    {

        public void problem1()
        {
            /* If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
              Find the sum of all the multiples of 3 or 5 below 1000. */

            int sum = 0;

            for (int i = 0; i < 1000; i++)
            {
                if ((i % 3 == 0) || (i % 5 == 0))
                {
                    sum += i;
                }

            }

            Console.WriteLine("The sum of problem 1 is " + sum);
           

        }


        public void problem2()
        {
        
            /* Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
             * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
             * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms */


            long[] fib = { 2, 0 };
            int i = 0;
            long summed = 0;

            while (fib[i] < 4000000)
            {
                summed += fib[i];
                i = (i + 1) % 2;
                fib[i] = 4 * fib[(i + 1) % 2] + fib[i];
            }


            Console.WriteLine("The sum for problem 2 is " + summed);





        
        }

        public void problem3()

        {
            /* The prime factors of 13195 are 5, 7, 13 and What is the largest prime factor of the number 600851475143 ? */

            //This is an example commment





        }








        static void Main(string[] args)
        {
           Program p = new Program();
           p.problem1();
           p.problem2();
            Console.ReadKey();



        }
    }
}
