class ComplexNumCalculator {
    int nOpDone;
    double lastRes;
    void build(){
        this.nOpDone = 0;
        this.lastRes = 0;
    }
    ComplexNum add(ComplexNum c1, ComplexNum c2){
        ComplexNum res = new ComplexNum();
        res.build(c1.re+c2.re, c1.im+c2.im);
        return res;
    }
    ComplexNum sub(ComplexNum c1, ComplexNum c2){
        ComplexNum res = new ComplexNum();
        res.build(c1.re-c2.re, c1.im-c2.im);
        return res;
    }
    ComplexNum mul(ComplexNum c1, ComplexNum c2){
        ComplexNum res = new ComplexNum();
        double real = (c1.re * c2.re) - (c1.im * c2.im);    //(a+bi)*(c+di) = (ac-bd) + (ad+bc)
        double imm = (c1.re * c2.im) + (c1.im * c2.re);
        res.build(real, imm);
        return res;
    }
    ComplexNum div(ComplexNum c1, ComplexNum c2){
        ComplexNum res = new ComplexNum();
        double den = (c2.re*c2.re)+(c2.im*c2.im);   //Denominatore della forma standard del quoziente
        double real = (c1.re*c2.re)+(c1.im*c2.im);    //Calcolo parte reale
        double imm = (c1.im*c2.re)-(c1.re*c2.im);   //Calcolo parte immaginaria
        res.build((real/den), (imm/den)); //(a+bi)/(c+di) = [(ac+bd)/(c^2+d^2)] + [(bc-ad)/(c^2+d^2)]
        return res; 
    }
    ComplexNum div_alt(ComplexNum c1, ComplexNum c2){
        /*In alternativa si potrebbe calcolare il coniugato \
        * moltiplicandolo per c1, e si ottiene il risultato \
        * finale dividendo la parte reale e immaginaria del \
        * prodotto per il numero (reale) ottenuto dal prodotto \
        * tra c2 e il suo coniugato.
        */
        ComplexNum res = new ComplexNum();
        ComplexNum conj = new ComplexNum();
        ComplexNum tmp1 = new ComplexNum();
        ComplexNum tmp2 = new ComplexNum();

        conj.build(c2.re, -1.0*c2.im);      //Calcolo il coniugato del denominatore conj(a+bi) = (a-bi)

        tmp1 = mul(c1,conj);        //Moltiplico il numeratore per il coniugato
        tmp2 = mul(c2,conj);        //Moltiplico il denominatore per il coniugato

        res.build(tmp1.re / tmp2.re, tmp1.im / tmp2.re);    /*
                                                            * re(res) è il rapporto tra re(tmp1) e re(tmp2), 
                                                            * im(res) è il rapporto tra im(tmp1) e re(tmp2)
                                                            */
                                                            
        return res;
    }
    ComplexNum scalarMul(ComplexNum c, double x){
        c.re *= x;
        c.im *= x;
        return c;
    }
}
