class TestComplexNumCalculator {
  public static void main(String[] args) {
      ComplexNum c1 = new ComplexNum();
      c1.build(1,2);
      ComplexNum c2 = new ComplexNum();
      c2.build(2,3);
      ComplexNum res = new ComplexNum();
      ComplexNumCalculator calc = new ComplexNumCalculator();
      calc.build();
      res = calc.add(c1,c2);
      System.out.println("c1+c2= "+res.toStringRep());
      res = calc.sub(c1,c2);
      System.out.println("c1-c2= "+res.toStringRep());
      res = calc.mul(c1,c2);
      System.out.println("c1*c2= "+res.toStringRep());
      res = calc.div(c1,c2);
      System.out.println("c1/c2= "+res.toStringRep());
      res = calc.div_alt(c1,c2);
      System.out.println("c1/c2= "+res.toStringRep());
      res = calc.scalarMul(c1, 3);
      System.out.println("c1*scalare="+res.toStringRep());
      /*
       * 1) Testare la classe ComplexNumCalculator con le seguenti operazioni
       *    tra numeri complessi:
       *
       * - add(1+2i, 2+3i) = 3+5i
       *
       * - sub(4+5i, 6+7i) = -2-2i
       *
       * - mul(8+2i, 3-i) = 26 - 2i
       *
       * - ... altre a piacere
       *
       * 2) Verificare il corretto valore dei campi nOpDone, lastRes
       *
       * 3) Fare altre prove con operazioni a piacere
       */
  }
}
